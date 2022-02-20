package foodapp;
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
}
