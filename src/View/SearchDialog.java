package View;

import Controller.Controller;
import Model.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchDialog {

    private static final String NAME = "Имя студента";
    private static final String SURNAME = "Фамилия студента";
    private static final String PATRONYMIC = "Отчество студента";
    private static final String PARENT_NAME = "Имя отца";
    private static final String PARENT_SURNAME = "Фамилия отца";
    private static final String PARENT_PATRONYMIC = "Отчество отца";
    private static final String PARENT_NUMBER = "Номер адреса работы отца";
    private static final String PARENT_STREET = "Улица адреса работы отца";
    private static final String PARENT_POSITION = "Должность отца";
    private static final String PARENT_EXPERIENCE = "Стаж работы отца";

    public JDialog dialog;
    private MainFrame mainFrame;
    private Controller studentController;

    private JLabel labelName;
    private JLabel labelSurname;
    private JLabel labelPatronymic;
    private JLabel labelPName;
    private JLabel labelPSurname;
    private JLabel labelPPatronymic;
    private JLabel labelPNumber;
    private JLabel labelPStreet;
    private JLabel labelPPosition;
    private JLabel labelPExperience;   
    
    private JTextField jTextFieldName;
    private JTextField jTextFieldSurName;
    private JTextField jTextFieldPatronymic;
    private JTextField jTextFieldPName;
    private JTextField jTextFieldPSurname;
    private JTextField jTextFieldPPatronymic;
    private JTextField jTextFieldPNumber;
    private JTextField jTextFieldPStreet;
    private JTextField jTextFieldPPosition;
    private JTextField jTextFieldPExperience;
 
    private JButton searchButtonFIOStudent;   
    private JButton searchButtonFIOParent;   
    private JButton searchButtonParentExperience;   
    private JButton searchButtonParentAddress;   
    
    public SearchDialog(Controller controller, MainFrame mainFrame) {
        this.studentController = controller;
        this.mainFrame = mainFrame;
        dialog = new JDialog();
        dialog.setTitle("Поиск студента");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(450, 550);
        
        JPanel panel = new JPanel();        
        labelName = new JLabel(NAME);
        labelSurname = new JLabel(SURNAME);
        labelPatronymic = new JLabel(PATRONYMIC);
        labelPName = new JLabel(PARENT_NAME);
        labelPSurname = new JLabel(PARENT_SURNAME);
        labelPPatronymic = new JLabel(PARENT_PATRONYMIC);
        labelPNumber = new JLabel(PARENT_NUMBER);
        labelPStreet = new JLabel(PARENT_STREET);
        labelPPosition = new JLabel(PARENT_POSITION);
        labelPExperience = new JLabel(PARENT_EXPERIENCE);
        
        jTextFieldName = new JTextField(20);
        jTextFieldSurName = new JTextField(20);
        jTextFieldPatronymic = new JTextField(20);
        jTextFieldPName = new JTextField(20);
        jTextFieldPSurname = new JTextField(20);
        jTextFieldPPatronymic = new JTextField(20);
        jTextFieldPNumber = new JTextField(20);
        jTextFieldPStreet = new JTextField(20);
        jTextFieldPPosition = new JTextField(20);
        jTextFieldPExperience = new JTextField(20);
        jTextFieldSurName = new JTextField(20);
        jTextFieldSurName = new JTextField(20);
        jTextFieldSurName = new JTextField(20);
        
        searchButtonFIOStudent = new JButton("ФИО студента"); 
        searchButtonFIOParent = new JButton("ФИО родителя");   
        searchButtonParentExperience = new JButton("Стаж работы");   
        searchButtonParentAddress = new JButton("Место работы");   
        
        Box box = Box.createVerticalBox();
        box.add(labelSurname);
        box.add(jTextFieldSurName);
        box.add(labelName);
        box.add(jTextFieldName);        
        box.add(labelPatronymic);
        box.add(jTextFieldPatronymic);
        box.add(labelPName);
        box.add(jTextFieldPName);
        box.add(labelPSurname);
        box.add(jTextFieldPSurname);
        box.add(labelPPatronymic);
        box.add(jTextFieldPPatronymic);
        box.add(labelPNumber);
        box.add(jTextFieldPNumber);
        box.add(labelPStreet);
        box.add(jTextFieldPStreet);
        box.add(labelPPosition);
        box.add(jTextFieldPPosition);
        box.add(labelPExperience);
        box.add(jTextFieldPExperience);
        box.add(searchButtonFIOStudent);
        box.add(searchButtonFIOParent);
        box.add(searchButtonParentExperience);
        box.add(searchButtonParentAddress);
        panel.add(box);
        dialog.add(panel); 

        searchButtonFIOStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                student.setName(jTextFieldName.getText());
                student.setSurname(jTextFieldSurName.getText());
                student.setPatronymic(jTextFieldPatronymic.getText());
                
                controller.searchFIOStudent(student);
                dialog.setVisible(false);
                mainFrame.update();
            }
        });
        
        dialog.setVisible(true);

        searchButtonFIOParent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                student.setParentName(jTextFieldPName.getText());
                student.setParentSurname(jTextFieldPSurname.getText());
                student.setParentPatronymic(jTextFieldPPatronymic.getText());

                controller.searchFIOParent(student);
                dialog.setVisible(false);
                mainFrame.update();
            }
        });
        
        dialog.setVisible(true);

        searchButtonParentExperience.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                student.setName(jTextFieldName.getText());
                student.setParentExperience(jTextFieldPExperience.getText()); 
                
                controller.searchParentExperience(student);
                dialog.setVisible(false);
                mainFrame.update();
            }
        });
        
        dialog.setVisible(true);

        searchButtonParentAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                student.setParentStreet(jTextFieldPStreet.getText());
                student.setParentNumber(jTextFieldPNumber.getText());
                
                controller.searchParentAddress(student);
                dialog.setVisible(false);
                mainFrame.update();
            }
        });
        
        dialog.setVisible(true);        
    }   
} 
