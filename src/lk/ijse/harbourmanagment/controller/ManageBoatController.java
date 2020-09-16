package lk.ijse.harbourmanagment.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import lk.ijse.harbourmanagment.bo.custom.ManageOwnerBO;
import lk.ijse.harbourmanagment.bo.custom.impl.ManageBoatsBOImpl;
import lk.ijse.harbourmanagment.bo.custom.impl.ManageOwnerBOImpl;
import lk.ijse.harbourmanagment.common.IDGenarator;
import lk.ijse.harbourmanagment.dto.ManageBoatDTO;
import lk.ijse.harbourmanagment.dto.OBDetailDTO;
import lk.ijse.harbourmanagment.dto.OwnerDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageBoatController implements Initializable {
    @FXML
    private JFXTextField txtBoatName;

    @FXML
    private JFXTextField txtBoatColour;

    @FXML
    private JFXTextField txtBoatLength;

    @FXML
    private JFXTextField txtBoatType;

    @FXML
    private JFXTextField txtBoatId;

    @FXML
    private JFXButton btnSearchBoatId;

    @FXML
    private JFXButton btnOwnerAndBoatAdd;

    @FXML
    private JFXButton btnOwnerAndBoatDelete;

    @FXML
    private JFXButton btnOwnerAndBoatUpdate;

    @FXML
    private JFXTextField txtOwnerId;

    @FXML
    private JFXTextField txtOwnerName;

    @FXML
    private JFXTextField txtOwnerAddress;

    @FXML
    private JFXTextField txtOwnerNic;

    @FXML
    private JFXTextField txtOwnerContact;

    @FXML
    private JFXButton btnSearchOwnerName;

    @FXML
    private TableView<ManageBoatDTO> tblManageOwnerAndBoat;

    private ManageBoatsBO boatsBO=new ManageBoatsBOImpl();

    private ManageOwnerBO manageOwnerBO=new ManageOwnerBOImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            loadAllBoat();
            setOwnerID();
            setBoatID();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setBoatID() throws Exception {
        String id;
        id= IDGenarator.getNewId("boat","bid","B");
        txtBoatId.setText(id);
    }

    private void setOwnerID() throws Exception {
        String id;
        id= IDGenarator.getNewId("owner","oid","W");
        txtOwnerId.setText(id);
    }

    public ManageBoatController() {

    }

    @FXML
    void onActionOwnerAndBoatAdd(ActionEvent event) throws Exception {


        ManageBoatDTO manageBoatDTO=new ManageBoatDTO(txtBoatId.getText(),
                txtBoatName.getText(),Double.parseDouble(txtBoatLength.getText()),txtBoatColour.getText(),
                txtBoatType.getText());
        OwnerDTO ownerDTO=new OwnerDTO(txtOwnerId.getText(),txtOwnerName.getText(),txtOwnerAddress.getText(),
                txtOwnerNic.getText(),txtOwnerContact.getText());
        OBDetailDTO obDetailDTO=new OBDetailDTO(txtBoatId.getText(), txtOwnerId.getText());

//        System.out.println("this is manageBoatDTO"+manageBoatDTO);
//        System.out.println("this is ownerDTO"+ownerDTO);
//        System.out.println("this is detail dao"+obDetailDTO);
            boolean b = boatsBO.saveBoat(manageBoatDTO, ownerDTO, obDetailDTO);
//        System.out.println(b);
        if (b){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Successfully", ButtonType.OK);
            alert.show();
            loadAllBoat();
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Added Not Successfully", ButtonType.OK);
            alert.show();
        }
        setDefault();

    }

    @FXML
    void onActionOwnerAndBoatDelete(ActionEvent event)throws Exception {
//        ManageBoatDTO manageBoatDTO=new ManageBoatDTO(txtBoatId.getText());
//        OBDetailDTO detailDTO=new OBDetailDTO(txtBoatId.getText(), txtOwnerId.getText());
//        return ManageBoatsBO.deleteBoat(Id);

        boolean isDeleted = boatsBO.deleteBoat(txtBoatId.getText());
        if (isDeleted){
            loadAllBoat();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Boat Delete Successfully",ButtonType.OK);
            clearAll();
            alert.show();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR,"Boat Not Delete",ButtonType.OK);
            alert.show();
        }
    }

    private void clearAll() {
        txtBoatName.clear();
        txtBoatLength.clear();
        txtBoatColour.clear();
        txtBoatType.clear();
    }


    private void loadAllBoat() throws Exception {
        ObservableList<ManageBoatDTO> manageBoatDTOS = FXCollections.observableArrayList(boatsBO.getAllBoats());
        tblManageOwnerAndBoat.setItems(manageBoatDTOS);
        tblManageOwnerAndBoat.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblManageOwnerAndBoat.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblManageOwnerAndBoat.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("length"));
        tblManageOwnerAndBoat.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("colour"));
        tblManageOwnerAndBoat.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("boat_type"));
    }

    @FXML
    void onActionOwnerAndBoatUpdate(ActionEvent event) throws Exception {
        ManageBoatDTO manageBoatDTO=new ManageBoatDTO(txtBoatId.getText(),txtBoatName.getText(),
                Double.parseDouble(txtBoatLength.getText()),txtBoatColour.getText(),
                txtBoatType.getText());
        OBDetailDTO obDetailDTO=new OBDetailDTO(txtBoatId.getText(), txtOwnerId.getText());
        boolean b = boatsBO.updateBoat(manageBoatDTO,obDetailDTO);
//        System.out.println(b);
        if (b){
            loadAllBoat();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Update Successfully", ButtonType.OK);
            alert.show();

        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Update Not Successfully", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void onActionSearchBoatId(ActionEvent event) throws Exception {
        ManageBoatDTO manageBoatDTO = boatsBO.searchBoat(txtBoatId.getText());
        txtBoatName.setText(manageBoatDTO.getName());
        txtBoatLength.setText(" "+ manageBoatDTO.getLength());
        txtBoatColour.setText(manageBoatDTO.getColour());
        txtBoatType.setText(manageBoatDTO.getBoat_type());
        if (manageBoatDTO==null){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong This Boat Id", ButtonType.OK);
            alert.show();
        }

    }

    @FXML
    void onActionSearchOwnerName(ActionEvent event) throws Exception {
        OwnerDTO ownerDTO= manageOwnerBO.searchOwner(txtOwnerName.getText());
        txtOwnerId.setText(ownerDTO.getOid());
        txtOwnerAddress.setText(ownerDTO.getAddress());
        txtOwnerNic.setText(ownerDTO.getNic());
        txtOwnerContact.setText(ownerDTO.getContact());
        laodBoatsForOwnerName(txtOwnerName.getText());

        if (ownerDTO==null){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong This Owner Name", ButtonType.OK);
            alert.show();
        }
    }
    @FXML
    void onMouseClickedManageOwnerAndBoat(MouseEvent event) {
        ManageBoatDTO manageBoatDTO=tblManageOwnerAndBoat.getSelectionModel().getSelectedItem();
        txtBoatId.setText(manageBoatDTO.getBid());
        txtBoatName.setText(manageBoatDTO.getName());
        txtBoatLength.setText(" "+ manageBoatDTO.getLength());
        txtBoatColour.setText(manageBoatDTO.getColour());
        txtBoatType.setText(manageBoatDTO.getBoat_type());
    }

    void setDefault(){
        txtBoatName.clear();
        txtBoatLength.clear();
        txtBoatColour.clear();
        txtBoatType.clear();
        txtOwnerName.clear();
        txtOwnerAddress.clear();
        txtOwnerNic.clear();
        txtOwnerContact.clear();
    }

    private void laodBoatsForOwnerName(String name) throws Exception {
        ObservableList<ManageBoatDTO> boatDTOS = FXCollections.observableArrayList(boatsBO.getAllOwnerBoat(name));
        tblManageOwnerAndBoat.setItems(boatDTOS);
        tblManageOwnerAndBoat.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblManageOwnerAndBoat.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblManageOwnerAndBoat.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("length"));
        tblManageOwnerAndBoat.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("colour"));
        tblManageOwnerAndBoat.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("boat_type"));
    }

}
