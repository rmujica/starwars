package me.rmujica.starwars.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.rmujica.starwars.api.StarWarsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public StarWarsApi providesApi(Retrofit retrofit) {
        return retrofit.create(StarWarsApi.class);
    }

}
