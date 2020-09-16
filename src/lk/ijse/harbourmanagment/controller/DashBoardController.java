package lk.ijse.harbourmanagment.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import javax.management.Notification;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnManageSchedule;

    @FXML
    private JFXButton btnManageFishermen;

    @FXML
    private JFXButton btnManageBoat;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private JFXButton btnMinimiz;

    @FXML
    private JFXButton btnRestore;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXTextField lblTime;

    @FXML
    private JFXTextField lblDate;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setTime();
            AnchorPane pane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/DashboardLoad.fxml"));
            Scene scene=new Scene(pane);
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setTime() {
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    @FXML
    void onActionDashboard(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/DashboardLoad.fxml"));
        Scene scene=new Scene(pane);
        anchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onActionLogOut(ActionEvent event) throws IOException {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure You Want To Log Out ?");
        alert.showAndWait();

        AnchorPane root= FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/Login.fxml"));
        Scene scene= new Scene(root);
        Stage stage= (Stage) this.anchorPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void onActionManageBoat(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/ManageBoat.fxml"));
        Scene scene=new Scene(pane);
        anchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onActionManageFishermen(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/ManageFisherman.fxml"));
        Scene scene=new Scene(pane);
        anchorPane.getChildren().setAll(pane);


    }

    @FXML
    void onActionManageSchedule(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/ManageSchedule.fxml"));
        Scene scene=new Scene(pane);
        anchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onActionPayment(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/Payment.fxml"));
        Scene scene=new Scene(pane);
        anchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onActionReport(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/Report.fxml"));
        Scene scene=new Scene(pane);
        anchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onActionClose(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure You Want To Exit Your Programme ?");
        alert.showAndWait();
        System.exit(0);
    }

    @FXML
    void onActionRestore(ActionEvent event) {

    }


    @FXML
    void onActionMinimiz(ActionEvent event) {
        Stage stage= (Stage) btnMinimiz.getScene().getWindow();
        stage.setIconified(true);
    }

}
