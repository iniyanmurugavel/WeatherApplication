package com.example.admin.weatherapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.weatherapplication.Adapter.WeatherForecastAdapter;
import com.example.admin.weatherapplication.Common.Common;
import com.example.admin.weatherapplication.Pojo.WeatherForecast.WeatherForecastResult;
import com.example.admin.weatherapplication.Retrofit.IOpenWeatherMap;
import com.example.admin.weatherapplication.Retrofit.RetrofitClient;
import com.squareup.picasso.Picasso;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {


    TextView txt_city_name, txt_geo_code;

    ProgressBar loading;
    public static  ForecastFragment instance;
    CompositeDisposable compositeDisposable;
    IOpenWeatherMap mService;
    RecyclerView recycler_forecast;

    public static ForecastFragment getInstance() {


        if (instance == null) instance = new ForecastFragment();
        return instance;
    }

    public  ForecastFragment() {

        compositeDisposable = new CompositeDisposable();
        Retrofit retrofit = RetrofitClient.getInstance();
        mService = retrofit.create(IOpenWeatherMap.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View itemView = inflater.inflate(R.layout.fragment_forecast, container, false);


        txt_city_name = (TextView) itemView.findViewById(R.id.txt_city_name);

        txt_geo_code = (TextView) itemView.findViewById(R.id.txt_geocoords);

        recycler_forecast = (RecyclerView) itemView.findViewById(R.id.recycler_forecast);
        recycler_forecast.setHasFixedSize(true);
        recycler_forecast.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        getForeCastInformation();
        return itemView;
    }

    private void getForeCastInformation() {

//        compositeDisposable.add(mService.
//                getWeatherForecastResultLatLng(Common.current_location.getLatitude(),
//                        Common.current_location.getLongitude(), Common.APP_ID, "metric")
//                .subscribeOn(Schedulers.io())


                compositeDisposable.add(mService.
                        getWeatherForecastResultLatLng(12.934968,
                                79.146881, Common.APP_ID, "metric")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherForecastResult>() {
                    @Override
                    public void accept(WeatherForecastResult weatherResult) throws Exception {

                        displayForeCastWeather(weatherResult);


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getActivity(), "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("trd", throwable.getMessage());

                    }
                })
        );


    }

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    private void displayForeCastWeather(WeatherForecastResult weatherResult) {

        txt_city_name.setText(weatherResult.city.name);
        txt_geo_code.setText(new StringBuilder("").append(weatherResult.city.getCoord().toString()
        ).append("").toString());


        WeatherForecastAdapter adapter = new WeatherForecastAdapter(getContext(), weatherResult);
        recycler_forecast.setAdapter(adapter);
    }


}
