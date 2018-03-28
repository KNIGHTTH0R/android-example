package com.amadeus.amadeusflightreservations;

import android.app.SearchManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.amadeus.amadeusflightreservations.models.AmadeusApiModel;
import com.amadeus.amadeusflightreservations.models.FlightsDTO;
import com.amadeus.amadeusflightreservations.models.dtos.LocationDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchCitiesFragment extends android.support.v4.app.Fragment {
    ListView listView;
    Button btnPrevious, btnNext;
    ProgressBar spinner;
    int currentPage = 0;
    String currentSearch = "";

    public SearchCitiesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_city, container, false);
        listView = (ListView) view.findViewById(R.id.searchcity_pagination_list);
        SearchView searchView = view.findViewById(R.id.searchbar_city);
        btnNext = view.findViewById(R.id.searccity_btn_next);
        btnPrevious = view.findViewById(R.id.searccity_btn_previous);
        spinner = view.findViewById(R.id.search_spinner);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage++;
                setArguments();
                spinner.setVisibility(View.VISIBLE);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage = currentPage <= 0 ? 0 : currentPage - 1;
                setArguments();
                spinner.setVisibility(View.VISIBLE);

            }
        });
        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(getActivity().getBaseContext().SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                currentSearch = query;
                setArguments();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                return true;
            }
        });

        return view;
    }


    private void setArguments() {
        AmadeusApiModel model = new AmadeusApiModel();
        Callback<LocationDto> callback = new Callback<LocationDto>() {
            @Override
            public void onResponse(Call<LocationDto> call, Response<LocationDto> response) {
                if(response.isSuccessful()) {

                    LocationDto flights = response.body();

                    CityAdapter adapter = new CityAdapter(getContext(), flights.getData());
                    listView.setAdapter(adapter);
                }
                spinner.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getContext(), "error :(", Toast.LENGTH_SHORT).show();

            }

        };

        model.getCitiesByKeyword(callback, currentSearch, currentPage);

    }


}
