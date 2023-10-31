package ru.netology.lipatnikova;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static ru.netology.lipatnikova.parsers.CsvToJsonParser.parseCSV;
import static ru.netology.lipatnikova.parsers.JsonParser.jsonToList;
import static ru.netology.lipatnikova.parsers.JsonParser.readString;
import static ru.netology.lipatnikova.parsers.XmlToJsonParser.parseXml;

public class Main {

    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};

        //Task#1: Parsing CSV->JSON
        String csvName = "data.csv";
        String jsonName = "data.json";
        List<Employee> list = parseCSV(columnMapping, csvName);
        String json = listToJson(list);
        writeString(json, jsonName);

        //Task#2: Parsing XML->JSON
        String xmlName = "data.xml";
        jsonName = "data2.json";
        list = parseXml(xmlName);
        json = listToJson(list);
        writeString(json, jsonName);

        //Task#3*: JSON parser
        jsonName = "new_data.json";
        json = readString(jsonName);
        list = jsonToList(json);
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
        //System.out.println(list.toString());
    }

    public static String listToJson(List<Employee> list) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        String json = gson.toJson(list, listType);
        return json;
    }

    public static void writeString(String json, String fileNameJson) {
        try (FileWriter file = new FileWriter(fileNameJson)) {
            file.write(json);
            file.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
