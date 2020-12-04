package dao;

import model.Group;
import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentDaoImpl implements StudentDao {
    private static final List <Student> students = new ArrayList<>();
    public void create(Student student) {
        students.add(student);
    }

    public void delete(Student student) {
        students.remove(student.getId());
    }

    public void edit(Student student) {
        students.add(student.getId(), student);
    }

    public Student getById(int id) {
        return students.get(id);
    }

    public List<Student> getAll() {
        return students;
    }
}
