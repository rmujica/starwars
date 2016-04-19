package me.rmujica.starwars;

import android.app.Application;

import me.rmujica.starwars.di.component.ApplicationComponent;
import me.rmujica.starwars.di.component.DaggerApplicationComponent;
import me.rmujica.starwars.di.module.NetModule;

public class StarWarsApplication extends Application {

    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerApplicationComponent.builder()
                .netModule(new NetModule())
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

}
