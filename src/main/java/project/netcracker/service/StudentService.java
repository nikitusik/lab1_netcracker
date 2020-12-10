package project.netcracker.service;

import project.netcracker.model.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);
    void delete(int id);
    void edit(Student student);
    Student getById(int id);
    List<Student> getAll();
}
