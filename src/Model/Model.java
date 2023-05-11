package Model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Student> students;

    public Model() {
        students = new ArrayList<>();
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void removeStudent(Student removingStudent) {
        students.remove(removingStudent);
    }

    public List<Student> getStudents() {
        return students;
    }
}