package View;

import Controller.Controller;
import Model.Student;
import Model.TableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class MainFrame {

    private JFrame mainFrame;
    private Controller controller;
    private JTable table;


    public MainFrame(Controller controller) {
        this.controller = controller;
        mainFrame = new JFrame("MVC");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setJMenuBar(createFileMenu());
        List<Student> students = controller.getStudents();
        TableModel tableModel = new Model.TableModel(students);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 400));
        mainFrame.add(scrollPane);
        mainFrame.add(createToolBar(), BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    private JMenuBar createFileMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem openFile = new JMenuItem("Открыть");
        fileMenu.add(openFile);
        JMenuItem saveFile = new JMenuItem("Сохранить");
        fileMenu.add(saveFile);
        JMenuItem exit = new JMenuItem("Выход");
        fileMenu.add(exit);

        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Сохранить файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
                        Document doc = documentBuilder.newDocument();
                        Element rootElement = doc.createElement("students");
                        doc.appendChild(rootElement);

                        for (Student stud : controller.getStudents()) {
                            Element student = doc.createElement("student");
                            rootElement.appendChild(student);

                            Element surname = doc.createElement("surname");
                            surname.appendChild(doc.createTextNode(stud.getSurname()));
                            student.appendChild(surname);

                            Element name = doc.createElement("name");
                            name.appendChild(doc.createTextNode(stud.getName()));
                            student.appendChild(name);

                            Element patronymic = doc.createElement("patronymic");
                            patronymic.appendChild(doc.createTextNode(stud.getPatronymic()));
                            student.appendChild(patronymic);

                            Element parentSurname = doc.createElement("parentSurname");
                            parentSurname.appendChild(doc.createTextNode(stud.getParentSurname()));
                            student.appendChild(parentSurname);

                            Element parentName = doc.createElement("parentName");
                            parentName.appendChild(doc.createTextNode(stud.getParentName()));
                            student.appendChild(parentName);

                            Element parentPatronymic = doc.createElement("parentPatronymic");
                            parentPatronymic.appendChild(doc.createTextNode(stud.getParentPatronymic()));
                            student.appendChild(parentPatronymic);

                            Element parentStreet = doc.createElement("parentStreet");
                            parentStreet.appendChild(doc.createTextNode(stud.getParentStreet()));
                            student.appendChild(parentStreet);

                            Element parentNumber = doc.createElement("parentNumber");
                            parentNumber.appendChild(doc.createTextNode(stud.getParentNumber()));
                            student.appendChild(parentNumber);

                            Element parentPosition = doc.createElement("parentPosition");
                            parentPosition.appendChild(doc.createTextNode(stud.getParentPosition()));
                            student.appendChild(parentPosition);

                            Element parentExperience = doc.createElement("parentExperience");
                            parentExperience.appendChild(doc.createTextNode(stud.getParentExperience()));
                            student.appendChild(parentExperience);

                            TransformerFactory transformerFactory = TransformerFactory.newInstance();
                            Transformer transformer = transformerFactory.newTransformer();
                            DOMSource domSource = new DOMSource(doc);
                            StreamResult streamResult = new StreamResult(new File(file.getPath() + ".xml"));

                            transformer.transform(domSource, streamResult);

                        }
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TransformerConfigurationException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TransformerException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        SAXParserFactory factory = SAXParserFactory.newInstance();
                        SAXParser parser = factory.newSAXParser();
                        XMLHandler handl = new XMLHandler();

                        parser.parse(new File(file.getPath()), handl);

                        List<Student> students = handl.getResult();
                        for (Student student : students) {
                            controller.addStudent(student);
                        }

                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                update();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(fileMenu);
        return menuBar;
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        JButton save = new JButton("Сохранить");
        JButton open = new JButton("Открыть");
        JButton search = new JButton("Поиск");
        JButton add = new JButton("Добавить");
        JButton remove = new JButton("Удалить");

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Сохранить файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
                        Document doc = documentBuilder.newDocument();
                        Element rootElement = doc.createElement("students");
                        doc.appendChild(rootElement);

                        for (Student stud : controller.getStudents()) {
                            Element student = doc.createElement("student");
                            rootElement.appendChild(student);

                            Element surname = doc.createElement("surname");
                            surname.appendChild(doc.createTextNode(stud.getSurname()));
                            student.appendChild(surname);

                            Element name = doc.createElement("name");
                            name.appendChild(doc.createTextNode(stud.getName()));
                            student.appendChild(name);

                            Element patronymic = doc.createElement("patronymic");
                            patronymic.appendChild(doc.createTextNode(stud.getPatronymic()));
                            student.appendChild(patronymic);

                            Element parentSurname = doc.createElement("parentSurname");
                            parentSurname.appendChild(doc.createTextNode(stud.getParentSurname()));
                            student.appendChild(parentSurname);

                            Element parentName = doc.createElement("parentName");
                            parentName.appendChild(doc.createTextNode(stud.getParentName()));
                            student.appendChild(parentName);

                            Element parentPatronymic = doc.createElement("parentPatronymic");
                            parentPatronymic.appendChild(doc.createTextNode(stud.getParentPatronymic()));
                            student.appendChild(parentPatronymic);

                            Element parentStreet = doc.createElement("parentStreet");
                            parentStreet.appendChild(doc.createTextNode(stud.getParentStreet()));
                            student.appendChild(parentStreet);

                            Element parentNumber = doc.createElement("parentNumber");
                            parentNumber.appendChild(doc.createTextNode(stud.getParentNumber()));
                            student.appendChild(parentNumber);

                            Element parentPosition = doc.createElement("parentPosition");
                            parentPosition.appendChild(doc.createTextNode(stud.getParentPosition()));
                            student.appendChild(parentPosition);

                            Element parentExperience = doc.createElement("parentExperience");
                            parentExperience.appendChild(doc.createTextNode(stud.getParentExperience()));
                            student.appendChild(parentExperience);

                            TransformerFactory transformerFactory = TransformerFactory.newInstance();
                            Transformer transformer = transformerFactory.newTransformer();
                            DOMSource domSource = new DOMSource(doc);
                            StreamResult streamResult = new StreamResult(new File(file.getPath() + ".xml"));

                            transformer.transform(domSource, streamResult);

                        }
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TransformerConfigurationException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TransformerException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        SAXParserFactory factory = SAXParserFactory.newInstance();
                        SAXParser parser = factory.newSAXParser();
                        XMLHandler handl = new XMLHandler();

                        parser.parse(new File(file.getPath()), handl);

                        List<Student> students = handl.getResult();
                        for (Student student : students) {
                            controller.addStudent(student);
                        }

                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                update();
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchDialog(controller, MainFrame.this);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(controller, MainFrame.this);
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteDialog(controller, MainFrame.this);
            }
        });

        toolBar.add(save);
        toolBar.add(open);
        toolBar.add(search);
        toolBar.add(add);
        toolBar.add(remove);

        return toolBar;
    }

    void update() {
        TableModel tableModel = new Model.TableModel(controller.getStudents());
        table.setModel(tableModel);
    }
}