package nicolas.bahamon.bydrec.models;

import org.json.JSONException;
import org.json.JSONObject;

public class CompetitionStage {


    public String stage;
    public Compitition competition;

    CompetitionStage(JSONObject jsonObject){
        competition = new Compitition();
        try {
            competition.id = jsonObject.getJSONObject("competition").getInt("id");
            competition.name = jsonObject.getJSONObject("competition").getString("name");
            if(jsonObject.has("stage"))
                stage = jsonObject.getString("stage");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class Compitition {
      public int id;
      public String name;

    }
}


