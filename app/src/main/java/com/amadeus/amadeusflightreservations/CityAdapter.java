package com.amadeus.amadeusflightreservations;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amadeus.amadeusflightreservations.models.dtos.Data;
import com.amadeus.amadeusflightreservations.models.dtos.DataSearchDto;
import com.amadeus.amadeusflightreservations.models.dtos.LocationDto;


public class CityAdapter extends ArrayAdapter<DataSearchDto> {

    private Context context;
    private DataSearchDto[] values;

    public CityAdapter(Context context, DataSearchDto[] values) {
        super(context, R.layout.list_item, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);

        DataSearchDto item = values[position];
        String message = item.getDetailedName();
        textView.setText(message);

        return row;
    }
}
