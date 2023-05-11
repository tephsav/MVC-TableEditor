package Controller;

import Model.Model;
import Model.Student;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;

public class Controller {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public List<Student> getStudents() {
        return model.getStudents();
    }

    public void addStudent(Student newStudent) {
        model.addStudent(newStudent);
    }

    public void removeFIOStudent(Student removingStudent) {
        int numbers = 0;
        Iterator<Student> iterator = model.getStudents().iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals(removingStudent.getName()) &&
                    student.getSurname().equals(removingStudent.getSurname()) &&
                    student.getPatronymic().equals(removingStudent.getPatronymic())) {

                iterator.remove();
                numbers++;
            }
        }
        JOptionPane.showMessageDialog(null, "Удалено записей: " + numbers);
    }

    public void removeFIOParent(Student removingStudent) {
        int numbers = 0;
        Iterator<Student> iterator = model.getStudents().iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getParentName().equals(removingStudent.getParentName()) &&
                    student.getParentSurname().equals(removingStudent.getParentSurname()) &&
                    student.getParentPatronymic().equals(removingStudent.getParentPatronymic())) {

                iterator.remove();
                numbers++;
            }
        }
        JOptionPane.showMessageDialog(null, "Удалено записей: " + numbers);
    }

    public void removeParentExperience(Student removingStudent) {
        int numbers = 0;
        Iterator<Student> iterator = model.getStudents().iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getParentExperience().equals(removingStudent.getParentExperience())) {

                iterator.remove();
                numbers++;
            }
        }
        JOptionPane.showMessageDialog(null, "Удалено записей: " + numbers);
    }

    public void removeParentAddress(Student removingStudent) {
        int numbers = 0;
        Iterator<Student> iterator = model.getStudents().iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getParentStreet().equals(removingStudent.getParentStreet()) &&
                    student.getParentNumber().equals(removingStudent.getParentNumber())) {

                iterator.remove();
                numbers++;
            }
        }
        JOptionPane.showMessageDialog(null, "Удалено записей: " + numbers);
    }


    public void searchFIOStudent(Student removingStudent) {

        Iterator<Student> iterator = model.getStudents().iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (!(student.getName().equals(removingStudent.getName())) &&
                    !(student.getSurname().equals(removingStudent.getSurname())) &&
                    !(student.getPatronymic().equals(removingStudent.getPatronymic()))) {

                iterator.remove();
            }
        }
    }

    public void searchFIOParent(Student removingStudent) {

        Iterator<Student> iterator = model.getStudents().iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (!(student.getParentName().equals(removingStudent.getParentName())) &&
                    !(student.getParentSurname().equals(removingStudent.getParentSurname())) &&
                    !(student.getParentPatronymic().equals(removingStudent.getParentPatronymic()))) {

                iterator.remove();
            }
        }
    }

    public void searchParentExperience(Student removingStudent) {

        Iterator<Student> iterator = model.getStudents().iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (!(student.getParentExperience().equals(removingStudent.getParentExperience()))) {

                iterator.remove();
            }
        }
    }

    public void searchParentAddress(Student removingStudent) {

        Iterator<Student> iterator = model.getStudents().iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (!(student.getParentStreet().equals(removingStudent.getParentStreet())) &&
                    !(student.getParentNumber().equals(removingStudent.getParentNumber()))) {

                iterator.remove();
            }
        }
    }
}