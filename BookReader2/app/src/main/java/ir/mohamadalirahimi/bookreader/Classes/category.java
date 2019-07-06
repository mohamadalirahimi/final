package ir.mohamadalirahimi.bookreader.Classes;


import org.json.JSONException;
import org.json.JSONObject;

public class category {

    public String name;
    public Integer  id;

    public category(JSONObject jso) throws JSONException {
        this.name=jso.getString("title");
        this.id = jso.getInt("id");
    }

}
