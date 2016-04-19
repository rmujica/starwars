package me.rmujica.starwars.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import me.rmujica.starwars.BR;
import me.rmujica.starwars.api.StarWarsApi;
import me.rmujica.starwars.model.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends BaseObservable {

    private StarWarsApi api;

    private Integer id;
    private String name;
    private String height;
    private String weight;

    public MainViewModel(StarWarsApi api) {
        this.api = api;
    }

    public TextWatcher idWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.toString().isEmpty()) setId(null);
            setId(Integer.parseInt(editable.toString()));
            Log.d("viewmodel", "set id:" + editable.toString());
        }
    };

    public void submit(View button) {
        Log.d("viewmodel", "sending info");
        if (id == null) return;
        api.getPerson(id).enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                Person p = response.body();
                setName(p.name);
                setHeight(p.height);
                setWeight(p.mass);
                Log.d("viewmodel", "got response");
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Log.d("viewmodel", "failure: " + t.toString());
            }
        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
        notifyPropertyChanged(BR.height);
    }

    @Bindable
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }
}
