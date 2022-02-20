package foodapp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ApiCall
{
    String query="";
    final String ingredientsbyID="/ingredientWidget.json?";
    final String baseUrl="https://api.spoonacular.com/recipes/";
    final String urlRecipe="complexSearch?";
    final String instructionUrl="/analyzedInstructions?";
    final String apiKey="apiKey=054b79ccf9ee4063874b047b6fe171a0";
    public ApiCall()
    {}
    private String Call(String callurl) throws Exception
    {
        URL url = new URL(callurl);
        URLConnection connection = url.openConnection();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())))
        {
            String line;
            if ((line = in.readLine()) != null) {
                return line;
            }
            else return "something went wrong";
        }
    }
    public String ApiCallurlRecipe(int number,int offset) throws Exception {
        String callurl=baseUrl+urlRecipe+apiKey+"&number="+number+"&offset="+offset;
        return Call(callurl);

    }
    public String ApiCallurlRecipe(String query,int number,int offset) throws Exception {
        String callurl=baseUrl+urlRecipe+apiKey+"&query="+query+"&number="+number+"&offset="+offset;
        return Call(callurl);

    }
    public String ApiCallurlInstruction(int id) throws Exception {
        return Call(baseUrl+id+instructionUrl+apiKey);
    }
    public String ApiCallurlinGredients(int id) throws Exception {
        return Call(baseUrl+id+ingredientsbyID+apiKey);
    }
}