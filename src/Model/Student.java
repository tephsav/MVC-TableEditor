package Model;

public class Student {
    private String name;
    private String surname;
    private String patronymic;

    private String parentName;
    private String parentSurname;
    private String parentPatronymic;
    private String parentStreet;
    private String parentNumber;
    private String parentPosition;
    private String parentExperience;

    public Student(String name, String surname, String patronymic,
                   String parentName, String parentSurname, String parentPatronymic,
                   String parentStreet, String parentNumber,
                   String parentPosition, String parentExperience) {

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.parentName = parentName;
        this.parentSurname = parentSurname;
        this.parentPatronymic = parentPatronymic;
        this.parentStreet = parentStreet;
        this.parentNumber = parentNumber;
        this.parentPosition = parentPosition;
        this.parentExperience = parentExperience;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentSurname() {
        return parentSurname;
    }

    public void setParentSurname(String parentSurname) {
        this.parentSurname = parentSurname;
    }

    public String getParentPatronymic() {
        return parentPatronymic;
    }

    public void setParentPatronymic(String parentPatronymic) {
        this.parentPatronymic = parentPatronymic;
    }

    public String getParentStreet() {
        return parentStreet;
    }

    public void setParentStreet(String parentStreet) {
        this.parentStreet = parentStreet;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber;
    }

    public String getParentPosition() {
        return parentPosition;
    }

    public void setParentPosition(String parentPosition) {
        this.parentPosition = parentPosition;
    }

    public String getParentExperience() {
        return parentExperience;
    }

    public void setParentExperience(String parentExperience) {
        this.parentExperience = parentExperience;
    }
}
