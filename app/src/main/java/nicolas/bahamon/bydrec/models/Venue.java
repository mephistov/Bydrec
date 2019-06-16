package nicolas.bahamon.bydrec.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Venue {

    public int id;
    public String name;

    Venue(JSONObject jsonObject){
        try {
            id = jsonObject.getInt("id");
            name = jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
