import java.util.Scanner;
import org.json.simple.*;
public class allo {
    public static void main(String[] args) {
        JsonReader jsonReader=new JsonReader("findByIngredients.json");
        String data =jsonReader.getJsonString();
        JSONArray jsonArray =(JSONArray) JSONValue.parse(data);
        System.out.println("choose recipe :");
        for (int index =0 ;index<jsonArray.size();index++)
        {
            System.out.print((index+1)+" ");
            System.out.println(((JSONObject)jsonArray.get(index)).get("title"));
        }
        int response= utils.utilsme.response(jsonArray.size());
        JSONObject result =(JSONObject) jsonArray.get(response-1);
        JSONArray array= (JSONArray) result.get("missedIngredients");
        System.out.println("ingredients");
        for (int index=0;index<array.size();index++)
        {
            JSONObject object =(JSONObject) array.get(index);
            String sout1 =object.get("original").toString();
            System.out.println(sout1);
        }
    }
}
