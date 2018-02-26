package br.com.dnoda.winelog_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.List;

import br.com.dnoda.winelog_app.adapter.WineAdapter;
import br.com.dnoda.winelog_app.controller.WineAPI;
import br.com.dnoda.winelog_app.controller.WineAPIResponse;
import br.com.dnoda.winelog_app.model.Wine;
import br.com.dnoda.winelog_app.model.WineResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListWineActivity extends AppCompatActivity{

    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WineAPI wineApi = getRetrofit().create(WineAPI.class);

        setContentView(R.layout.activity_wine_list);

        recyclerView = (RecyclerView) findViewById(R.id.wine_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getAll();

//        List<Wine> wines =
//        ListView wineList = (ListView) findViewById(R.id.wineList);
    }

    public void getAll(){
        WineAPIResponse wineAPIResponse = getRetrofit().create(WineAPIResponse.class);

        Call<List<Wine>> call = wineAPIResponse.listWines();

        call.enqueue(new Callback<List<Wine>>() {
            @Override
            public void onResponse(Call<List<Wine>> call, Response<List<Wine>> response) {
                List<Wine> wines = response.body();

                recyclerView.setAdapter(new WineAdapter(wines, R.layout.card_wine, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Wine>> call, Throwable t) {
                Log.i("TAG", t.getMessage());
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
                .client(client)
                .build();
    }

}
