package project.netcracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {

    @JsonProperty("number")
    private String number;

    @JsonProperty("faculty")
    private String faculty;

    public Group() {
    }

    public Group(String number, String faculty) {
        this.number = number;
        this.faculty = faculty;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Номер группы: " + number +
                ", Факультет: " + faculty;
    }
}
