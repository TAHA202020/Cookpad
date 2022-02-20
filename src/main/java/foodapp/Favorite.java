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
}
