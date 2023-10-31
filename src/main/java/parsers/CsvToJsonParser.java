package ru.netology.lipatnikova.parsers;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.netology.lipatnikova.Employee;

public class CsvToJsonParser {
    public static List<Employee> parseCSV(String[] columnMapping, String fileName) {
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {

            //Linking the data from the csv-file with the Employee.class
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);

            //Creating a tool for the interaction of a csv-file and strategy
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();

            //Parsing the csv-file to the list of objects
            List<Employee> staff = csv.parse();
            csvReader.close();
            return staff;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
