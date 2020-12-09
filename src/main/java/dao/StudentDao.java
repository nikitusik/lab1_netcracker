package dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    void create(Student student);
    void delete(int id);
    void edit(Student student);
    Student getById(int id);
    List<Student> getAll();
}
