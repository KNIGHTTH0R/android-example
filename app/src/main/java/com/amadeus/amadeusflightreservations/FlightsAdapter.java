package com.amadeus.amadeusflightreservations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amadeus.amadeusflightreservations.models.dtos.Data;

import java.util.List;


public class FlightsAdapter extends ArrayAdapter<Data> {

    private Context context;
    private Data[] values;

    public FlightsAdapter(Context context, Data[] values) {
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
        TextView textViewPrice = (TextView) row.findViewById(R.id.list_item_pagination_Price);
        TextView textViewDest = (TextView) row.findViewById(R.id.list_item_pagination_Destination);

        Data item = values[position];
        String message = item.getDepartureDate();
        textViewPrice.setText(item.getPrice().getTotal());
        textView.setText(item.getDestination());
        textViewDest.setText(message);

        return row;
    }
}
