package lk.ijse.harbourmanagment.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.harbourmanagment.db.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXPasswordField txtUserPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private JFXButton cancel;

    @FXML
    void cancelOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onLoginAction(ActionEvent event) throws Exception {
        if (Login(txtUserName.getText(),txtUserPassword.getText())) {
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/harbourmanagment/view/DashBoard.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) this.anchorPane.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        }else {
            if (!(txtUserName.getText().equals("0"))) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect UserName");
                alert.show();
            } else if
                (!(txtUserPassword.getText().equals("0"))){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect UserPassword");
                    alert.show();
            }
        }
    }

    public boolean Login(String username,String password)throws Exception{
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement statement=null;
        ResultSet rst=null;

        try{
            String sql="Select * from admin where userName=? and password=? ";
            statement=connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);

            rst=statement.executeQuery();
            if (rst.next()){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }finally {
            rst.close();
        }
    }

}
