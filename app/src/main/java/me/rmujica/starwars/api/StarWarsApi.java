package me.rmujica.starwars.api;

import me.rmujica.starwars.model.Person;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StarWarsApi {

    @GET("people/{id}")
    Call<Person> getPerson(@Path("id") Integer personId);

}
