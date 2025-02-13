package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteviewController {
    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtDelete;

    @FXML
    void delete(ActionEvent event) {
        int delete = Integer.parseInt(txtDelete.getText());

        //load the installed driver to this class

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicles", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vehicles WHERE id = ?");
            preparedStatement.setObject(1, delete);


            // execute query
            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("Vehicle Deleted successfully");
            }else {
                System.out.println("Vehicle not Deleted successfully");
            }



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
