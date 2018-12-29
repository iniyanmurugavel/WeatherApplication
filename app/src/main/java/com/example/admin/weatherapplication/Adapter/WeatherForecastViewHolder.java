package com.example.admin.weatherapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.weatherapplication.R;

public class WeatherForecastViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_date, txt_description, txt_temperature;
    public ImageView img_weather;


    WeatherForecastViewHolder(View itemView) {
        super(itemView);

        img_weather = (ImageView) itemView.findViewById(R.id.img_weather);
        txt_date = (TextView) itemView.findViewById(R.id.txt_date);
        txt_description = (TextView) itemView.findViewById(R.id.txt_description);
        txt_temperature = (TextView) itemView.findViewById(R.id.txt_temperature);
    }
}
