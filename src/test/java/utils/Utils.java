package utils;

import config.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void saveJsonUser(UserModel userModel) throws IOException, ParseException {
        //json file located
        String jsonFileLocation = "./src/test/resources/users.json";
        //using json simple
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(jsonFileLocation));

        JSONObject userObject = new JSONObject();

        userObject.put("firstName", userModel.getFirstName());
        userObject.put("lastName", userModel.getLastName());
        userObject.put("employeeId", userModel.getEmployeeId());
        userObject.put("userName", userModel.getUserName());
        userObject.put("password", userModel.getPassword());

        jsonArray.add(userObject);

        FileWriter writer = new FileWriter(jsonFileLocation);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }

    public static JSONArray getUserJson() throws IOException, ParseException {
        String jsonFileLocation = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        return (JSONArray) jsonParser.parse(new FileReader(jsonFileLocation));
    }
}
