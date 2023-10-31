package ru.netology.lipatnikova.parsers;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.netology.lipatnikova.Employee;

public class XmlToJsonParser {
    public static List<Employee> parseXml(String fileName) {
        List<Employee> employees = null;
        try {
            //Get a Document - object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));

            //Read *.xml
            employees = readXml(doc);
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            ex.printStackTrace();
        }
        return employees;
    }

    private static List<Employee> readXml(Document doc) {
        List<Employee> employees = new ArrayList<>();
        Node root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node_ = nodeList.item(i);
            if (Node.ELEMENT_NODE == node_.getNodeType()) {
                Element employee = (Element) node_;

                employees.add(new Employee(Long.parseLong(getXmlContent(employee, "id")),
                        getXmlContent(employee, "firstName"),
                        getXmlContent(employee, "lastName"),
                        getXmlContent(employee, "country"),
                        Integer.parseInt(getXmlContent(employee, "age"))));
            }
        }
        return employees;
    }

    public static String getXmlContent(Element element, String field) {
        return element.getElementsByTagName(field).item(0).getTextContent();
    }
}
