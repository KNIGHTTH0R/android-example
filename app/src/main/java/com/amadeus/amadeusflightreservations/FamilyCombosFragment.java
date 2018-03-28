package com.amadeus.amadeusflightreservations;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FamilyCombosFragment extends android.support.v4.app.Fragment {
    View view;
    Button findBtn;

    public FamilyCombosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.family_combo_layout, container, false);
        findBtn = view.findViewById(R.id.find_btn);
        findBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View views) {
                EditText etOrigin = view.findViewById(R.id.familycombo_origin);
                EditText etDestination = view.findViewById(R.id.familycombo_destination);
                EditText etDates = view.findViewById(R.id.familycombo_dates);
                EditText etAdults = view.findViewById(R.id.familycombo_adults);
                EditText etChildren = view.findViewById(R.id.familycombo_children);
                ((AmadeusActivity) getActivity()).replaceFragments(FamilyComboListFragment.class,
                        etOrigin.getText().toString(),
                        etDestination.getText().toString(),
                        etDates.getText().toString(),
                        etAdults.getText().toString(),
                        etChildren.getText().toString()
                );

            }
        });
        return view;
    }


}
