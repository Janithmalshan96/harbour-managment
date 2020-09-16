package lk.ijse.harbourmanagment.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.harbourmanagment.bo.custom.ManageBoatsBO;
import lk.ijse.harbourmanagment.bo.custom.ManageScheduleBO;
import lk.ijse.harbourmanagment.bo.custom.RSDetailBO;
import lk.ijse.harbourmanagment.bo.custom.RegistrationBO;
import lk.ijse.harbourmanagment.bo.custom.impl.ManageBoatsBOImpl;
import lk.ijse.harbourmanagment.bo.custom.impl.ManageScheduleBOImpl;
import lk.ijse.harbourmanagment.bo.custom.impl.RSDetailBOImpl;
import lk.ijse.harbourmanagment.bo.custom.impl.RegistrationBOImpl;
import lk.ijse.harbourmanagment.common.IDGenarator;
import lk.ijse.harbourmanagment.dto.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ManageScheduleController implements Initializable {

    @FXML
    private JFXTextField txtScheduleBoatId;

    @FXML
    private JFXTextField txtScheduleId;

    @FXML
    private JFXDatePicker dateSchedulePickerStart;

    @FXML
    private JFXDatePicker dateSchedulePickerEnd;

    @FXML
    private JFXTextField txtScheduleCount;

    @FXML
    private JFXButton btnAddManageSchedule;

    @FXML
    private JFXButton btnDeleteManageSchedule;

    @FXML
    private JFXButton btnUpdateManageSchedule;

    @FXML
    private JFXTextField txtRegistrationIdSchedule;

    @FXML
    private TableView<ScheduleDetailDTO> tblManageSchedule;


    private ManageScheduleBO manageScheduleBO=new ManageScheduleBOImpl();
    private RegistrationBO registrationBO=new RegistrationBOImpl();
//    private ManageBoatsBO boatsBO=new ManageBoatsBOImpl();
    private RSDetailBO rsDetailBO=new RSDetailBOImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            loadAllSchedules();

            setScheduleId();
//            setDefault();
            setRegistration();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setScheduleId() throws Exception {
        String id;
        id=IDGenarator.getNewId("schedule","sid","S");
        txtScheduleId.setText(id);
    }

    private void setRegistration() throws Exception {
        String id;
        id=IDGenarator.getNewId("registration","rid", "R");
        txtRegistrationIdSchedule.setText(id);
    }

    private void setDefault() {
        txtScheduleId.clear();
        txtScheduleBoatId.clear();
        txtScheduleCount.clear();
//        dateSchedulePickerStart
//        dateSchedulePickerEnd.
    }


//    private void loadAllSchedule() throws Exception {
//
//        ObservableList<ManageScheduleDTO>es= FXCollections.observableArrayList(manageScheduleBO.getAllSchedule());
//
//        tblManageSchedule.setItems(es);
//        tblManageSchedule.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
//        tblManageSchedule.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("start_date"));
//        tblManageSchedule.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("end_date"));
//        tblManageSchedule.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("count"));
////        tblManageSchedule.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bid"));
//    }


    @FXML
    void onAddManageSchedule(ActionEvent event) throws Exception {
//        System.out.println(dateSchedulePickerStart.getValue().toString());
        RegistrationDTO registrationDTO=new RegistrationDTO(
                txtRegistrationIdSchedule.getText(),
                txtScheduleBoatId.getText(),
                dateSchedulePickerStart.getValue().toString()
        );


        ManageScheduleDTO manageScheduleDTO=new ManageScheduleDTO(
                txtScheduleId.getText(),
                dateSchedulePickerStart.getValue().toString(),
                dateSchedulePickerEnd.getValue().toString(),
                Integer.parseInt(txtScheduleCount.getText()
        ));

        String a=txtRegistrationIdSchedule.getText();
        String c=txtScheduleId.getText();
        System.out.println("aasdfghs :"+a+"  "+c );
        RSDetailDTO rsDetailDTO=new RSDetailDTO(
                0,
                a,
                c
                );


//        System.out.println("ScheduleRegistration Controller     "+registrationDTO);
//        System.out.println("ScheduleRSDetail Controller     "+rsDetailDTO);
//        System.out.println("Schedule Controller     "+manageScheduleDTO);


        boolean b = manageScheduleBO.saveSchedule(
                registrationDTO,
                manageScheduleDTO,
                rsDetailDTO
        );
        System.out.println("Controller  : "+b);

        if(b){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Schedule Is Added ", ButtonType.OK);
//            loadAllSchedule();
            alert.showAndWait();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR, "Schedule Is Not Added", ButtonType.OK);
            alert.show();

            setDefault();
//            setBoatId();
//            setScheduleId();
//            setRegistration();
        }
    }

    @FXML
    void onDeleteManageSchedule(ActionEvent event) throws Exception {
        boolean isDelete = manageScheduleBO.deleteSchedule(txtScheduleId.getText());
        if (!isDelete){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Delete Schedule",ButtonType.OK);
            alert.show();
        }else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Not Delete Schedule",ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void onUpdateManageSchedule(ActionEvent event) throws Exception {
        RegistrationDTO registrationDTO = new RegistrationDTO(
                txtRegistrationIdSchedule.getText(),
                txtScheduleBoatId.getText(),
                dateSchedulePickerStart.getValue().toString()
        );

        System.out.println("saaaaaaaaaaaaa");

        System.out.println(txtScheduleCount.getText());
        int a= Integer.parseInt(txtScheduleCount.getText());
        System.out.println(a);
        ManageScheduleDTO manageScheduleDTO = new ManageScheduleDTO(
                txtScheduleId.getText(),
                dateSchedulePickerStart.getValue().toString(),
                dateSchedulePickerEnd.getValue().toString(),
                Integer.parseInt(txtScheduleCount.getText())
        );

        System.out.println("Controller :"+txtScheduleCount);

        RSDetailDTO rsDetailDTO = new RSDetailDTO(
                0,
                txtRegistrationIdSchedule.getText(),
                txtScheduleId.getText()
        );

        boolean b = manageScheduleBO.updateSchedule(registrationDTO, manageScheduleDTO, rsDetailDTO);

        System.out.println("Controller  : " + b);

        if (b) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Schedule Is Added ", ButtonType.OK);
//            loadAllSchedule();
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Schedule Is Not Added", ButtonType.OK);
            alert.show();
        }
    }
    @FXML
    void onMouseClickedSchedule(MouseEvent event) {
        ScheduleDetailDTO scheduleDetailDTO=tblManageSchedule.getSelectionModel().getSelectedItem();
        txtScheduleId.setText(scheduleDetailDTO.getSid());
        dateSchedulePickerStart.setValue(LocalDate.parse(scheduleDetailDTO.getStart_date()));
        dateSchedulePickerEnd.setValue(LocalDate.parse(scheduleDetailDTO.getEnd_date()));
        txtScheduleCount.setText(" "+scheduleDetailDTO.getCount());
        txtScheduleBoatId.setText(scheduleDetailDTO.getBid());
    }

    private void loadAllSchedules() throws Exception {
        ObservableList<ScheduleDetailDTO>list=FXCollections.observableArrayList(manageScheduleBO.getAllSchedules());
        tblManageSchedule.setItems(list);
        tblManageSchedule.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
        tblManageSchedule.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("start_date"));
        tblManageSchedule.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("end_date"));
        tblManageSchedule.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("count"));
        tblManageSchedule.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bid"));
    }
}
