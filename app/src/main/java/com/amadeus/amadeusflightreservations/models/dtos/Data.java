package com.amadeus.amadeusflightreservations.models.dtos;

public class Data
{
    private Price price;

    private String departureDate;

    private String origin;

    private Links links;

    private String type;

    private String returnDate;

    private String destination;

    public Price getPrice ()
    {
        return price;
    }

    public void setPrice (Price price)
    {
        this.price = price;
    }

    public String getDepartureDate ()
    {
        return departureDate;
    }

    public void setDepartureDate (String departureDate)
    {
        this.departureDate = departureDate;
    }

    public String getOrigin ()
    {
        return origin;
    }

    public void setOrigin (String origin)
    {
        this.origin = origin;
    }

    public Links getLinks ()
    {
        return links;
    }

    public void setLinks (Links links)
    {
        this.links = links;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getReturnDate ()
    {
        return returnDate;
    }

    public void setReturnDate (String returnDate)
    {
        this.returnDate = returnDate;
    }

    public String getDestination ()
    {
        return destination;
    }

    public void setDestination (String destination)
    {
        this.destination = destination;
    }

    @Override
    public String toString()
    {
        return "[price = "+price+", departureDate = "+departureDate+", origin = "+origin+", links = "+links+", type = "+type+", returnDate = "+returnDate+", destination = "+destination+"]";
    }
}
