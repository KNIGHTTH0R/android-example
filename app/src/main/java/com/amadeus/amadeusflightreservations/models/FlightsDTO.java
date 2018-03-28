package com.amadeus.amadeusflightreservations.models;

import com.amadeus.amadeusflightreservations.models.dtos.Data;

public class FlightsDTO
{
   // private Dictionaries dictionaries;

    private Data[] data;

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "[dictionaries = , data = "+data+", meta =]";
    }
}
