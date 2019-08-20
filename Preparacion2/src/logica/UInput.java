package logica;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.event.ActionEvent;


public class UInput {

    @FXML
    Label message;

    @FXML
    Button okbtn;

    public void setMessage(int points){
        message.setText("Felicidades! obtuvo: "+ String.valueOf(points) + " puntos");
        System.out.println(points);
    }

    @FXML
    public void okPressed(ActionEvent e){
        Stage stage = (Stage) okbtn.getScene().getWindow();
        stage.close();
    }

}
