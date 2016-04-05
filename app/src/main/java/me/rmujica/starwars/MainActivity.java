package me.rmujica.starwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import me.rmujica.starwars.api.StarWarsApi;
import me.rmujica.starwars.model.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StarWarsApi api = retrofit.create(StarWarsApi.class);

        for (int i = 1; i < 10; i++) {
            final int finalI = i;
            api.getPerson(i).enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    if (response.isSuccessful()) {
                        Person p = response.body();
                        Log.d("taller", p.name + " " + String.valueOf(finalI));
                    }
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {

                }
            });
        }
    }
}
