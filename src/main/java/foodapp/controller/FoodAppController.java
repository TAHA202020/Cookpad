package foodapp.controller;
import foodapp.Recipe;
import foodapp.utils.utilsme;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class FoodAppController implements Initializable {
    public static List<Integer> choosenids=new ArrayList<>();
    @FXML
    ScrollPane scroll2;
    @FXML
    ImageView recipeimg;
    @FXML
    Label recipeviewname;
    @FXML
    Pane app;
    @FXML
    ScrollPane scroll1;
    @FXML
    VBox mainmenu;
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
    @FXML
    void goback()
    {
        scroll1.setVisible(true);
        scroll2.setVisible(false);
    }
    public void initialize(URL location, ResourceBundle resourceBundle)
    {
        try {
            HBox hBox =new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.setPrefHeight(205);
            hBox.setMinHeight(205);
            hBox.setSpacing(50);
            List<Recipe> recipes=utilsme.getRecipes();
            for (int i=0;i<4;i++)
            {
                int j=i;
                VBox item=recipes.get(i).Item();
                item.setOnMouseEntered(event ->
                {
                    VBox vBox=(VBox) event.getSource();
                    ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.1),vBox);
                    scaleTransition.setToY(1.1);
                    scaleTransition.setToX(1.1);
                    scaleTransition.play();
                });
                item.setOnMouseExited(event ->
                {
                    VBox vBox=(VBox) event.getSource();
                    ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.2),vBox);
                    scaleTransition.setToY(1);
                    scaleTransition.setToX(1);
                    scaleTransition.play();
                });
                item.setOnMouseClicked(event ->
                {
                    viewitem(recipes.get(j));
                });
                hBox.getChildren().add(item);
            }
            mainmenu.getChildren().add(hBox);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    void viewitem(Recipe recipe)
    {
        recipeimg.setImage(new Image(recipe.getImage()));
        recipeviewname.setText(recipe.getName());
        scroll2.setVisible(true);
        scroll1.setVisible(false);
    }
}


