package protectmypasswords.module;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class JsonModule1 {

    public String readFile(String filename) {
        String contents = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
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

    public JsonObject readJson(String filename){

        String data = readFile(filename);
        JsonObject document = (JsonObject)Jsoner.deserialize(data,new JsonObject());
        return document;
    }
}