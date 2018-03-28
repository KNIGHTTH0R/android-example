package com.amadeus.amadeusflightreservations.models.dtos;

public class OfferItems
{
    private Services[] services;

    private Price price;

    private PricePerPerson pricePerPerson;

    private PricePerPerson pricePerAdult;

    public Services[] getServices ()
    {
        return services;
    }

    public void setServices (Services[] services)
    {
        this.services = services;
    }

    public Price getPrice ()
    {
        return price;
    }

    public void setPrice (Price price)
    {
        this.price = price;
    }

    public PricePerPerson getPricePerPerson()
    {
        return pricePerPerson;
    }

    public void setPricePerPerson(PricePerPerson pricePerPerson)
    {
        this.pricePerPerson = pricePerPerson;
    }

    public PricePerPerson getPricePerAdult ()
    {
        return pricePerAdult;
    }

    public void setPricePerAdult (PricePerPerson pricePerAdult)
    {
        this.pricePerAdult = pricePerAdult;
    }

    @Override
    public String toString()
    {
        return "[services = "+services+", price = "+price+", pricePerPerson = "+ pricePerPerson +", pricePerAdult = "+pricePerAdult+"]";
    }
}
