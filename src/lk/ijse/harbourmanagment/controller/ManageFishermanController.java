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
import lk.ijse.harbourmanagment.bo.custom.ManageBoatsBO;
import lk.ijse.harbourmanagment.bo.custom.ManageFishermanBO;
import lk.ijse.harbourmanagment.bo.custom.impl.ManageBoatsBOImpl;
import lk.ijse.harbourmanagment.bo.custom.impl.ManageFishermanBOImpl;
import lk.ijse.harbourmanagment.common.IDGenarator;
import lk.ijse.harbourmanagment.dto.FBDetailDTO;
import lk.ijse.harbourmanagment.dto.ManageBoatDTO;
import lk.ijse.harbourmanagment.dto.ManageFishermanDTO;
import lk.ijse.harbourmanagment.entity.FBDetail;
import lk.ijse.harbourmanagment.entity.Fisherman;
import lk.ijse.harbourmanagment.validation.Validation;
import org.controlsfx.validation.ValidationSupport;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageFishermanController implements Initializable {
    @FXML
    private JFXTextField txtFishermenId;

    @FXML
    private JFXTextField txtFishermanContact;

    @FXML
    private JFXTextField txtFishermenAddress;

    @FXML
    private JFXTextField txtFishermenName;

    @FXML
    private JFXTextField txtFishermanNic;

    @FXML
    private JFXButton btnSearchFishermenName;

    @FXML
    private JFXButton btnAddFishermen;

    @FXML
    private JFXButton btnDeleteFishermen;

    @FXML
    private JFXButton btnUpdateFishermen;

    @FXML
    private TableView<ManageFishermanDTO> tblManageFishermen;

    @FXML
    private TableView<FBDetailDTO> tblFBDetail;

    @FXML
    private JFXButton btnFBDetailAdd;

    @FXML
    private JFXTextField txtManageFishermanBoatId;

    private ManageFishermanBO manageFishermanBO = new ManageFishermanBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
//            loadAllFisherman();
            setFisherManID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllFisherman() throws Exception {
        ObservableList<ManageFishermanDTO> manageFishermanDTOS = FXCollections.observableArrayList(manageFishermanBO.getAllFishermans());
        tblManageFishermen.setItems(manageFishermanDTOS);
        tblManageFishermen.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fid"));
        tblManageFishermen.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblManageFishermen.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblManageFishermen.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblManageFishermen.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("contact"));

    }

    private void clearAll() {
        txtFishermenId.clear();
        txtFishermenName.clear();
        txtFishermenAddress.clear();
        txtFishermanNic.clear();
        txtFishermanContact.clear();

    }

    private void setFisherManID() throws Exception {
        String id;
        id = IDGenarator.getNewId("fisherman", "fid", "F");
        txtFishermenId.setText(id);
    }

    @FXML
    void onAddFishermen(ActionEvent event) throws Exception {

        if (Validation.isNotEmptyValidation(txtFishermenName.getText()) && Validation.nameValidation(txtFishermenName.getText())) {
            if (Validation.isNotEmptyValidation(txtFishermanNic.getText()) && Validation.nicValidation(txtFishermanNic.getText())) {
                if (Validation.isNotEmptyValidation(txtFishermenAddress.getText()) && Validation.addressValidation(txtFishermenAddress.getText())) {
                    if (Validation.isNotEmptyValidation(txtManageFishermanBoatId.getText())) {
                        if (Validation.isNotEmptyValidation(txtFishermanContact.getText()) && Validation.contactNoValidation(txtFishermanContact.getText())) {


                            String boatID = txtManageFishermanBoatId.getText();
                            String fishermanID = txtFishermenId.getText();
                            FBDetailDTO fbDetailDTO = new FBDetailDTO(boatID, fishermanID);

                            tblFBDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
                            tblFBDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fid"));

                            tblFBDetail.getItems().add(fbDetailDTO);

                            ManageFishermanDTO manageFishermanDTO = new ManageFishermanDTO(txtFishermenId.getText(), txtFishermenName.getText(),
                                    txtFishermenAddress.getText(), txtFishermanNic.getText(), txtFishermanContact.getText());

                            tblManageFishermen.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fid"));
                            tblManageFishermen.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
                            tblManageFishermen.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
                            tblManageFishermen.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nic"));
                            tblManageFishermen.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("contact"));

                            tblManageFishermen.getItems().add(manageFishermanDTO);
                            clearAll();
                            setFisherManID();


                        } else {
                            new Alert(Alert.AlertType.ERROR, "CONTACT ERROR").show();
                        }
                    } else {
                        new Alert(Alert.AlertType.ERROR, "BOAT ID ERROR").show();
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "ADDRESS ERROR").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "NIC ERROR").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Name ERROR").show();
        }


    }


    @FXML
    void onDeleteFishermen(ActionEvent event) {

    }

    @FXML
    void onSearchFishermenName(ActionEvent event) throws Exception {
        ManageFishermanDTO manageFishermanDTO = manageFishermanBO.searchFisherman(txtFishermenName.getText());
//        System.out.println(" ERROR "+manageFishermanDTO);
        txtFishermenId.setText(manageFishermanDTO.getFid());
        txtFishermenAddress.setText(manageFishermanDTO.getAddress());
        txtFishermanNic.setText(manageFishermanDTO.getNic());
        txtFishermanContact.setText(manageFishermanDTO.getContact());

        if (manageFishermanDTO == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong this Fisherman Name", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void onUpdateFishermen(ActionEvent event) {

    }

    @FXML
    void onActionFBDetail(ActionEvent event) throws Exception {
        ArrayList<ManageFishermanDTO> arrayList = new ArrayList<>();

        for (int i = 0; i < tblManageFishermen.getItems().size(); i++) {
            String fid = (String) tblManageFishermen.getColumns().get(0).getCellObservableValue(i).getValue();
            String name = (String) tblManageFishermen.getColumns().get(1).getCellObservableValue(i).getValue();
            String address = (String) tblManageFishermen.getColumns().get(2).getCellObservableValue(i).getValue();
            String nic = (String) tblManageFishermen.getColumns().get(3).getCellObservableValue(i).getValue();
            String conect = (String) tblManageFishermen.getColumns().get(4).getCellObservableValue(i).getValue();
            arrayList.add(new ManageFishermanDTO(fid, name, address, nic, conect));
            System.out.println("Error  :" + arrayList);
        }

        ArrayList<FBDetailDTO> dtos = new ArrayList<>();

        for (int i = 0; i < tblFBDetail.getItems().size(); i++) {
            String boatID = (String) tblFBDetail.getColumns().get(0).getCellObservableValue(i).getValue();
            String fisherID = (String) tblFBDetail.getColumns().get(1).getCellObservableValue(i).getValue();
            dtos.add(new FBDetailDTO(boatID, fisherID));
        }

//        System.out.println("Add :"+arrayList);
//        System.out.println("Added :"+dtos);

        boolean b = manageFishermanBO.saveFisherman(arrayList, dtos);

        if (b) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Successfully", ButtonType.OK);
            alert.show();
//            loadAllFisherman();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Added Not Successfully", ButtonType.OK);
            alert.show();
        }
        setFisherManID();
    }

    public void onSearchFishermenId(ActionEvent actionEvent) {

    }
}
