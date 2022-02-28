package foodapp.utils;
import foodapp.ApiCall;
import foodapp.Ingredient;
import foodapp.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class utilsme {
    public static int response(int size)
    {

        Scanner scanner =new Scanner(System.in);
        String result =scanner.next();
        try {
            int value = Integer.parseInt(result);
            if (value>size)
            {
                System.out.println("number has to be less than "+size);
                return response(size);
            }
            else
                return value;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
            return response(size);
        }
    }
    public static void addIngredients(List<Recipe> recipes) throws Exception {
        ApiCall apiCall=new ApiCall();
        for (int index=0;index<recipes.size();index++)
        {
            List<Ingredient> ingredients=new ArrayList<>();
            int id = recipes.get(index).getId();
            String result= apiCall.ApiCallurlinGredients(id);
            JSONObject jsonObject=new JSONObject(result);
            JSONArray jsonArray =jsonObject.getJSONArray("ingredients");
            for (int index2=0;index2<jsonArray.length();index2++)
            {
                JSONObject jsonObject1= jsonArray.getJSONObject(index2);
                String name= jsonObject1.getString("name");
                JSONObject amount1=jsonObject1.getJSONObject("amount");
                JSONObject amount2=amount1.getJSONObject("metric");
                String amount = amount2.getInt("value")+" "+ amount2.getString("unit");
                Ingredient ingredient=new Ingredient(name,amount);
                ingredients.add(ingredient);
            }
            recipes.get(index).setIngredients(ingredients);
        }
    }
    public static void addInstrctions(List<Recipe> recipes) throws Exception {
        ApiCall apiCall=new ApiCall();
        List<List<String>> stepslist=new ArrayList<>();
        for (int i =0;i<recipes.size();i++)
        {
            List<String> stepss=new ArrayList<>();
            int id = recipes.get(i).getId();
            String result=apiCall.ApiCallurlInstruction(id);
            JSONArray jsonArray=new JSONArray(result);
            for (int index1=0;index1< jsonArray.length();index1++)
            {
                JSONObject jsonObject= jsonArray.getJSONObject(index1);
                JSONArray steps=jsonObject.getJSONArray("steps");
                for (int index=0;index<steps.length();index++)
                    {
                        JSONObject object=steps.getJSONObject(index);
                        String step = object.getString("step");
                        stepss.add(step);
                    }
            }
            stepslist.add(stepss);

        }
        for (int j=0;j<recipes.size();j++)
        {
            recipes.get(j).setInstructions(stepslist.get(j));
        }

    }
    public static List<Recipe> getRecipes(String jsononbject) throws Exception {
        List<Recipe> result=new ArrayList<>();
        JSONObject jsonObject= new JSONObject(jsononbject);
        JSONArray jsonArray=jsonObject.getJSONArray("results");
        for (int i=0;i<jsonArray.length();i++)
        {
            JSONObject jsonObject1=  jsonArray.getJSONObject(i);
            Recipe recipe=new Recipe(jsonObject1.getString("title"), jsonObject1.getInt("id"),jsonObject1.getString("image"));
            result.add(recipe);
        }
        addIngredients(result);
        addInstrctions(result);
        return result;
    }
}
