package dao;

import model.Group;
import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentDaoImpl implements Dao<Student> {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static final Map<Integer, Student> students = new HashMap<>();
    public void create(Student student) {
        student.setId(AUTO_ID.getAndIncrement());
        students.put(student.getId(), student);
    }

    public void delete(Student student) {
        students.remove(student.getId());
    }

    public void edit(Student student) {
        students.put(student.getId(), student);
    }

    public Student getById(int id) {
        return students.get(id);
    }

    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }
}
