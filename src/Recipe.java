import java.util.ArrayList;
import java.util.List;

public class Recipe {
    String name;
    List<Ingredient> ingredients=new ArrayList<>();
    public Recipe(String name,List<Ingredient> ingredients)
    {
        this.name=name;
        this.ingredients =ingredients;
    }
    public List<Ingredient> ingredients()
    {
        return ingredients;
    }
}
