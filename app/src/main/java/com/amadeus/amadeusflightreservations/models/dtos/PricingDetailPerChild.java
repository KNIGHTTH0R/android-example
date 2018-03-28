package com.amadeus.amadeusflightreservations.models.dtos;

public class PricingDetailPerChild
{
    private String travelClass;

    private String fareBasis;

    private String fareClass;

    private String availability;

    public String getTravelClass ()
    {
        return travelClass;
    }

    public void setTravelClass (String travelClass)
    {
        this.travelClass = travelClass;
    }

    public String getFareBasis ()
    {
        return fareBasis;
    }

    public void setFareBasis (String fareBasis)
    {
        this.fareBasis = fareBasis;
    }

    public String getFareClass ()
    {
        return fareClass;
    }

    public void setFareClass (String fareClass)
    {
        this.fareClass = fareClass;
    }

    public String getAvailability ()
    {
        return availability;
    }

    public void setAvailability (String availability)
    {
        this.availability = availability;
    }

    @Override
    public String toString()
    {
        return "[travelClass = "+travelClass+", fareBasis = "+fareBasis+", fareClass = "+fareClass+", availability = "+availability+"]";
    }
}
