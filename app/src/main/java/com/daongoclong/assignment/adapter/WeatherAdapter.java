package com.daongoclong.assignment.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daongoclong.assignment.R;
import com.daongoclong.assignment.model.Content;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Content> list;

    public WeatherAdapter(Activity activity, List<Content> list) {
        this.activity = activity;
        this.list = list;
    }

    public void reloadData(List<Content> list){
        this.list = list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_weather, parent, false);
        WeatherHolder weatherHolder = new WeatherHolder(itemView);
        return weatherHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WeatherHolder weatherHolder = (WeatherHolder) holder;
        Content model = list.get(position);
        weatherHolder.tvHour.setText(model.getDateTime());
        weatherHolder.tvTemprate.setText(Float.toString(model.getTemperature().getValue()));
        if (model.getWeatherIcon()<10){
            Glide.with(activity).load("https://developer.accuweather.com/sites/default/files/0"+model.getWeatherIcon()+"-s.png").into(weatherHolder.ivWeatherIcon);
        }
        else Glide.with(activity).load("https://developer.accuweather.com/sites/default/files/"+model.getWeatherIcon()+"-s.png").into(weatherHolder.ivWeatherIcon);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WeatherHolder extends RecyclerView.ViewHolder{
        TextView tvHour, tvTemprate;
        ImageView ivWeatherIcon;

        public WeatherHolder(@NonNull View itemView) {
            super(itemView);
            tvHour = itemView.findViewById(R.id.tvHour);
            tvTemprate = itemView.findViewById(R.id.tvTemprate);
            ivWeatherIcon = itemView.findViewById(R.id.ivWeatherIcon);
        }
    }
}
