package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class VehicleController {
    @FXML
    private Button btnCancle;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtYear;


    public void save(ActionEvent actionEvent) {
        String model = txtModel.getText();
        String brand = txtName.getText();
        int price = Integer.parseInt(txtPrice.getText());
        int year = Integer.parseInt(txtYear.getText());

        //load the installed driver to this class

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicles", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicles (brand,model,year,price) values(?,?,?,?)");
            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, year);
            preparedStatement.setObject(4,price);

            // execute query
            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("Vehicle added successfully");
            }else {
                System.out.println("Vehicle not added");
            }



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cancle(ActionEvent actionEvent) {
        System.exit(0);
    }

}









