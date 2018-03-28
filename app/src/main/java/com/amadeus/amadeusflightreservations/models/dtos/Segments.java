package com.amadeus.amadeusflightreservations.models.dtos;

public class Segments
{
    private PricingDetailPerChild pricingDetailPerAdult;

    private FlightSegment flightSegment;

    private PricingDetailPerChild pricingDetailPerChild;

    public PricingDetailPerChild getPricingDetailPerAdult ()
    {
        return pricingDetailPerAdult;
    }

    public void setPricingDetailPerAdult (PricingDetailPerChild pricingDetailPerAdult)
    {
        this.pricingDetailPerAdult = pricingDetailPerAdult;
    }

    public FlightSegment getFlightSegment ()
    {
        return flightSegment;
    }

    public void setFlightSegment (FlightSegment flightSegment)
    {
        this.flightSegment = flightSegment;
    }

    public PricingDetailPerChild getPricingDetailPerChild ()
    {
        return pricingDetailPerChild;
    }

    public void setPricingDetailPerChild (PricingDetailPerChild pricingDetailPerChild)
    {
        this.pricingDetailPerChild = pricingDetailPerChild;
    }

    @Override
    public String toString()
    {
        return "[pricingDetailPerAdult = "+pricingDetailPerAdult+", flightSegment = "+flightSegment+", pricingDetailPerChild = "+pricingDetailPerChild+"]";
    }
}
