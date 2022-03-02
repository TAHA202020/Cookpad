package foodapp;
import foodapp.controller.FoodAppController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaMarkerEvent;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    boolean vegan;
    boolean cheap;
    boolean veryPopular;
    boolean veryHealthy;
    List<String> cuisines=new ArrayList<>();
    List<String> instructions=new ArrayList<>();
    int id;
    String image;
    public String name;
    List<Ingredient> ingredients;
    public Recipe(String name,List<Ingredient> ingredients,List<String> instructions,List<String> cuisines,String image,int id,boolean vegan,boolean cheap,boolean veryHealthy,boolean veryPopular)
    {
        this.id=id;
        this.instructions=instructions;
        this.ingredients=ingredients;
        this.cuisines=cuisines;
        this.name=name;
        this.image= image;
        this.vegan=vegan;
        this.cheap=cheap;
        this.veryHealthy=veryHealthy;
        this.veryPopular=veryPopular;
    }

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
        System.out.println("Id:"+id+"\n"+"Name:"+name+"\n"+"Image:"+image+"\n"+"Ingredients:");
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
    public void String()
    {
        System.out.println(id);
        System.out.println(name);
        System.out.println(image);
        System.out.println(cheap);
        System.out.println(veryHealthy);
        System.out.println(veryPopular);
        System.out.println(vegan);
        System.out.println("----------------------");

    }

}
