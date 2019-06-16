package nicolas.bahamon.bydrec.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Team {

    public int id;
    public String name;
    public String shortName;
    public String abbr;
    public String alias;

    Team(JSONObject jsonObject){
        try {
            id = jsonObject.getInt("id");
            name = jsonObject.getString("name");
            shortName = jsonObject.getString("shortName");
            abbr = jsonObject.getString("abbr");
            alias = jsonObject.getString("alias");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
