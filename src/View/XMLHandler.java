package View;

import Model.Student;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    private String element;
    private List<Student> students;
    private Student student;

    public XMLHandler() {
        students = new ArrayList<>();
    }

    public List<Student> getResult() {
        return students;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        element = qName;

        if (element.equalsIgnoreCase("student")) {
            student = new Student();
            students.add(student);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element.equalsIgnoreCase("surname")) {
            student.setSurname(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("name")) {
            student.setName(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("patronymic")) {
            student.setPatronymic(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("parentSurname")) {
            student.setParentSurname(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("parentName")) {
            student.setParentName(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("parentPatronymic")) {
            student.setParentPatronymic(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("parentStreet")) {
            student.setParentStreet(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("parentNumber")) {
            student.setParentNumber(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("parentPosition")) {
            student.setParentPosition(new String(ch, start, length));
        }

        if (element.equalsIgnoreCase("parentExperience")) {
            student.setParentExperience(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = "";
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}
