package com.amadeus.amadeusflightreservations.models.dtos;

public class Currencies
{
    private String EUR;

    public String getEUR ()
    {
        return EUR;
    }

    public void setEUR (String EUR)
    {
        this.EUR = EUR;
    }

    @Override
    public String toString()
    {
        return "[EUR = "+EUR+"]";
    }
}
