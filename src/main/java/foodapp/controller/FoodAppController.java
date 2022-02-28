package foodapp.controller;
import foodapp.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static foodapp.utils.utilsme.getRecipes;

public class FoodAppController implements Initializable {
    public static Favorite favorite=new Favorite();
    public static List<Integer> ids=new ArrayList<>();
    int offset=6;
    boolean stillSearching =false;
    ApiCall apiCall=new ApiCall();
    boolean open=false;
    @FXML
    AnchorPane favoritepane;
    @FXML
    ScrollPane scrollPane;
    @FXML
    TextField textField;
    @FXML
    Button searchbtn;
    @FXML
    VBox vBox;
    @FXML
    ImageView imageView;

    @FXML
    void changeFavoriteIcone()
    {
        if (!open)
        {
            scrollPane.setVisible(false);
            favoritepane.setVisible(true);
            imageView.setImage(new Image("file:src/main/resources/app/foodapp/view/img/onclickpic.png"));
            open=true;
        }
        else
        {
            scrollPane.setVisible(true);
            favoritepane.setVisible(false);
            imageView.setImage(new Image("file:src/main/resources/app/foodapp/view/img/heart.png"));
            open=false;
        }
    }
    @FXML
    void search()
    {
        stillSearching=true;
        offset=0;
        vBox.getChildren().clear();
        try {
            int count=0;
            List<Recipe> recipes=getRecipes(apiCall.ApiCallurlRecipe(textField.getText(),6,offset));
            for (int j=0;j<9&& count<recipes.size();j++)
            {
                HBox hBox=new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(100);
                hBox.setMinHeight(406);
                hBox.setPrefWidth(406);
                for (int i=0;i<3 && count<recipes.size() ;i++)
                {
                    hBox.getChildren().add(recipes.get(count).vBox());
                    count++;
                }
                vBox.getStyleClass().add("container");
                vBox.getChildren().add(hBox);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void loadmore()
    {
        if (stillSearching)
        {
            System.out.println(apiCall.query);
            try {
                int count=0;
                List<Recipe> recipes=getRecipes(apiCall.ApiCallurlRecipe(apiCall.query,6,offset));
                for (int j=0;j<9&& count<recipes.size();j++)
                {
                    HBox hBox=new HBox();
                    hBox.setAlignment(Pos.CENTER);
                    hBox.setSpacing(100);
                    hBox.setMinHeight(406);
                    hBox.setPrefWidth(406);
                    for (int i=0;i<3 && count<recipes.size() ;i++)
                    {
                        hBox.getChildren().add(recipes.get(count).vBox());
                        count++;
                    }
                    vBox.getStyleClass().add("container");
                    vBox.getChildren().add(hBox);
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                int count=0;
                List<Recipe> recipes=getRecipes(apiCall.ApiCallurlRecipe(6,offset));
                for (int j=0;j<9&& count<recipes.size();j++)
                {
                    HBox hBox=new HBox();
                    hBox.setAlignment(Pos.CENTER);
                    hBox.setSpacing(100);
                    hBox.setMinHeight(406);
                    hBox.setPrefWidth(406);
                    for (int i=0;i<3 && count<recipes.size() ;i++)
                    {
                        hBox.getChildren().add(recipes.get(count).vBox());
                        count++;
                    }
                    vBox.getStyleClass().add("container");
                    vBox.getChildren().add(hBox);
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        offset+=6;

    }
    @FXML
    public void onScroll()
    {
        if (scrollPane.getVvalue()==scrollPane.getVmax())
        {
            loadmore();
        }
    }
    @FXML
    public void Homebtn()
    {
        vBox.getChildren().clear();
        offset=0;
        loadmore();
    }


    public void initialize(URL location, ResourceBundle resourceBundle)
    {
        try {
            int count=0;
            List<Recipe> recipes=getRecipes(apiCall.ApiCallurlRecipe(6,offset));
            for (int j=0;j<9&& count<recipes.size();j++)
            {
                HBox hBox=new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(100);
                hBox.setMinHeight(406);
                hBox.setPrefWidth(406);
                for (int i=0;i<3 && count<recipes.size() ;i++)
                {
                    hBox.getChildren().add(recipes.get(count).vBox());
                    count++;
                }
                vBox.getStyleClass().add("container");
                vBox.getChildren().add(hBox);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        offset+=6;
    }
}


