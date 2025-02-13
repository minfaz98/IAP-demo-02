//package lk.acpt.demofx;
//
//import javafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.net.URL;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class LoadviewController implements Initializable {
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        tblView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
//        tblView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Brand"));
//        tblView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Model"));
//        tblView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Year"));
//        tblView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Price"));
//
//        ArrayList<Vehicles> vehicles = loaddata();
//        tblView.setItems(FXCollections.observableArrayList(vehicles));
//
//    }
//
//    @FXML
//    private Button btnButton;
//
//    @FXML
//    private TableView<Vehicles> tblView;
//
//    @FXML
//
//
//    public ArrayList<Vehicles> loaddata() {
//
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicles", "root", "root");
//
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles");
//
//            // execute query
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            ArrayList<Vehicles> list = new ArrayList<>();
//
//            Vehicles vehicles = new Vehicles();
//
//
//            while(resultSet.next()){
//                vehicles.setId(resultSet.getInt(1));
//                vehicles.setBrand(resultSet.getString(2));
//                vehicles.setModel(resultSet.getString(3));
//                vehicles.setYear(resultSet.getInt(4));
//                vehicles.setPrice(resultSet.getInt(5));
//
//                list.add(vehicles);
//
//            }
//            return list;
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @FXML
//    void show(ActionEvent event) {
//
//        //fx table configure
//
//
//
//    }
//
//
//}

package lk.acpt.demofx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoadviewController implements Initializable {

    @FXML
    private Button btnButton;

    @FXML
    private TableView<Vehicles> tblView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (tblView != null && !tblView.getColumns().isEmpty()) {
            tblView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
            tblView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Brand"));
            tblView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Model"));
            tblView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Year"));
            tblView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Price"));
        }

        tblView.setItems(loaddata());
    }

    public ObservableList<Vehicles> loaddata() {
        ObservableList<Vehicles> list = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicles", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Vehicles vehicles = new Vehicles();
                vehicles.setId(resultSet.getInt(1));
                vehicles.setBrand(resultSet.getString(2));
                vehicles.setModel(resultSet.getString(3));
                vehicles.setYear(resultSet.getInt(4));
                vehicles.setPrice(resultSet.getInt(5));

                list.add(vehicles);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @FXML
    void show(ActionEvent event) {
        tblView.setItems(loaddata());
    }
}

