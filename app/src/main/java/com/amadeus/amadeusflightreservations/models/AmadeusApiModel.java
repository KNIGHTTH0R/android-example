package com.amadeus.amadeusflightreservations.models;

import android.location.Location;
import android.util.Log;

import com.amadeus.amadeusflightreservations.models.dtos.FamilyCombosDto;
import com.amadeus.amadeusflightreservations.models.dtos.LocationDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AmadeusApiModel {
    public static final String BASE_URL = "https://test.api.amadeus.com/v1/";
    Retrofit retrofit;
    AmadeusApi client;

    public AmadeusApiModel() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        client = retrofit.create(AmadeusApi.class);

    }

    public void getList(final Callback<FlightsDTO> callbackSuccess, final String budget, final String dates, final String origin) {
        getToken(new Callback<ResponseTokenDTO>() {
            @Override
            public void onResponse(Call<ResponseTokenDTO> tokenCall, Response<ResponseTokenDTO> responseToken) {
                ResponseTokenDTO token = responseToken.body();
                String tokenString = "Bearer " + token.getAccess_token();

                Call<FlightsDTO> getFligth = client.getFlights(tokenString,origin, dates, "true", "false", budget, "USD");
                getFligth.enqueue(callbackSuccess);

            }

            @Override
            public void onFailure(Call<ResponseTokenDTO> call, Throwable t) {
                Log.d("Model", "onResponse: :(" );

            }
        });

    }

    public void getCitiesByKeyword(final Callback<LocationDto> callbackSuccess, final String searchParam, final int offset) {
        getToken(new Callback<ResponseTokenDTO>() {
            @Override
            public void onResponse(Call<ResponseTokenDTO> tokenCall, Response<ResponseTokenDTO> responseToken) {

                ResponseTokenDTO token = responseToken.body();
                String tokenString = "Bearer " + token.getAccess_token();

                Call<LocationDto> getCities = client.getCitiesByKeyword(tokenString,"AIRPORT,CITY", searchParam, 5 ,offset );
                getCities.enqueue(callbackSuccess);
            }

            @Override
            public void onFailure(Call<ResponseTokenDTO> call, Throwable t) {
                Log.d("Model", "onResponse: :(" );

            }
        });

    }

    public void getFamilyCombo(final Callback<FamilyCombosDto> callbackSuccess, final String origin, final String destination, final String date, final String adults, final String childrens) {
        getToken(new Callback<ResponseTokenDTO>() {
            @Override
            public void onResponse(Call<ResponseTokenDTO> tokenCall, Response<ResponseTokenDTO> responseToken) {
                ResponseTokenDTO token = responseToken.body();
                String tokenString = "Bearer " + token.getAccess_token();

                Call<FamilyCombosDto> familyCombo = client.getFamilyCombo(tokenString , origin, destination, date, adults, childrens, "BUSINESS","true");
                familyCombo.enqueue(callbackSuccess);
            }

            @Override
            public void onFailure(Call<ResponseTokenDTO> call, Throwable t) {
                Log.d("Model", "onResponse: :(" );
            }
        });

    }

    public void getToken(final Callback callbackSuccess) {
        /*
         * client id and client secret go here 
         */
        Call<ResponseTokenDTO> tokenCall = client.getToken("", "", "client_credentials");

        tokenCall.enqueue(callbackSuccess);
    }

}
