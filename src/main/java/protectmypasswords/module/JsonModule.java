package protectmypasswords.module;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonModule {


    public static boolean addNewDataToFile(String fileName, String password, UserData objToAdd) throws JsonException, IOException {

        final JsonModule obj = new JsonModule();
        JsonObject currentFile = obj.readJson(fileName);


       // Create a list to read the file, and insert data on it
        List<JsonObject> userJsonDataObj = new ArrayList<JsonObject>();

        JsonArray rest = (JsonArray) currentFile.get(password);

        //Read the file, insert data to the List
        int id = 0;
        for(int i =0; i < rest.toArray().length; i++){
            JsonObject test = (JsonObject) rest.get(i);
            userJsonDataObj.add(test);
        }
        // add the new Object
        userJsonDataObj.add(objToAdd.toJsonObj());

        // Prepare the Map object, and apply serialization and update  the file
        Map<String, List<JsonObject>> myOBJ = new HashMap<>();
        myOBJ.put(password, userJsonDataObj);

        String json = Jsoner.serialize(myOBJ);

        //insert data to the file
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            Jsoner.serialize(json, fileWriter);
        }catch(IOException e){
            e.printStackTrace();
            System.exit(-1);
        }

        return true;

    }


    public  JsonObject readJson(String fileName) throws JsonException {

        // This method will read the file and return a Json Object
        // One of the challenges I faced here, after reading the file, if the string
        //not corrected, deserialize will not return an Object
        String data = readFile(fileName);

        data = data.replaceAll("\\\\", "");
        data = data.substring(1,data.length());
      //  data = Jsoner.prettyPrint(data);

        JsonObject document = (JsonObject)Jsoner.deserialize(data,new JsonObject());
        return document;

    }

    public  String readFile(String fileName) {
        String contents = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s = reader.readLine();
            while (s != null) {
                contents += s;
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return contents;
    }

    public static List<UserData> jsonFileToList(String fileName, String password) throws JsonException {


        JsonModule obj = new JsonModule();
        JsonObject currentFile = obj.readJson(fileName);

        // Create a list to read the file, and insert data on it
        List<UserData> userJsonDataObj = new ArrayList<UserData>();
        JsonArray rest = (JsonArray) currentFile.get(password);


        //Read the file, insert data to the List
        int id = 0;
        for(int i =1; i < rest.toArray().length; i++){
            JsonObject test = (JsonObject) rest.get(i);
            userJsonDataObj.add(new UserData(test.get("addressUrl").toString(),
                    test.get("userName").toString(), test.get("password").toString()));

        }


                    return userJsonDataObj;
        }
        public boolean changeFileName(String oldName, String newName) throws IOException {
            // Create an object of the File class current file
            File file = new File("oldName");

            // Replace the file path with path of the directory
            File rename = new File("newName");


            System.out.println("Old File name " + oldName);
            System.out.println("New File Name " + newName);
            // store the return value of renameTo() method in
            // flag
     //       boolean flag = file.renameTo(rename);


     //       File newFile = new File(oldName, newName);
       //     Files.move(oldName, newFile);


            Path yourFile = Paths.get(oldName);

            Files.move(yourFile, yourFile.resolveSibling(newName));
           // Files.move(oldName, source.resolveSibling("newname"));
            // if renameTo() return true then if block is
            // executed
            if (true == true) {

                System.out.println("File name has changed");
                return true;
            }
            else {
                return false;
            }
        }
}

