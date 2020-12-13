package project.netcracker.dao;

import project.netcracker.model.Student;

import java.util.List;

public interface StudentDao {
    void create(Student student);
    void delete(int id);
    void edit(Student student);
    Student getStudentByName(String name);
    Student getById(int id);
    List<Student> getAll();
}
