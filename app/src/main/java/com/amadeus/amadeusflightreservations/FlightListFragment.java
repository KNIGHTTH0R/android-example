package com.amadeus.amadeusflightreservations;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.amadeus.amadeusflightreservations.models.AmadeusApiModel;
import com.amadeus.amadeusflightreservations.models.FlightsDTO;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlightListFragment extends Fragment {
    ListView listView;

    public FlightListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flights_list_adapters, container, false);
        listView = (ListView)view.findViewById(R.id.pagination_list);

        return view;
    }


    public void setArguments(String... params) {
        AmadeusApiModel model = new AmadeusApiModel();
        Callback<FlightsDTO> callback = new Callback<FlightsDTO>() {
            @Override
            public void onResponse(Call<FlightsDTO> call, Response<FlightsDTO> response) {

                FlightsDTO flights = response.body();
                if(response.isSuccessful()) {
                    FlightsAdapter adapter = new FlightsAdapter(getContext(), flights.getData());
                    listView.setAdapter(adapter);

                } else {
                    Gson gson = new Gson();

                    String obj = null;
                    try {
                        obj = response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JsonElement je = new JsonParser().parse(obj);
                    JsonObject jsonObject = je.getAsJsonObject();

                    JsonArray jsonArray = jsonObject.get("errors").getAsJsonArray();
                    JsonObject errorJson = jsonArray.get(0).getAsJsonObject();
                    String details = errorJson.get("detail").getAsString();
                    Toast.makeText(getContext(), "error "+ details, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<FlightsDTO> call, Throwable t) {
                Toast.makeText(getContext(), "error :(", Toast.LENGTH_SHORT).show();

            }

        };

        model.getList(callback, params[0], params[1], params[2]);

    }
}

