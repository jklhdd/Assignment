package com.daongoclong.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.daongoclong.assignment.adapter.WeatherAdapter;
import com.daongoclong.assignment.manager.APIManager;
import com.daongoclong.assignment.model.Content;
import com.daongoclong.assignment.model.CurrentCondition;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvCurrentCondition, tvCurrentTemp;

    RecyclerView rvListWeather;
    List<Content> listData;
    WeatherAdapter adapter;
    CurrentCondition currentCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCurrentCondition = findViewById(R.id.tvCurrentCondition);
        tvCurrentTemp = findViewById(R.id.tvCurrentTemp);

        getCurrentData();
        getListData();

        listData = new ArrayList<>();
        adapter = new WeatherAdapter(MainActivity.this, listData);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        rvListWeather = findViewById(R.id.rvListWeather);
        rvListWeather.setLayoutManager(layoutManager);
        rvListWeather.setAdapter(adapter);
    }

    private void getListData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);

        service.getHoursCondition().enqueue(new Callback<List<Content>>() {
            @Override
            public void onResponse(Call<List<Content>> call, Response<List<Content>> response) {
                if (response.body() != null){
                    listData = response.body();
                    adapter.reloadData(listData);
                }
            }

            @Override
            public void onFailure(Call<List<Content>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getCurrentData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);

        service.getCurrentCondition().enqueue(new Callback<List<CurrentCondition>>() {
            @Override
            public void onResponse(Call<List<CurrentCondition>> call, Response<List<CurrentCondition>> response) {
                if (response.body() != null){
                    currentCondition = response.body().get(0);
                    tvCurrentCondition.setText(currentCondition.getWeatherText());
                    tvCurrentTemp.setText(currentCondition.getTemperature().getMetric().getValue()+"°");
                }
            }

            @Override
            public void onFailure(Call<List<CurrentCondition>> call, Throwable t) {
                Log.d("ERROR RETROFIT", "ERROR", t);
            }
        });
    }

}