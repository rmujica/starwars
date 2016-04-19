package me.rmujica.starwars.di.component;

import javax.inject.Singleton;

import dagger.Component;
import me.rmujica.starwars.view.activity.MainActivity;
import me.rmujica.starwars.di.module.NetModule;

@Singleton
@Component(modules = {NetModule.class})
public interface ApplicationComponent {

    void inject(MainActivity activity);

}
