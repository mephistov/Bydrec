package nicolas.bahamon.bydrec.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Item {

    public int id;
    public String type;
    public String date;
    public String state;
    public Team homeTeam;
    public Team awwayTeam;
    public Score score;
    public Venue venue;
    public CompetitionStage competition_stage;

    Item(JSONObject jsonRespons){

        try {
            id = jsonRespons.getInt("id");
            type = jsonRespons.getString("type");
            homeTeam = new Team(jsonRespons.getJSONObject("homeTeam"));
            awwayTeam = new Team(jsonRespons.getJSONObject("awayTeam"));
            date = jsonRespons.getString("date");

            competition_stage = new CompetitionStage(jsonRespons.getJSONObject("competitionStage"));

            state = jsonRespons.getString("state");
            if(jsonRespons.has("score") && !jsonRespons.isNull("score"))
                score = new Score(jsonRespons.getJSONObject("score"));

            venue = new Venue(jsonRespons.getJSONObject("venue"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
