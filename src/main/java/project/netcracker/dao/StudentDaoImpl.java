package project.netcracker.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.netcracker.model.Student;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final static String studentFile = "student.json";

    private final ObservableList<Student> students = FXCollections.observableArrayList();

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private final ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Student>>() {});
    private final ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

    public void create(Student student) throws IOException {
        AtomicInteger AUTO_ID = new AtomicInteger(students.size());
        student.setId(AUTO_ID.getAndIncrement());
        students.add(student);
        saveStudents();
    }


    public void delete(int id) throws IOException {
        students.removeIf(student -> student.getId() == id);
        saveStudents();
    }

    public void edit(Student student) throws IOException {

        students.set(student.getId(), student);
        saveStudents();
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public Student getById(int id) {
        return students.get(id);
    }

    public List<Student> getAll() throws IOException {
        loadStudents();
        return students;
    }

    public void loadStudents() throws IOException {
        List<Student> tempList = objectReader.readValue(new File(studentFile));
        students.setAll(tempList);
    }

    public void saveStudents() throws IOException {
        objectWriter.writeValue(new File(studentFile), students);
    }
}
