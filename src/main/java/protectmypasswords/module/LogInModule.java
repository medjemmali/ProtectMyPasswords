package protectmypasswords.module;

import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;


public class LogInModule {


    public boolean checkUsersFile(String password){
        //FileName represent the 15 first characters of an encrypted password
            File f = new File(password.substring(0,15) + ".bin");

            if(f.exists())
                return true;

            return false;
    }

    public String encryptPassword(String password) throws NoSuchAlgorithmException {

            // SHA3-256 Hashing method
            // Method has been tested and works correctly

            MessageDigest md = MessageDigest.getInstance("SHA3-256");
            byte[]hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

                // creating Inner class to convert the Bytes array to a String
                    class BytesToHex{
                        static String bytesToHex(final byte[] hashInBytes) {
                            // Lambda Expressions used here
                            return IntStream.range(0, hashInBytes.length)
                                    .collect(StringBuilder::new,
                                            (sb,i)->new Formatter(sb).format("%02x", hashInBytes[i]&0xff),
                                            StringBuilder::append).toString();
                        }
                    }
            return BytesToHex.bytesToHex(hashInBytes);
        }


        //The method checks if private.json already exist, otherwise will create one.
        public static Boolean registerNewUser(String masterPassword) throws IOException {
            try {

                    //FileName represent the 15 first characters of an encrypted password
                    // Randomly chosen, but should be applied always when we look for a file
                    // It will be registered on Binary format
                     String fileName = masterPassword.substring(0,15) + ".bin";

                    // Prepare information about the user registration date
                    // This will be the first data inserted on the Json file.
                    Date date = new Date();
                    SimpleDateFormat  formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                    String strDateArr [] = formatter.format(date).split(" ");

                    //  UserData object used to keep inserted data in the correct type
                    List<UserData> firstUserDataList = new LinkedList<UserData>();
                    firstUserDataList.add(new UserData("User Registered Date",strDateArr[0],strDateArr[1]));

                    //  UserAccountData object used to be inserted to the file
                    UserAccountData newFileDataMap = new UserAccountData(masterPassword, firstUserDataList);

                    // Java objects to JSON String
                    String serializeData = Jsoner.serialize(newFileDataMap);
                    System.out.println(serializeData);

                    // When Json Object ready, data will be saved to file
                    try(FileWriter fileWriter = new FileWriter(fileName)){
                        Jsoner.serialize(serializeData, fileWriter);
                    }

                    return true;
            } catch (IOException e) {
                    e.printStackTrace();

            }
            return false;
        }

        public  String registerUser(String password){
/*
            JSONObject websiteDetails = new JSONObject();
            websiteDetails.put("URL", "Lokesh");

            JSONObject userObject = new JSONObject();
            userObject.put(password, userDetails);

            //Add employees to list
            JSONArray userList = new JSONArray();
            userList.add(userObject);

            //Write JSON file
            try (FileWriter file = new FileWriter("userList.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(userList.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
*/
            return "good";
        }

}
