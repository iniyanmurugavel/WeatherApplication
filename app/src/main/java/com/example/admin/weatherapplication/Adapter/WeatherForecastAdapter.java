package com.example.admin.weatherapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.weatherapplication.Common.Common;
import com.example.admin.weatherapplication.Pojo.WeatherForecast.WeatherForecastResult;
import com.example.admin.weatherapplication.R;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastViewHolder> {
    private Context context;
    private WeatherForecastResult weatherForecastResult;

    public WeatherForecastAdapter(Context context, WeatherForecastResult weatherForecastResult) {
        this.context = context;
        this.weatherForecastResult = weatherForecastResult;
    }

    @NonNull
    @Override
    public WeatherForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather_forecast, parent, false);

        return new WeatherForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherForecastViewHolder holder, int position) {
        Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/")
                .append(weatherForecastResult.list.get(position).weather.get(0).getIcon()).append(".png").toString())
                .into(holder.img_weather);
        holder.txt_date.setText(new StringBuilder(Common.convertUnixToDate(weatherForecastResult.list.get(position).dt)));

        holder.txt_description.setText(new StringBuilder(weatherForecastResult.list.get(position).weather.get(0).getDescription()).toString().toUpperCase());

        holder.txt_temperature.setText(new StringBuilder(String.valueOf(weatherForecastResult.list.get(position).main.getTemp()))
                .append("°C").toString());


    }

    @Override
    public int getItemCount() {
        return weatherForecastResult.list.size();
    }
}
