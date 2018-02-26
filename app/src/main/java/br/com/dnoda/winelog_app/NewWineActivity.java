package br.com.dnoda.winelog_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.dnoda.winelog_app.controller.WineAPI;
import br.com.dnoda.winelog_app.model.Wine;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.facebook.stetho.okhttp3.StethoInterceptor;

public class NewWineActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_wine);

        etName = findViewById(R.id.etName);
        etReview = findViewById(R.id.etReview);
    }

    public void save(View view){
        WineAPI wineApi = getRetrofit().create(WineAPI.class);

        Wine wine = new Wine();
        wine.setName(etName.getText().toString());
        wine.setReview(etReview.getText().toString());

        wineApi.save(wine)
                .enqueue(new Callback<Void>(){
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        etName.setText("");
                        etReview.setText("");

                        final boolean b = etName.requestFocus();
                        Toast.makeText(NewWineActivity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(NewWineActivity.this, "Error!", Toast.LENGTH_SHORT).show();
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