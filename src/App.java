import org.json.simple.*;
import utils.utilsme;
import java.util.ArrayList;
import java.util.List;

public class App {
    JsonReader jsonReader=new JsonReader("findByIngredients.json");
    private int choosen;
    private Favorite favorite=new Favorite();
    public int showRecipes()
    {
        String data =jsonReader.getJsonString();
        JSONArray jsonArray =(JSONArray) JSONValue.parse(data);
        System.out.println("choose recipe :");
        for (int index =0 ;index<jsonArray.size();index++)
        {
            System.out.print((index+1)+" ");
            System.out.println(((JSONObject)jsonArray.get(index)).get("title"));
        }
        System.out.println("press 0 to end APP");
        int response= utils.utilsme.response(jsonArray.size());
        if (response==0)
        {
            return 2;
        }
        choosen=response;
        JSONObject result =(JSONObject) jsonArray.get(response-1);
        JSONArray array= (JSONArray) result.get("missedIngredients");
        System.out.println("ingredients");
        for (int index=0;index<array.size();index++)
        {
            JSONObject object =(JSONObject) array.get(index);
            String sout1 =object.get("original").toString();
            System.out.println(sout1);
        }
        System.out.println("press:");
        System.out.println("1-to add to favorite");
        System.out.println("2-show favorite recipes");
        System.out.println("3-end app");
        int response1 = utilsme.response(4);
        if (response1==1)
        {
            List<Ingredient> ingredients =new ArrayList<>();
            String name =((JSONObject)jsonArray.get(choosen-1)).get("title").toString();
            JSONArray array2= (JSONArray) result.get("missedIngredients");
            System.out.println("ingredients");
            for (int index=0;index<array2.size();index++)
            {
                JSONObject object =(JSONObject) array.get(index);
                String sout1 =object.get("original").toString();
                Ingredient ingredient =new Ingredient(sout1);
                ingredients.add(ingredient);
            }
            Recipe recipe =new Recipe(name,ingredients);
            favorite.add(recipe);
            return 1;
        }
        if (response1==2)
            return 1;
        else
            return 2;
    }
    public int showFavorites()
    {
        List<Recipe>recipes=favorite.recipes();
        for (int index=0;index<recipes.size();index++)
        {
            System.out.println((index+1)+" Favorite Recipe");
            Recipe recipe = recipes.get(index);
            System.out.println(recipe.name);
            List<Ingredient> ingredients =recipe.ingredients();
            for (int k=0;k<ingredients.size();k++)
            {
                System.out.println(ingredients.get(k).getIngredient());
            }
        }
        System.out.println("press");
        System.out.println("1- show all recipes");
        System.out.println("2-end app");
        int response = utilsme.response(3);
        if (response==1)
        {
            return 0;
        }
        else
            return 2;
    }
    public void launch(int menu)
    {
        int response;
        if (menu==0)
        {
            response=showRecipes();
            launch(response);
        }
        if(menu==1)
        {
            response=showFavorites();
            launch(response);
        }
        if (menu==2)
        {
        }
    }


    public static void main(String[] args) {
        App app=new App();
        app.launch(0);
    }
}
