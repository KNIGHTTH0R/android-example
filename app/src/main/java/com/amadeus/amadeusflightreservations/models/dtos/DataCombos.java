package com.amadeus.amadeusflightreservations.models.dtos;

public class DataCombos {

    private String id;

    private OfferItems[] offerItems;

    private String type;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public OfferItems[] getOfferItems ()
    {
        return offerItems;
    }

    public void setOfferItems (OfferItems[] offerItems)
    {
        this.offerItems = offerItems;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "[id = "+id+", offerItems = "+offerItems+", type = "+type+"]";
    }
}
