package nicolas.bahamon.bydrec.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Score {

    public int home;
    public int away;
    public String winner;

    Score(JSONObject jsonObject){

        try {
            home = jsonObject.getInt("home");
            away = jsonObject.getInt("away");
            winner = jsonObject.getString("winner");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
