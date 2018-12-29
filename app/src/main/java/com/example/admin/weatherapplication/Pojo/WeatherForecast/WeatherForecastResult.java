package com.example.admin.weatherapplication.Pojo.WeatherForecast;


import java.util.List;

public class WeatherForecastResult {

    private String cod;
    public double message ;
    private int cnt ;
    public List<ListForeCast> list;
    public  City city ;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<ListForeCast> getList() {
        return list;
    }

    public void setList(List<ListForeCast> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
