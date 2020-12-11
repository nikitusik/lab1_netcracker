package project.netcracker.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.netcracker.model.Group;

public class CreateEditGroupController {

    public Button create;
    public Button cancel;
    public TextField textNUmber;
    public TextField textFaculty;

    private Stage dialogStage;
    private Group group;
    private boolean okClicked = false;

    public void setGroup(Group group){
        this.group = group;
        textNUmber.setText(group.getNumber());
        textFaculty.setText(group.getFaculty());
    }

    public void createAction(ActionEvent actionEvent) {
        group.setNumber(textNUmber.getText());
        group.setFaculty(textFaculty.getText());
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
