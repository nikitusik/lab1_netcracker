package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {

    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("faculty")
    private String faculty;

    public Group(){}

    public Group(int id, String number, String faculty){
        this.id = id;
        this.number = number;
        this.faculty = faculty;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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
}
