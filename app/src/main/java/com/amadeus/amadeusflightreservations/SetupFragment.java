package com.amadeus.amadeusflightreservations;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SetupFragment extends Fragment {
    View view;
    Button findBtn;

    public SetupFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.setup_layout, container, false);
        findBtn = view.findViewById(R.id.find_btn);
        findBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View viewss) {
                EditText etAmmount = view.findViewById(R.id.plain_text_ammount);
                EditText etOrigin = view.findViewById(R.id.plain_text_origin);
                EditText etDates = view.findViewById(R.id.plain_text_dates);
                ((AmadeusActivity) getActivity()).replaceFragments(FlightListFragment.class,
                        etAmmount.getText().toString(),
                        etDates.getText().toString(),
                        etOrigin.getText().toString()
                        );
            }
        });
        return view;
    }

}

