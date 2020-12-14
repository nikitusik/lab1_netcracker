package project.netcracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.netcracker.controller.CreateEditGroupController;
import project.netcracker.controller.CreateEditStudentController;
import project.netcracker.controller.MainController;
import project.netcracker.dao.GroupDao;
import project.netcracker.model.Group;
import project.netcracker.model.Student;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    @Override
    public void start (Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Студенты и группы");
        initRoot();
    }

    // инициализируем корневую сцену
    private void initRoot() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/form/main.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.setMain(this);
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();
    }

    public boolean showGroupEditDialog(Group group){
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/form/createEditGroup.fxml"));
            AnchorPane page = loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём группу в контроллер.
            CreateEditGroupController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setGroup(group);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showStudentEditDialog(Student student, GroupDao groupDao){
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/form/createEditStudent.fxml"));
            AnchorPane page = loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём группу в контроллер.
            CreateEditStudentController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setStudent(student, groupDao);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
