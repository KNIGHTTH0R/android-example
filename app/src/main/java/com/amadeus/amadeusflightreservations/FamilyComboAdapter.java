package com.amadeus.amadeusflightreservations;

/**
 * Created by amadeus on 16/1/18.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amadeus.amadeusflightreservations.models.dtos.Data;
import com.amadeus.amadeusflightreservations.models.dtos.DataCombos;
import com.amadeus.amadeusflightreservations.models.dtos.FamilyCombosDto;
import com.amadeus.amadeusflightreservations.models.dtos.OfferItems;
import com.amadeus.amadeusflightreservations.models.dtos.Segments;
import com.amadeus.amadeusflightreservations.models.dtos.Services;


public class FamilyComboAdapter extends ArrayAdapter<DataCombos> {

    private Context context;
    private DataCombos[] values;

    public FamilyComboAdapter(Context context, DataCombos[] values) {
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
            row = inflater.inflate(R.layout.list_item_family, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);
        TextView textViewPrice = (TextView) row.findViewById(R.id.list_item_pagination_Price);
        TextView textViewDest = (TextView) row.findViewById(R.id.list_item_pagination_Destination);

        DataCombos item = values[position];
        //GET LOWEST PRICE
        String lowestPrice = null;
        for (OfferItems itemOffert : item.getOfferItems()) {
            if (lowestPrice == null ||
                    Integer.getInteger(itemOffert.getPrice().getTotal()) < Integer.getInteger(lowestPrice)) {
                lowestPrice = itemOffert.getPrice().getTotal();
            }
        }

        row.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Flight Details");

                DataCombos dcombos = (DataCombos) view.getTag();
                String message = null;


                for (OfferItems itemOffert : dcombos.getOfferItems()) {
                        message = "Combo costs " + itemOffert.getPrice().getTotal() +  " , follows Aircraft are available to be selected:" ;
                        for (Services itemService:  itemOffert.getServices()) {
                            for (Segments itemSegment : itemService.getSegments()) {
                                message += itemSegment.getFlightSegment().getAircraft().getCode() + ",";
                                //avoiding iterate another array to get descriptive aircraft code from dictionaries
                            }
                        }
                }

                alertDialogBuilder
                        .setMessage(message)
                        .setCancelable(true)
                        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }

        });
        textViewPrice.setText("ID" + item.getId());
        textView.setText("   Offerts available:" + item.getOfferItems().length);
        textViewDest.setText("   Lowest Price available: $" + lowestPrice);
        row.setTag(item);

        return row;
    }
}
