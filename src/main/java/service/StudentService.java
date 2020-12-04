package service;

import model.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);
    void delete(Student student);
    void edit(Student student);
    Student getById(int id);
    List<Student> getAll();
}
