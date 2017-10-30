package co.japo.networkingexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by japodeveloper on 10/28/17.
 */

public interface MyRemoteService {

    @GET("example/items.json")
    Call<List<Item>> getItems();
}
