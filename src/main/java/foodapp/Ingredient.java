package foodapp;

public class Ingredient {
    String amount;
    String ingredient;
    public Ingredient(String ingredient)
    {
        this.ingredient=ingredient;
    }
    public Ingredient(String ingredient,String amount)
    {
        this.amount=amount;
        this.ingredient=ingredient;
    }
    public String getIngredient()
    {
        return ingredient;
    }
}
