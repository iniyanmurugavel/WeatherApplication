package com.example.admin.weatherapplication.Pojo.WeatherForecast;

import com.example.admin.weatherapplication.Pojo.Weather.Weather;

import java.util.List;

public  class ListForeCast {

    public int dt ;
    public MainForeCast main ;
    public List<WeatherForecast> weather;

    private CloudsForeCast clouds ;
    private WindForeCast wind ;
    private RainForeCast rain ;
    private SysForeCast sys ;
    private String dt_txt ;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public MainForeCast getMain() {
        return main;
    }

    public void setMain(MainForeCast main) {
        this.main = main;
    }

    public List<WeatherForecast> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherForecast> weather) {
        this.weather = weather;
    }

    public CloudsForeCast getClouds() {
        return clouds;
    }

    public void setClouds(CloudsForeCast clouds) {
        this.clouds = clouds;
    }

    public WindForeCast getWind() {
        return wind;
    }

    public void setWind(WindForeCast wind) {
        this.wind = wind;
    }

    public RainForeCast getRain() {
        return rain;
    }

    public void setRain(RainForeCast rain) {
        this.rain = rain;
    }

    public SysForeCast getSys() {
        return sys;
    }

    public void setSys(SysForeCast sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
