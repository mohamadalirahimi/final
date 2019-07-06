package ir.mohamadalirahimi.bookreader.Classes;


import org.json.JSONException;
import org.json.JSONObject;

public class book {

    public String name,writer,categoryName,picture;
    public Integer  id, pageCount, status, printYear,categoryId;

    public book(JSONObject jso) throws JSONException {
        this.name=jso.getString("name");
        this.picture = "http://192.168.43.120/server/public/logos/" + jso.getString("picture");
        this.id = jso.getInt("id");
        this.pageCount = jso.getInt("pagecount");
        this.status = jso.getInt("status");;
        this.writer = jso.getString("writer");
        this.categoryId = jso.getInt("category_id");
        this.categoryName = jso.getJSONObject("category").getString("title");
        this.printYear = jso.getInt("printyear");
    }

}
