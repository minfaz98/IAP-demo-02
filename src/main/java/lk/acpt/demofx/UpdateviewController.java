package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

public class UpdateviewController {
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtYear;

    @FXML
    void cancel(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void search(ActionEvent event) {
        int id= Integer.parseInt(txtId.getText());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicles", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles where id = ?");
            preparedStatement.setObject(1,id);



            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                txtBrand.setText(resultSet.getString("brand"));
                txtModel.setText(resultSet.getString("model"));
                txtPrice.setText(String.valueOf(resultSet.getInt("price")));
                txtYear.setText(String.valueOf(resultSet.getInt("year")));
            }





        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void update(ActionEvent event) {

        int id= Integer.parseInt(txtId.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        String price = txtPrice.getText();
        int year = Integer.parseInt(txtYear.getText());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicles", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("update vehicles set brand = ?, model = ?, year = ? , price = ? where id = ?");
            preparedStatement.setObject(1,brand);
            preparedStatement.setString(2,model);
            preparedStatement.setInt(3,year);
            preparedStatement.setString(4,price);
            preparedStatement.setInt(5,id);


            preparedStatement.executeUpdate();

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("Vehicle updated successfully");
            }else {
                System.out.println("Vehicle not updated successfully");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}




