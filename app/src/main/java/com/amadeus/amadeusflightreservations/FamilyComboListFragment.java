package com.amadeus.amadeusflightreservations;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.amadeus.amadeusflightreservations.models.AmadeusApiModel;
import com.amadeus.amadeusflightreservations.models.FlightsDTO;
import com.amadeus.amadeusflightreservations.models.dtos.FamilyCombosDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amadeus on 16/1/18.
 */

public class FamilyComboListFragment extends Fragment {
    ListView listView;

    public FamilyComboListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.family_combo_list, container, false);
        listView = (ListView)view.findViewById(R.id.familycombo_list);

        return view;
    }


    public void setArguments(String... params) {
        AmadeusApiModel model = new AmadeusApiModel();
        Callback<FamilyCombosDto> callback = new Callback<FamilyCombosDto>() {
            @Override
            public void onResponse(Call<FamilyCombosDto> call, Response<FamilyCombosDto> response) {

                FamilyCombosDto flights = response.body();
                Log.d("familyCombo", "onResponse: :)" );

                if(response.isSuccessful()) {
                    FamilyComboAdapter adapter = new FamilyComboAdapter(getContext(), flights.getData());
                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<FamilyCombosDto> call, Throwable t) {
                Toast.makeText(getContext(), "error :(", Toast.LENGTH_SHORT).show();

            }

        };

        model.getFamilyCombo(callback, params[0], params[1], params[2], params[3], params[4]);

    }
}

