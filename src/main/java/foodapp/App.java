package foodapp;
import org.json.*;
import java.util.ArrayList;
import java.util.List;

import static foodapp.utils.utilsme.*;

public class App {
    /*JsonReader jsonReader=new JsonReader("findByIngredients.json");
    private int choosen;
    private Favorite favorite=new Favorite();
    public int showRecipes() throws JSONException {
        String data =jsonReader.getJsonString();
        JSONArray jsonArray =new JSONArray(data);
        System.out.println("choose recipe :");
        for (int index =0 ;index<jsonArray.length();index++)
        {
            System.out.print((index+1)+" ");
            System.out.println((jsonArray.getJSONObject(index)).getString("title"));
        }
        System.out.println("press 0 to end APP");
        int response= response(jsonArray.length());
        if (response==0)
        {
            return 2;
        }
        choosen=response;
        JSONObject result = jsonArray.getJSONObject(response-1);
        JSONArray array= result.getJSONArray("missedIngredients");
        System.out.println("ingredients");
        for (int index=0;index<array.length();index++)
        {
            JSONObject object =array.getJSONObject(index);
            String sout1 =object.get("original").toString();
            System.out.println(sout1);
        }
        System.out.println("press:");
        System.out.println("1-to add to favorite");
        System.out.println("2-show favorite recipes");
        System.out.println("3-end app");
        int response1 = response(4);
        if (response1==1)
        {
            List<Ingredient> ingredients =new ArrayList<>();
            String name =(jsonArray.getJSONObject(choosen-1)).getString("title");
            JSONArray array2=  result.getJSONArray("missedIngredients");
            System.out.println("ingredients");
            for (int index=0;index<array2.length();index++)
            {
                JSONObject object =array.getJSONObject(index);
                String sout1 =object.getString("original");
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
        int response = response(3);
        if (response==1)
        {
            return 0;
        }
        else
            return 2;
    }
    public void launch(int menu) throws JSONException {
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
    }*/

    public static void main(String[] args) throws Exception {
        List<Recipe> recipes=getRecipes();
        for (int i=0;i<recipes.size();i++)
        {
            recipes.get(i).string();
        }
    }

}
