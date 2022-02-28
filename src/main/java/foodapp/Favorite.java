package foodapp;

import java.util.ArrayList;
import java.util.List;

public class Favorite {
    private List<Recipe> recipes =new ArrayList<>();
    public Favorite(){}
    public List<Recipe> recipes()
    {
        return recipes;
    }
    public void add(Recipe addin)
    {
        recipes.add(addin);
    }
    public void remove(int index)
    {
        recipes.remove(index);
    }
    public void string()
    {
        for (int i=0;i<recipes.size();i++)
        {
            System.out.println(recipes.get(i).name);
        }
        System.out.println("-------------------------");
    }
    public Recipe get(int index)
    {
        return recipes.get(index);
    }
}
