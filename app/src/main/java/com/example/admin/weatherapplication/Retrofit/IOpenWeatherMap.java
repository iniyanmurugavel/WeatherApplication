package com.example.admin.weatherapplication.Retrofit;


import com.example.admin.weatherapplication.Pojo.Weather.WeatherResult;
import com.example.admin.weatherapplication.Pojo.WeatherForecast.WeatherForecastResult;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IOpenWeatherMap {

    @GET("weather?")
    Observable<WeatherResult> getWeatherByLatLng
            (@Query("lat") double lat, @Query("lon") double lng,
             @Query("appid") String appid, @Query("units") String unit);



    @GET("forecast?")
    Observable<WeatherForecastResult> getWeatherForecastResultLatLng
            (@Query("lat") double lat, @Query("lon") double lng,
             @Query("appid") String appid, @Query("units") String unit);
}
 