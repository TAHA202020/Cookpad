package foodapp.controller;
import foodapp.*;
import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class FoodAppController implements Initializable {
    @FXML
    TextField textField;
    @FXML
    AnchorPane searchAnchor;
    @FXML
    Button closesearchbtn;
    @FXML
    void stopsearching()
    {
        if (textField.getText()=="")
        {
            searchAnchor.setScaleX(0);
            searchAnchor.setScaleY(0);
        }
        else
            textField.setText("");
    }
    @FXML
    void insideButton(MouseEvent e)
    {
        Button btn =(Button) e.getSource();
        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.1),btn);
        scaleTransition.setToY(1.1);
        scaleTransition.setToX(1.1);
        scaleTransition.play();
    }
    @FXML
    void LeaveButton(MouseEvent e)
    {
        Button btn=(Button) e.getSource();
        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.1),btn);
        scaleTransition.setToY(1);
        scaleTransition.setToX(1);
        scaleTransition.play();
    }
    @FXML
    void startSearch()
    {
        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.2),searchAnchor);
        scaleTransition.setToY(1);
        scaleTransition.setToX(1);
        scaleTransition.play();
    }
    public void initialize(URL location, ResourceBundle resourceBundle)
    {
    }
}


