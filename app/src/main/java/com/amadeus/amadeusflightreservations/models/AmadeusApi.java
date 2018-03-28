package com.amadeus.amadeusflightreservations.models;

import android.location.Location;

import com.amadeus.amadeusflightreservations.models.dtos.FamilyCombosDto;
import com.amadeus.amadeusflightreservations.models.dtos.LocationDto;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


public interface AmadeusApi {

    @FormUrlEncoded
    @POST("security/oauth2/token")
    Call<ResponseTokenDTO> getToken(@Field("client_id") String clientId,
                                    @Field("client_secret") String clientSecret,
                                    @Field("grant_type") String grandType);

    @GET("shopping/flight-destinations")
    Call<FlightsDTO> getFlights(@Header("Authorization") String authorization,
                                @Query("origin") String origin,
                                @Query("departureDate") String departureDate,
                                @Query("oneWay") String oneWay,
                                @Query("nonStop") String nonStop,
                                @Query("maxPrice") String maxPrice,
                                @Query("currency") String currency);


    @GET("reference-data/locations")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Call<LocationDto> getCitiesByKeyword(
            @Header("Authorization") String authorization,
            @Query("subType") String subtype,
            @Query("keyword") String keyword,
            @Query(encoded = true, value = "page%5Blimit%5D") int page,
            @Query(encoded = true, value = "page%5Boffset%5D") int offset
    );

    @GET("shopping/flight-offers")
    Call<FamilyCombosDto> getFamilyCombo(@Header("Authorization") String authorization,
                                         @Query("origin") String origin,
                                         @Query("destination") String destination,
                                         @Query("departureDate") String departureDate,
                                         @Query("adults") String adults,
                                         @Query("children") String children,
                                         @Query("travelClass") String travelClass,
                                         @Query("nonStop") String nonStop);

}


