package project.netcracker.service;

import project.netcracker.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    void create(Student student) throws IOException;
    void delete(int id) throws IOException;
    void edit(Student student) throws IOException;
    Student getById(int id);
    List<Student> getAll() throws IOException;
}
