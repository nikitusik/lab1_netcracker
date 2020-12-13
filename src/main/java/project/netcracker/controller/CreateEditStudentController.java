package project.netcracker.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.netcracker.dao.GroupDao;
import project.netcracker.dao.GroupDaoImpl;
import project.netcracker.model.Group;
import project.netcracker.model.Student;

import java.io.IOException;
import java.util.Date;

public class CreateEditStudentController {
    public Button create;
    public Button cancel;
    public TextField textName;
    public TextField textGroupNumber;
    public DatePicker textDateOfEnrollment;

    private Stage dialogStage;
    private Student student;
    private boolean okClicked = false;

    public void setStudent(Student student){
        this.student = student;
        textName.setText(student.getName());
        textGroupNumber.setText(student.getGroup().getNumber());
        textDateOfEnrollment.getConverter().toString();

    }

    public void createAction(ActionEvent actionEvent) throws IOException {
        student.setName(textName.getText());
        GroupDao groupDao = new GroupDaoImpl();
        Group group = groupDao.getByNumber(textGroupNumber.getText());
        student.setGroup(group);
        java.sql.Date date = java.sql.Date.valueOf(textDateOfEnrollment.getValue());
        //java.util.Date newDate = date.getDate("VALUEDATE");
        java.util.Date utilDate = new java.util.Date(date.getTime());
        student.setDateOfEnrollment(utilDate);
        /*group.setNumber(textNUmber.getText());
        group.setFaculty(textFaculty.getText());*/
        okClicked = true;
        dialogStage.close();
    }

    public void cancelAction(ActionEvent actionEvent) {
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }
}
