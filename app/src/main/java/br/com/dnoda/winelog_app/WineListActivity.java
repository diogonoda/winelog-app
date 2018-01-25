package br.com.dnoda.winelog_app;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.List;

import br.com.dnoda.winelog_app.controller.WineAPI;
import br.com.dnoda.winelog_app.model.Wine;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WineListActivity extends AppCompatActivity {
    ListView listView;

    public List<Wine> getWines(View view){

        WineAPI wineApi = getRetrofit().create(WineAPI.class);

        Wine wine = new Wine();
        wine.setName(etName.getText().toString());
        wine.setReview(etReview.getText().toString());

        wineApi.listWines()
                .enqueue(new Callback<List<Wine>>() {
                    @Override
                    public void onResponse(Call<List<Wine>> call, Response<List<Wine>> response) {
                        response.body();
                    }

                    @Override
                    public void onFailure(Call<List<Wine>> call, Throwable t) {

                    }
                });
    }

    private Retrofit getRetrofit(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        return new Retrofit.Builder()
                .baseUrl("https://dnoda-winelog.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    }
}
