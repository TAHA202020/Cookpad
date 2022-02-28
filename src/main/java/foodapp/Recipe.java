package foodapp;
import foodapp.controller.FoodAppController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaMarkerEvent;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    List<String> instructions=new ArrayList<>();
    int id;
    String image;
    public String name;
    List<Ingredient> ingredients;
    public Recipe(String name,List<Ingredient> ingredients)
    {
        this.name=name;
        this.ingredients =ingredients;
    }
    public Recipe(String name,List<Ingredient> ingredients,int id,String image)
    {
        this.id=id;
        this.image=image;
        this.name=name;
        this.ingredients =ingredients;
    }
    public Recipe(String name,int id,String image)
    {
        this.id=id;
        this.image=image;
        this.name=name;
    }
    public void setIngredients(List<Ingredient>ingredients)
    {
        this.ingredients=ingredients;
    }
    public int getId()
    {
        return id;
    }
    public List<Ingredient> ingredients()
    {
        return ingredients;
    }
    public void setInstructions(List<String> instructions)
    {
        this.instructions=instructions;
    }
    public void string()
    {
        System.out.println("Id:"+id+"\n"+"Name:"+name+"\n"+"Ingredients:");
        for (int i=0;i<ingredients.size();i++)
        {
            System.out.print(ingredients.get(i).ingredient+"\n");
        }
        System.out.println("Steps:");
        for (String step:instructions)
        {
            System.out.println(step);
        }
    }
    public VBox vBox()
    {
        Button btn=new Button("Add To Fav");
        Button btn1=new Button("See Full Recipe");
        btn.getStyleClass().add("custombut");
        btn1.getStyleClass().add("custombut");
        VBox result =new VBox();
        result.setAlignment(Pos.TOP_CENTER);
        result.setPrefHeight(406);
        result.setPrefWidth(332);
        ImageView imageView =new ImageView(new Image(image));
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);
        HBox hBox =new HBox();
        hBox.setPadding(new Insets(10,0,0,0));
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(40);
        hBox.getChildren().add(btn);
        hBox.getChildren().add(btn1);
        btn.setOnAction((event ->
        {
            if (!FoodAppController.ids.contains(this.id))
            {
                FoodAppController.favorite.add(this);
                FoodAppController.ids.add(this.id);
            }
            FoodAppController.favorite.string();
        }));
        result.getChildren().add(imageView);
        result.getChildren().add(hBox);
        result.getStyleClass().add("item");
        return result;
    }
}
