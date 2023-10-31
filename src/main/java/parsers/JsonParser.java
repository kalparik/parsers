package ru.netology.lipatnikova.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import ru.netology.lipatnikova.Employee;

public class JsonParser {
    public static String readString(String fileName) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray.toString();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Employee> jsonToList(String jsonStr) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<Employee> employeeList = gson.fromJson(jsonStr, new TypeToken<List<Employee>>() {
        }.getType());
        return employeeList;
    }
}
