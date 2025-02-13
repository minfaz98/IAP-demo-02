package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StudentController {

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNumber;

    Student[] students = new Student[10];
    int index = 0;

    @FXML
    public void save(ActionEvent event) {

        String address = txtAddress.getText();
        int age = Integer.parseInt(txtAge.getText());
        String name = txtName.getText();
        String number = txtNumber.getText();

        Student std = new Student(address,age,name,number);
        students[index] = std;
        index++;

        System.out.println("save success");

    }

}
