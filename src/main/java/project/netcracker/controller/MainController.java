package project.netcracker.controller;

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
    public Button findAllGroup;
    public Button editGroup;
    public Button findNumberGroup;

    public ListView<Group> listGroup;

    public Button createStudent;
    public Button deleteStudent;
    public Button findAllStudent;
    public Button editStudent;
    public Button findNameStudent;

    public ListView<Student> listStudents;
    public TextField textIdStudent;
    public TextField textNameStudent;
    public TextField choiseGroup;
    public DatePicker dateCalendarStudent;
    public TextField textNumberGroup;

    StudentDao studentDao = new StudentDaoImpl();
    GroupDao groupDao = new GroupDaoImpl();
    private Main main;

    public MainController() throws IOException {
    }

    public void setMain(Main main) {
        this.main = main;
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

    public void findAllGroupAction(ActionEvent actionEvent) throws IOException {
        listGroup.setItems((ObservableList<Group>) groupDao.getAll());
        createGroup.setDisable(false);
        editGroup.setDisable(false);
        deleteGroup.setDisable(false);
        findNumberGroup.setDisable(false);
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
    }

    public void createStudentAction(ActionEvent actionEvent) {

        Student student = new Student();
        boolean okClicked = main.showStudentEditDialog(student);
        studentDao.create(student);

    }

    public void deleteStudentAction(ActionEvent actionEvent) {
        Student selectedStudent = listStudents.getSelectionModel().getSelectedItem();
        if(selectedStudent != null){
            studentDao.delete(selectedStudent.getId());
        }
    }

    public void findAllStudentAction(ActionEvent actionEvent) {
        listStudents.setItems((ObservableList<Student>) studentDao.getAll());
        createStudent.setDisable(false);
        editStudent.setDisable(false);
        deleteStudent.setDisable(false);
        findNameStudent.setDisable(false);
    }

    public void editStudentAction(ActionEvent actionEvent) {
        int index = listStudents.getEditingIndex();
        Student selectedStudent = listStudents.getSelectionModel().getSelectedItem();
        if(selectedStudent != null){
            studentDao.edit(selectedStudent);
        }
    }

    public void findNameStudentAction(ActionEvent actionEvent) {
        Student student = studentDao.getStudentByName(textNameStudent.getText());
        listStudents.scrollTo(student);
        listStudents.getSelectionModel().select(student);
    }

    private void showAlertInformation(String title, String result, String content) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("Results: " + result);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
