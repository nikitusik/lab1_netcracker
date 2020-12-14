package project.netcracker.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import project.netcracker.model.Student;

public class ListStudentsForGroupController {
    public Button close;
    public ListView<Student> listStudents;
    private Stage dialogStage;

    public void setStudents(ObservableList<Student> students){
        listStudents.setItems(students);
    }
    public void closeAction(ActionEvent actionEvent) {
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
