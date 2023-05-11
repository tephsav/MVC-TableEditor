package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private List<Student> students;

    public TableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "ФИО студента";
                break;
            case 1:
                result = "ФИО отца";
                break;
            case 2:
                result = "Адрес работы отца";
                break;
            case 3:
                result = "Должность отца";
                break;
            case 4:
                result = "Стаж работы отца";
                break;
        }
        return result;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return students.get(rowIndex).getSurname() + " " + students.get(rowIndex).getName() + " " + students.get(rowIndex).getPatronymic();
            case 1:
                return students.get(rowIndex).getParentSurname() + " " + students.get(rowIndex).getParentName() + " " + students.get(rowIndex).getParentPatronymic();
            case 2:
                return students.get(rowIndex).getParentStreet() + " " + students.get(rowIndex).getParentNumber();
            case 3:
                return students.get(rowIndex).getParentPosition();
            case 4:
                return students.get(rowIndex).getParentExperience();
            default:
                return "";
        }
    }
}