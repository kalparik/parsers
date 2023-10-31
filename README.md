# Parsers-CSV-XML-JSON
## Task #1: CSV - JSON parser
### Description
You have to write to the JSON file of the object obtained from the CSV file.

To work with the project, auxiliary libraries will be required, so you need to create a new project using the Gradle or Maven project builder. Next, write the dependencies for the following libraries: opencv, json-simple and gson.

As the initial information, create a file `data.csv` with the following contents and place it in the root of the created project:
```csv
1,John,Smith,USA,25
2,Ivanov,Petrov,RU,23
```
In addition, you will need the `Employee` class, which will contain information about employees. Note that parsing Java classes from CSV will require an empty class constructor.
```java
public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public String country;
    public int age;

    public Employee() {
        // Пустой конструктор
    }

    public Employee(long id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }   
}
``` 
As a result of the program, the file `data' should appear in the root of the project.json` with the following content:
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Smith",
    "country": "USA",
    "age": 25
  },
  {
    "id": 2,
    "firstName": "Inav",
    "lastName": "Petrov",
    "country": "RU",
    "age": 23
  }
]
```
## Task #2: XML - JSON parser
### Description
In this task, you have to write an object obtained from an XML file to a JSON file.

Perform this task within the framework of the project created in the previous task.

As the initial information, create a file data.xml with the following contents (put this file in the root of the project):
```xml
<staff>
    <employee>
        <id>1</id>
        <firstName>John</firstName>
        <lastName>Smith</lastName>
        <country>USA</country>
        <age>25</age>
    </employee>
    <employee>
        <id>2</id>
        <firstName>Inav</firstName>
        <lastName>Petrov</lastName>
        <country>RU</country>
        <age>23</age>
    </employee>
</staff>
```
As a result of the program, a data2 file should appear in the root of the project.json with content similar to the json file from the previous task

## Task #3*: JSON parser
### Description
In this task, you will have to read the JSON file, parse it and convert JSON objects into Java classes.

During the execution of the program in the console, you should see the following lines
```
Employee{id=1, firstName='John', lastName='Smith', country='USA', age=25}
Employee{id=2, firstName='Inav', lastName='Petrov', country='RU', age=23}
```
