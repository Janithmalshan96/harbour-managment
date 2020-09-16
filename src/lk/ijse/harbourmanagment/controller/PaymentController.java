package lk.ijse.harbourmanagment.controller;

import com.jfoenix.controls.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import lk.ijse.harbourmanagment.bo.custom.PaymentBO;
import lk.ijse.harbourmanagment.bo.custom.impl.PaymentBOImpl;
import lk.ijse.harbourmanagment.common.IDGenarator;
import lk.ijse.harbourmanagment.dao.custom.PaymentDAO;
import lk.ijse.harbourmanagment.dao.custom.RegistrationDAO;
import lk.ijse.harbourmanagment.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.harbourmanagment.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.harbourmanagment.dto.PaymentDTO;
import lk.ijse.harbourmanagment.dto.RegistrationDTO;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    private JFXTextField txtBoatIdPayment;

//    @FXML
//    private JFXTextField txtNamePayment;

    @FXML
    private JFXTextField txtAmountPayment;

    @FXML
    private JFXComboBox<?> comboBoatTypePayment;

    @FXML
    private TableView<?> tblAllPayment;

    @FXML
    private JFXTextField txtRegistrationIdPayment;

    @FXML
    private JFXRadioButton radiobtnNewBoat;

    @FXML
    private ToggleGroup boatStatusRadioGroup;

    @FXML
    private JFXRadioButton radiobtnOldBoat;

//
//    @FXML
//    private JFXTextField txtPayamentDate;

    @FXML
    private JFXButton btnAddPayment;

    @FXML
    private JFXButton btnDeletePayment;

    @FXML
    private JFXButton btnUpdatePayment;

    @FXML
    private JFXDatePicker datePaymentDetail;

    @FXML
    private JFXTextField txtPaymentId;

    @FXML
    private JFXDatePicker txtDatePicker;

    private PaymentBO paymentBO=new PaymentBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

//            loadAllPayment();
            setPayment();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadAllPayment() {
//        ObservableList<PaymentDTO>paymentDTOS= FXCollections.observableList(paymentBO.);
    }

    private void setPayment() throws Exception {
        String id;
        id=IDGenarator.getNewId("payment","pid","P");
        txtPaymentId.setText(id);
    }

    @FXML
    void onActionAddPayment(ActionEvent event) throws Exception {
        System.out.println("Controller  :"+txtPaymentId.getText());

        PaymentDTO paymentDTO=new PaymentDTO(
                txtPaymentId.getText(),
                txtRegistrationIdPayment.getText(),
                Double.parseDouble(txtAmountPayment.getText()),
               // txtPayamentDate.getText()
                txtDatePicker.getValue().toString()
                );

        System.out.println(paymentDTO.getPid());

        System.out.println("Controller DTO  :"+paymentDTO);
        boolean b = paymentBO.savePayment(paymentDTO);
        if (b) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Payment Added Successful", ButtonType.OK);
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Payment Not Added", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void onActionDatePaymentDetail(ActionEvent event) {

    }

    @FXML
    void onActionDeletePayment(ActionEvent event) throws Exception {
//        boolean isDelete = paymentBO.deletePayment(txtPaymentId.getText());
//        if (!isDelete){
//            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Delete Payment Success",ButtonType.OK);
//            alert.show();
//        }
    }

    @FXML
    void onActionUpdatePayment(ActionEvent event) throws Exception {
        PaymentDTO paymentDTO=new PaymentDTO(
                txtPaymentId.getText(),
                txtRegistrationIdPayment.getText(),
                Double.parseDouble(txtAmountPayment.getText()),
               // txtPayamentDate.getText()
                txtDatePicker.getValue().toString()
        );
        boolean b = paymentBO.updatePayment(paymentDTO);
        if (b){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Payment Update Success",ButtonType.OK);
            alert.show();
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Payment Update Not Success",ButtonType.OK);
            alert.show();
        }
    }

}
