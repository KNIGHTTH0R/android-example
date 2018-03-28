package com.amadeus.amadeusflightreservations.models.dtos;

public class FlightSegment
{
    private String duration;
    private Aircraft aircraft;
    private Arrival arrival;
    private Departure departure;
    private String number;
    private String carrierCode;

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public Aircraft getAircraft ()
    {
        return aircraft;
    }

    public void setAircraft (Aircraft aircraft)
    {
        this.aircraft = aircraft;
    }

    public Arrival getArrival ()
    {
        return arrival;
    }

    public void setArrival (Arrival arrival)
    {
        this.arrival = arrival;
    }

    public Departure getDeparture ()
    {
        return departure;
    }

    public void setDeparture (Departure departure)
    {
        this.departure = departure;
    }

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public String getCarrierCode ()
    {
        return carrierCode;
    }

    public void setCarrierCode (String carrierCode)
    {
        this.carrierCode = carrierCode;
    }

    @Override
    public String toString()
    {
        return "[duration = "+duration+", operating = , aircraft = "+aircraft+", arrival = "+arrival+", departure = "+departure+", number = "+number+", carrierCode = "+carrierCode+"]";
    }
}
