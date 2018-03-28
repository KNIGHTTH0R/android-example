package com.amadeus.amadeusflightreservations.models.dtos;

import com.amadeus.amadeusflightreservations.models.dtos.Aircraft;

public class Dictionaries
{

    private Aircraft aircraft;

    public void setAircraft (Aircraft aircraft)
    {
        this.aircraft = aircraft;
    }

    @Override
    public String toString()
    {
        return "[currencies =  aircraft = "+aircraft+"]";
    }
}
