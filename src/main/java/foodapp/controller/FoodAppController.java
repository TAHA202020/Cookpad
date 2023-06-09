package foodapp.controller;
import foodapp.Favorite;
import foodapp.Ingredient;
import foodapp.Recipe;
import foodapp.utils.utilsme;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;


public class FoodAppController implements Initializable {
    List<Recipe> Todisplay=new ArrayList<>();
    boolean searching=false;
    boolean textfieldshown=false;
    List<Recipe> saved=new ArrayList<>();
    Favorite favorite=new Favorite();
    List<Recipe> recipes;
    Label requirementslabl=new Label();
    Label instructionslabl=new Label();
    public static List<Integer> choosenids=new ArrayList<>();
    @FXML
    CheckBox checkBoxTime;
    @FXML
    CheckBox checkBoxpop;
    @FXML
    VBox ingredientsview;
    @FXML
    VBox requirementsview;
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
    Button upbtn;
    @FXML
    CheckBox checkBoxhealthy;
    @FXML
    CheckBox checkBoxprice;
    @FXML
    void stopsearching()
    {
        if (textField.getText()=="")
        {
            searchAnchor.setScaleX(0);
            searchAnchor.setScaleY(0);
            textfieldshown=false;
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
    void startSearch()
    {
        textfieldshown=true;
        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.2),searchAnchor);
        scaleTransition.setToY(1);
        scaleTransition.setToX(1);
        scaleTransition.play();
    }
    @FXML
    void checkv()
    {
        if (scroll1.getVvalue()==scroll1.getVmin())
        {
            upbtn.setVisible(false);
        }
        else
            upbtn.setVisible(true);
    }
    @FXML
    void up()
    {
        scroll1.setVvalue(0);
        upbtn.setVisible(false);
    }
    @FXML
    void goback()
    {
        checkv();
        scroll1.setVisible(true);
        scroll2.setVisible(false);
    }
    public void initialize(URL location, ResourceBundle resourceBundle)
    {
        requirementslabl.setText("requirements");
        ImageView imageView=new ImageView(new Image("file:src/main/resources/app/foodapp/view/img/ingredients.png"));
        imageView.setFitWidth(50);
        imageView.setFitHeight(40);
        requirementslabl.setGraphic(imageView);
        requirementslabl.setPadding(new Insets(0,0,30,0));
        instructionslabl.setText("instructions");
        ImageView imageView1=new ImageView(new Image("file:src/main/resources/app/foodapp/view/img/requirement.png"));
        imageView1.setFitWidth(50);
        imageView1.setFitHeight(40);
        instructionslabl.setGraphic(imageView1);
        instructionslabl.setPadding(new Insets(0,0,30,0));
        requirementsview.setPadding(new Insets(0,0,30,0));
        ingredientsview.setPadding(new Insets(0,0,30,0));
        try {
            recipes=utilsme.getRecipes();
            displayRecipes(recipes);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    void displayRecipes(List<Recipe> recipes)
    {
        for (int j=0;j<12&&j<recipes.size();j+=4)
        {
            HBox hBox =new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.setPrefHeight(205);
            hBox.setMinHeight(205);
            hBox.setSpacing(50);
            for (int i=j;i<j+4&& i<recipes.size();i++)
            {
                int k=i;
                Image save=new Image("file:src/main/resources/app/foodapp/view/img/star.png");
                Image favourite=new Image("file:src/main/resources/app/foodapp/view/img/save-instagram.png");
                Image unsave=new Image("file:src/main/resources/app/foodapp/view/img/minus.png");
                Image unfavourite=new Image("file:src/main/resources/app/foodapp/view/img/bookmark.png");
                ImageView saveimg=new ImageView(save);
                ImageView favouriteimg=new ImageView(favourite);
                favouriteimg.setFitHeight(15);
                favouriteimg.setFitWidth(15);
                saveimg.setFitHeight(15);
                saveimg.setFitWidth(15);
                Button btnstart=new Button();
                Button btn=new Button();
                btnstart.getStyleClass().add("searchbtn");
                btn.getStyleClass().add("searchbtn");
                btn.setGraphic(favouriteimg);
                btnstart.setGraphic(saveimg);
                btn.setOnAction(event ->
                {
                    if (!favorite.contains(recipes.get(k)))
                    {
                        favorite.add(recipes.get(k));
                        favouriteimg.setImage(unfavourite);
                    }
                    else
                    {
                        favorite.remove(recipes.get(k).getId());
                        favouriteimg.setImage(favourite);
                    }
                    favorite.string();
                });
                btnstart.setOnAction(event ->
                {
                    if (!saved.contains(recipes.get(k)))
                    {
                        saved.add(recipes.get(k));
                        saveimg.setImage(unsave);
                    }
                    else
                    {
                        saveimg.setImage(save);
                        for (int l=0;l<saved.size();l++)
                        {
                            if (saved.get(l).getId()==recipes.get(k).getId())
                            {
                                saved.remove(l);
                            }
                        }
                    }
                });
                VBox item=recipes.get(i).Item(btn,btnstart);
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
                    viewitem(recipes.get(k));
                });
                hBox.getChildren().add(item);
            }
            mainmenu.getChildren().add(hBox);
        }

    }
    void viewitem(Recipe recipe)
    {
        startSearch();
        ingredientsview.getChildren().clear();
        requirementsview.getChildren().clear();
        ingredientsview.getChildren().add(requirementslabl);
        requirementsview.getChildren().add(instructionslabl);
        recipeimg.setImage(new Image(recipe.getImage()));
        recipeviewname.setText(recipe.getName());
        List<Ingredient> ingredients=recipe.ingredients();
        List<String> instructions=recipe.getInstructions();
        for (int i=0;i<ingredients.size();i++)
        {
            Label label=new Label(i+"-  "+ingredients.get(i).getIngredient());
            label.setWrapText(true);
            label.setFont(Font.font("Arial",12));
            ingredientsview.getChildren().add(label);
        }
        for (int i=0;i<instructions.size();i++)
        {
            Label label=new Label(i+"-  "+instructions.get(i));
            label.setWrapText(true);
            label.setFont(Font.font("Arial",12));
            requirementsview.getChildren().add(label);
        }
        scroll2.setVisible(true);
        scroll1.setVisible(false);
        upbtn.setVisible(false);
    }
    @FXML
    void sortbypopoularity()
    {
        checkBoxhealthy.setSelected(false);
        checkBoxTime.setSelected(false);
        checkBoxprice.setSelected(false);
        mainmenu.getChildren().clear();
        up();
        if (!searching)
        {
            if (checkBoxpop.isSelected())
            {
                List<Recipe> Todisplay=new ArrayList<>();
                for (int i=0;i<recipes.size();i++)
                {
                    if (recipes.get(i).isVeryPopular())
                    {
                        Todisplay.add(recipes.get(i));
                    }
                }
                for (int i=0;i<recipes.size();i++)
                {
                    if (!Todisplay.contains(recipes.get(i)))
                    {
                        Todisplay.add(recipes.get(i));
                    }
                }

                displayRecipes(Todisplay);
            }
            else
                displayRecipes(recipes);
        }
        else
        {
            if (checkBoxpop.isSelected())
            {
                List<Recipe> Todisplayy=new ArrayList<>();
                for (int i=0;i<Todisplay.size();i++)
                {
                    if (Todisplay.get(i).isVeryPopular())
                    {
                        Todisplayy.add(Todisplay.get(i));
                    }
                }
                for (int i=0;i<Todisplay.size();i++)
                {
                    if (!Todisplayy.contains(Todisplay.get(i)))
                    {
                        Todisplayy.add(Todisplay.get(i));
                    }
                }

                displayRecipes(Todisplayy);
            }
            else
                displayRecipes(Todisplay);
        }
    }
    @FXML
    void sortByHealth()
    {
        up();
        checkBoxTime.setSelected(false);
        checkBoxpop.setSelected(false);
        checkBoxprice.setSelected(false);
        mainmenu.getChildren().clear();
        if (!searching)
        {
            if (checkBoxhealthy.isSelected())
            {
                List<Recipe> Todisplayy=new ArrayList<>();
                for (int i=0;i<recipes.size();i++)
                {
                    if (recipes.get(i).isVeryHealthy())
                    {
                        Todisplayy.add(recipes.get(i));
                    }
                }
                for (int i=0;i<recipes.size();i++)
                {
                    if (!Todisplayy.contains(recipes.get(i)))
                    {
                        Todisplayy.add(recipes.get(i));
                    }
                }

                displayRecipes(Todisplayy);
            }
            else
                displayRecipes(recipes);
        }
        else
        {
            if (checkBoxhealthy.isSelected())
            {
                List<Recipe> Todisplayy=new ArrayList<>();
                for (int i=0;i<Todisplay.size();i++)
                {
                    if (Todisplay.get(i).isVeryHealthy())
                    {
                        Todisplayy.add(Todisplay.get(i));
                    }
                }
                for (int i=0;i<Todisplay.size();i++)
                {
                    if (!Todisplayy.contains(Todisplay.get(i)))
                    {
                        Todisplayy.add(Todisplay.get(i));
                    }
                }

                displayRecipes(Todisplayy);
            }
            else
                displayRecipes(Todisplay);
        }

    }
    @FXML
    void sortByPrice()
    {
        up();
        checkBoxTime.setSelected(false);
        checkBoxpop.setSelected(false);
        checkBoxhealthy.setSelected(false);
        mainmenu.getChildren().clear();
        if (checkBoxprice.isSelected())
        {
            List<Recipe> Todisplay=new ArrayList<>();
            List<Float> prices=new ArrayList<>();
            List<Integer> ids=new ArrayList<>();
            for (int i=0;i<recipes.size();i++)
            {
                prices.add(recipes.get(i).getPrice()/(float)100);
            }
            Collections.sort(prices);
            for (int i=0;i<prices.size();i++)
            {
                for (int j=0;j<recipes.size();j++)
                {
                    if (prices.get(i)==(recipes.get(j).getPrice()/(float)100) && !ids.contains(recipes.get(j).getId()))
                    {
                        Todisplay.add(recipes.get(j));
                        ids.add(recipes.get(j).getId());
                        break;
                    }
                }
            }
            displayRecipes(Todisplay);
        }
        else
            displayRecipes(recipes);

    }
    @FXML
    void sortByTime()
    {
        checkBoxhealthy.setSelected(false);
        checkBoxpop.setSelected(false);
        checkBoxprice.setSelected(false);
        mainmenu.getChildren().clear();
        up();
        if (checkBoxTime.isSelected())
        {
            List<Recipe> Todisplay=new ArrayList<>();
            List<Integer> ids=new ArrayList<>();
            List<Integer> times=new ArrayList<>();
            for (int i=0;i<recipes.size();i++)
            {
                times.add(recipes.get(i).getTime());
            }
            Collections.sort(times);
            for (int i=0;i<times.size();i++)
            {
                for (int j=0;j<recipes.size();j++)
                {
                    if (times.get(i)==recipes.get(j).getTime() && !ids.contains(recipes.get(j).getId()))
                    {
                        Todisplay.add(recipes.get(j));
                        ids.add(recipes.get(j).getId());
                        break;
                    }
                }
            }
            displayRecipes(Todisplay);
        }
        else
            displayRecipes(recipes);
    }
    @FXML
    void globalsearch()
    {
        untag();
        Todisplay.clear();
        System.out.println(textfieldshown);
        if (textfieldshown && textField.getText()!="")
        {
            mainmenu.getChildren().clear();
            String search=textField.getText();
            for (int i=0;i<recipes.size();i++)
            {
                if (recipes.get(i).name.toLowerCase().contains(search.toLowerCase()))
                {
                    Todisplay.add(recipes.get(i));
                    break;
                }
                List<Ingredient> ingredients=recipes.get(i).ingredients();
                for (int j=0;j<ingredients.size();j++)
                {
                    if (ingredients.get(j).getIngredient().toLowerCase().contains(search.toLowerCase()))
                    {
                        Todisplay.add(recipes.get(i));
                        break;
                    }
                }
            }
            searching=true;
            System.out.println(Todisplay);
            displayRecipes(Todisplay);
        }
        else
        {
            startSearch();
        }
    }
    @FXML
    void Homebtn()
    {
        Todisplay.clear();
        searching=false;
        mainmenu.getChildren().clear();
        scroll1.setVisible(true);
        scroll2.setVisible(false);
        untag();
        up();
        displayRecipes(recipes);
    }
    void untag()
    {
        checkBoxhealthy.setSelected(false);
        checkBoxprice.setSelected(false);
        checkBoxpop.setSelected(false);
        checkBoxTime.setSelected(false);
    }
    @FXML
    void leavebtn()
    {
        Platform.exit();
    }
    @FXML
    void minimize(MouseEvent e)
    {
        ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
    }
}


