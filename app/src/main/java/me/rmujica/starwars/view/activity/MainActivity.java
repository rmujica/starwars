package me.rmujica.starwars.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import me.rmujica.starwars.R;
import me.rmujica.starwars.StarWarsApplication;
import me.rmujica.starwars.api.StarWarsApi;
import me.rmujica.starwars.databinding.ActivityMainBinding;
import me.rmujica.starwars.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Inject
    StarWarsApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ((StarWarsApplication) getApplication()).getAppComponent().inject(this);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new MainViewModel(api));
    }
}
