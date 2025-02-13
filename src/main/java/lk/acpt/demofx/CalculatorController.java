package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {


    String calculation = null;
    @FXML
    private TextField txtNum1;
    @FXML
    private TextField txtNum2;
    @FXML
    private Label lblAnswer;


    @FXML
    void add(ActionEvent event) {
        calculation = "add";


    }

    @FXML
    void divied(ActionEvent event) {
        calculation = "divide";


    }

    @FXML
    void equal(ActionEvent event) {
        int num1 = Integer.parseInt(txtNum1.getText());
        int num2 = Integer.parseInt(txtNum2.getText());

        int result = 0;
        switch (calculation) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "divide":
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid calculation");
                break;


        }
        lblAnswer.setText(String.valueOf(result));


    }

    @FXML
    void mul(ActionEvent event) {
        calculation = "mul";

    }

    @FXML
    void sub(ActionEvent event) {
        calculation = "sub";

    }

}
