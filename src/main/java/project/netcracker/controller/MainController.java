package project.netcracker.controller;

import javafx.collections.FXCollections;
import project.netcracker.Main;
import project.netcracker.dao.GroupDao;
import project.netcracker.dao.GroupDaoImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import project.netcracker.dao.StudentDao;
import project.netcracker.dao.StudentDaoImpl;
import project.netcracker.model.Group;
import project.netcracker.model.Student;

import java.io.IOException;
import java.util.List;

import static project.netcracker.controller.AlertConstant.*;


public class MainController {
    public Button createGroup;
    public Button deleteGroup;
    public Button editGroup;
    public Button findNumberGroup;

    public ListView<Group> listGroup;

    public Button createStudent;
    public Button deleteStudent;
    public Button editStudent;
    public Button findNameStudent;

    public ListView<Student> listStudents;
    public TextField textNameStudent;
    public TextField textNumberGroup;

    private final StudentDao studentDao = new StudentDaoImpl();
    private final GroupDao groupDao = new GroupDaoImpl();
    private Main main;

    public MainController() throws IOException {
    }

    private void initialize() throws IOException {
        listGroup.setItems((ObservableList<Group>) groupDao.getAll());
        listStudents.setItems((ObservableList<Student>) studentDao.getAll());
    }

    public void setMain(Main main) throws IOException {
        this.main = main;
        initialize();
    }

    public void createGroupAction(ActionEvent actionEvent) throws IOException {
        Group group = new Group();
        boolean okClicked = main.showGroupEditDialog(group);
        if (okClicked) {
            groupDao.create(group);
        }
    }

    public void deleteGroupAction(ActionEvent actionEvent) throws IOException {
        Group selectedGroup = listGroup.getSelectionModel().getSelectedItem();
        if (selectedGroup != null) {
            groupDao.delete(selectedGroup);
        }
    }

    public void editGroupAction(ActionEvent actionEvent) throws IOException {
        int index = listGroup.getSelectionModel().getSelectedIndex();
        Group selectedGroup = listGroup.getSelectionModel().getSelectedItem();
        if (selectedGroup != null) {
            boolean okClicked = main.showGroupEditDialog(selectedGroup);
            if (okClicked) {
                groupDao.edit(index, selectedGroup);
            }
        }
    }

    public void findNumberGroupAction(ActionEvent actionEvent) throws IOException {
        Group group = groupDao.getByNumber(textNumberGroup.getText());
        listGroup.scrollTo(group);
        listGroup.getSelectionModel().select(group);

        ObservableList<Student> students = (ObservableList<Student>) studentDao.getAll();
        ObservableList<Student> result = FXCollections.observableArrayList();

        for (Student student : students) {
            if (student.getGroup().getNumber().equals(group.getNumber())) {
                result.add(student);
            }
        }
        main.showListStudentForGroup(result);
        textNumberGroup.setText(null);
    }

    public void createStudentAction(ActionEvent actionEvent) throws IOException {
        Student student = new Student();
        boolean okClicked = main.showStudentEditDialog(student, groupDao);
        if (okClicked) {
            studentDao.create(student);
        }
    }

    public void deleteStudentAction(ActionEvent actionEvent) throws IOException {
        Student selectedStudent = listStudents.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentDao.delete(selectedStudent.getId());
        }
    }

    public void editStudentAction(ActionEvent actionEvent) throws IOException {
        Student selectedStudent = listStudents.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            boolean okClicked = main.showStudentEditDialog(selectedStudent, groupDao);
            if (okClicked) {
                studentDao.edit(selectedStudent);
            }
        }
    }

    public void findNameStudentAction(ActionEvent actionEvent) {
        Student student = studentDao.getStudentByName(textNameStudent.getText());
        listStudents.scrollTo(student);
        listStudents.getSelectionModel().select(student);
        textNameStudent.setText(null);
    }

    private void showAlertInformation() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("title");
        alert.setHeaderText("Results: ");

        alert.setContentText("Hello");

        alert.showAndWait();
    }
}
