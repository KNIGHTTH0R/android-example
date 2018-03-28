package com.amadeus.amadeusflightreservations.models.dtos;

public class Links
{
    private String flightOffers;
    private String flightDates;
    
    public String getFlightOffers ()
    {
        return flightOffers;
    }

    public void setFlightOffers (String flightOffers)
    {
        this.flightOffers = flightOffers;
    }

    public String getFlightDates ()
    {
        return flightDates;
    }

    public void setFlightDates (String flightDates)
    {
        this.flightDates = flightDates;
    }

    @Override
    public String toString()
    {
        return "[flightOffers = "+flightOffers+", flightDates = "+flightDates+"]";
    }
}
