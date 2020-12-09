import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.GroupDaoImpl;
import dao.StudentDaoImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Group;
import model.Student;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Добавление группы");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();
    }
    public static void main(String[] args) throws IOException {
        launch(args);
//        Group group1 = new Group("6107-З", "Факультет Информатики");
//        Group group2 = new Group("5108-Д", "Факультет Биологии");
//        GroupDaoImpl groupDao = new GroupDaoImpl();
//        groupDao.create(group1);
//        groupDao.create(group2);
//        List<Group> a = groupDao.getAll();
//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File("group.json");
//        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//        writer.writeValue(file, a);
//
//        Student student = new Student(1, "Иванов Иван Иванович", group1, new GregorianCalendar(2010, Calendar.JUNE, 12).getTime());
//        StudentDaoImpl studentDao = new StudentDaoImpl();
//        studentDao.create(student);
//        List<Student> s = studentDao.getAll();
//        File file_s = new File("student.json");
//        writer.writeValue(file_s, student);
//
//        Date date = new Date(1276286400000L);
//        System.out.println(date);
    }
}
