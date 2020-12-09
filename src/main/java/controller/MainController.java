package controller;

import dao.GroupDao;
import dao.GroupDaoImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.Group;
import model.Student;

import java.util.List;

import static controller.AlertConstant.*;


public class MainController {
    public Button createGroup;
    public Button deleteGroup;
    public Button findAllGroup;
    public Button editGroup;
    public Button findNumberGroup;

    public ListView<Group> listGroup;
    public TextField textNumberGroup;
    public TextField textFacultyGroup;

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

    GroupDao groupDao = new GroupDaoImpl();
    private boolean isExist = false;

    public void createGroupAction(ActionEvent actionEvent) {

        Group group = new Group();
        group.setNumber(textNumberGroup.getText());
        group.setFaculty(textFacultyGroup.getText());

        for (Group i : groupDao.getAll()) {
            if (i.getNumber().equals(group.getNumber())) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            groupDao.create(group);
            showAlertInformation(TITLE_ADD_GROUP, OK, group.toString());
        } else
            showAlertInformation(TITLE_ADD_GROUP, ERROR, GROUP_EXIST);
        isExist = false;
    }

    public void deleteGroupAction(ActionEvent actionEvent) {

        for (Group i : groupDao.getAll()) {
            if (i.getNumber().equals(textNumberGroup.getText())) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            groupDao.delete(textNumberGroup.getText());
            showAlertInformation(TITLE_DELETE_GROUP, OK, CONTENT_DELETE + textNumberGroup.getText());
        } else
            showAlertInformation(TITLE_DELETE_GROUP, ERROR, GROUP_NOT_EXIST);
        isExist = false;
    }

    public void findAllGroupAction(ActionEvent actionEvent) {
        listGroup.setItems((ObservableList<Group>) groupDao.getAll());
    }

    public void editGroupAction(ActionEvent actionEvent) {
        int index = 0;
        Group group = groupDao.getByNumber(textNumberGroup.getText());
        for (int i=0; i < groupDao.getAll().size(); i++){
            if (group == groupDao.getAll().get(i)){
                index = i;
            }
        }
        group.setFaculty(textFacultyGroup.getText());
        groupDao.edit(index, group);
    }

    public void findNumberGroupAction(ActionEvent actionEvent) {

        for (Group i : groupDao.getAll()) {
            if (i.getNumber().equals(textNumberGroup.getText())) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            showAlertInformation(TITLE_GET_NUMBER, ERROR, GROUP_NOT_EXIST);
        } else {
            Group group = groupDao.getByNumber(textNumberGroup.getText());
            showAlertInformation(TITLE_GET_NUMBER, OK, CONTENT_GET_GROUP + group.toString());
        }
    }

    public void createStudentAction(ActionEvent actionEvent) {
    }

    public void deleteStudentAction(ActionEvent actionEvent) {
    }

    public void findAllStudentAction(ActionEvent actionEvent) {
    }

    public void editStudentAction(ActionEvent actionEvent) {
    }

    public void findNameStudentAction(ActionEvent actionEvent) {
    }

    private void showAlertInformation(String title, String result, String content) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("Results: " + result);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
