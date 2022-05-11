package protectmypasswords.module;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonModule {

    public static void main(String[] args) throws IOException, JsonException {

      //  JsonObject currentFile = readJson("private.bin");
        final JsonModule obj = new JsonModule();

        JsonObject objToAdd = new UserData("qwe","rttyt","yui").toJsonObj();
   //     List<JsonObject> userJsonDataObj = new ArrayList<JsonObject>();


        /*

        JsonArray rest = (JsonArray) currentFile.get("MyuniquePassword");
        int id = 0;
        for(int i =0; i < rest.toArray().length; i++){
            JsonObject test = (JsonObject) rest.get(i);
            userJsonDataObj.add(test);
        }

        userJsonDataObj.add(objToAdd);




        Map<String, List<JsonObject>> myOBJ = new HashMap<>();
        myOBJ.put("MyuniquePassword", userJsonDataObj);

        String json = Jsoner.serialize(myOBJ);
        System.out.println(json);

        System.out.println(currentFile);

        */

/*
        System.out.println(currentFile);
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<UserData> pp3 = mapper.readValue(currentFile, new TypeReference<List<UserData>>() {});
            List<UserData> ppl2 = Arrays.asList(mapper.readValue(currentFile, UserData[].class));
            System.out.println("\nAlternative...");
            pp3.stream().forEach(x -> System.out.println(x));

        } catch (IOException e) {
            e.printStackTrace();
        }



        UserData userData = new UserData("link","Mohamed","NEIU");
      //  currentFile.;
        // Java objects to JSON String
        String json = Jsoner.serialize(userData);

        // pretty print
        json = Jsoner.prettyPrint(json);
  //      byte[] jsonArr = json.getBytes(StandardCharsets.UTF_8);
        System.out.println(json);

        // Java objects to JSON file
        try (FileWriter fileWriter = new FileWriter("serializedFile.bin")) {
            Jsoner.serialize(json, fileWriter);
        }


        JsonArray rest = (JsonArray) db.get("restaurants");
        int id = 0;
        for(int i =0; i < rest.toArray().length; i++){
            JsonObject test = (JsonObject) rest.get(i);
            if(test.get("name").equals(name)){
                id = i;
                break;
            }
        }
        return (JsonObject) rest.get(id);
*/

    }


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

        System.out.print("I made it");

                    return userJsonDataObj;
        }

}

