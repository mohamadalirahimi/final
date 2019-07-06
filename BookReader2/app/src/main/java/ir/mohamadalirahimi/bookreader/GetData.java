package ir.mohamadalirahimi.bookreader;


import java.util.List;

import ir.mohamadalirahimi.bookreader.Classes.book;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    String BaseUrl = "http://127.0.0.1:8000/api/";

    @GET("book.json")
    Call<List<book>> getBook();
}
