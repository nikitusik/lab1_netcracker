package project.netcracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDate;
import java.util.Date;


public class Student {


    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("group")
    private Group group;

    @JsonProperty("dateOfEnrollment")
    private LocalDate dateOfEnrollment;

    public Student() {
    }

    public Student(String name, Group group, LocalDate dateOfEnrollment) {
        this.name = name;
        this.group = group;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public String toString() {
        return "Имя студента: " + name +
                ", Группа: " + group.getNumber() +
                ", Дата зачисления: " + dateOfEnrollment;
    }
}
