package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonResponseReader {
    public JsonObject toJsonObject(InputStream json) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(json));
        StringBuilder builder = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            // todo
        }

        return (JsonObject) (new JsonParser()).parse(builder.toString());
    }
}
