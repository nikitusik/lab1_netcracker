package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Group;
import model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentDaoImpl implements StudentDao {
    private final ObservableList<Student> students = FXCollections.observableArrayList();
    //private static final List<Student> students = new ArrayList<>();

    public void create(Student student) {
        boolean isExist = false;
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            students.add(student);
        }

    }


    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void edit(Student student) {

        students.set(student.getId(), student);
    }

    public Student getById(int id) {
        return students.get(id);
    }

    public List<Student> getAll() {
        return students;
    }
}
