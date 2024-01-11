    package com.example.weatherapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.weatherapp.Adapters.HourlyAdapters;
import com.example.weatherapp.Domains.Hourly;
import com.example.weatherapp.InterfaceApi;
import com.example.weatherapp.R;
import com.example.weatherapp.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class MainActivity extends AppCompatActivity {

        ActivityMainBinding binding;
        private RecyclerView.Adapter adapterHourly;
        private RecyclerView recyclerView;
        LottieAnimationView lottie;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
             /* lottie=findViewById(R.id.lottie);

           new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    lottie.playAnimation();

                }

            },8000);*/
            initRecyclerview();
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM YYYY");
            String currentdate = format.format(new Date());
            binding.date.setText(currentdate);
            fetchWeather("Nairobi");
            binding.searchbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (TextUtils.isEmpty(binding.citysearch.getText().toString())) {
                        binding.citysearch.setError("Please Enter City");
                        return;
                    }
                    String CITY_NAME = binding.citysearch.getText().toString();
                    fetchWeather(CITY_NAME);
                }
            });


        }

        private void fetchWeather(String cityname) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
            Call<MausamData> call = interfaceApi.getData(cityname, "cec76ae8fa1cb1cb8e45241bfb974a89", "metric");
            call.enqueue(new Callback<MausamData>() {
                @Override
                public void onResponse(Call<MausamData> call, Response<MausamData> response) {
                    if (response.isSuccessful()) {
                        MausamData mausamData = response.body();
                        main to = mausamData.getMain();
                        binding.maintmp.setText(String.valueOf(to.getTemp())+"\u2103");
                        binding.maxtmp.setText(String.valueOf(to.getTemp_max()));
                         binding.mintmp.setText(String.valueOf(to.getTemp_min()));
                        binding.pressure.setText(String.valueOf(to.getPressure()));
                        binding.humidity.setText(String.valueOf(to.getHumidity()));
                        binding.cityname.setText(mausamData.getName());
                        List<weather> description = mausamData.getWeather();
                        for (weather data : description) {
                            binding.description.setText(data.getDescription());
                        }

                    }
                }

                @Override
                public void onFailure(Call<MausamData> call, Throwable t) {

                }
            });
        }


        private void initRecyclerview() {
            ArrayList<Hourly> items = new ArrayList<>();
            items.add(new Hourly("9pm", 28, "baseline_wb_sunny_24"));
            items.add(new Hourly("10pm", 29, "rain"));
            items.add(new Hourly("11pm", 30, "wind"));
            items.add(new Hourly("12pm", 31, "baseline_cloudy_24"));
            items.add(new Hourly("1am", 32, "baseline_thunderstorm_24"));

            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            adapterHourly = new HourlyAdapters(items);
            recyclerView.setAdapter(adapterHourly);


        }
    }