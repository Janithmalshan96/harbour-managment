package lk.ijse.harbourmanagment.controller;


import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.harbourmanagment.bo.custom.ManageBoatsBO;
import lk.ijse.harbourmanagment.bo.custom.ManageFishermanBO;
import lk.ijse.harbourmanagment.bo.custom.impl.ManageBoatsBOImpl;
import lk.ijse.harbourmanagment.bo.custom.impl.ManageFishermanBOImpl;
import lk.ijse.harbourmanagment.dto.FishermanDetailDTO;
import lk.ijse.harbourmanagment.dto.ManageBoatDTO;

import java.net.URL;

import java.util.ResourceBundle;

public class DashboardLoadController implements Initializable {

    @FXML
    private JFXTextField txtBoatIdDash;

    @FXML
    private TableView<FishermanDetailDTO> tblFishermanDetail;

    @FXML
    private Label txtBoatName;

    @FXML
    private Label txtBoatLength;

    @FXML
    private Label txtBoatType;

    @FXML
    private Label txtBoatColour;

    private ManageBoatsBO boatsBO=new ManageBoatsBOImpl();
    private ManageFishermanBO manageFishermanBO=new ManageFishermanBOImpl();

//    @FXML
//    private Label lblShowDate;
//
//    @FXML
//    private Label lblShowTime;
//
//    private Timeline timeline;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        setTimeAndDate();
    }

    private void LoadFisherman(String Id) throws Exception {
//        ArrayList<FishermanDetailDTO>arrayList=new ArrayList<>();
        ObservableList<FishermanDetailDTO>fishermanDetailDTOS= FXCollections.observableArrayList(manageFishermanBO.getAllFisherman(Id));
        tblFishermanDetail.setItems(fishermanDetailDTOS);
        tblFishermanDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblFishermanDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblFishermanDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
    }

    @FXML
    void onActionBoatIdDashBoard(ActionEvent event) throws Exception {
        ManageBoatDTO manageBoatDTO=boatsBO.searchBoat(txtBoatIdDash.getText());
        txtBoatName.setText(manageBoatDTO.getName());
        txtBoatLength.setText("  "+manageBoatDTO.getLength());
        txtBoatColour.setText(manageBoatDTO.getColour());
        txtBoatType.setText(manageBoatDTO.getBoat_type());
        LoadFisherman(txtBoatIdDash.getText());

    }

//    private void setTimeAndDate() {
//        timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
////                lblShowDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
////                lblShowTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
//            }
//        }), new KeyFrame(Duration.seconds(1)));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//    }
}
