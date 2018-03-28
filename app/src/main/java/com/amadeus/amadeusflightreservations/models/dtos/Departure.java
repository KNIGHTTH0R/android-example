package com.amadeus.amadeusflightreservations.models.dtos;

public class Departure
{
    private String terminal;

    private String iataCode;

    private String at;

    public String getTerminal ()
    {
        return terminal;
    }

    public void setTerminal (String terminal)
    {
        this.terminal = terminal;
    }

    public String getIataCode ()
    {
        return iataCode;
    }

    public void setIataCode (String iataCode)
    {
        this.iataCode = iataCode;
    }

    public String getAt ()
    {
        return at;
    }

    public void setAt (String at)
    {
        this.at = at;
    }

    @Override
    public String toString()
    {
        return "[terminal = "+terminal+", iataCode = "+iataCode+", at = "+at+"]";
    }
}

