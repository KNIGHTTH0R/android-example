package com.amadeus.amadeusflightreservations.models.dtos;

public class Services
{
    private Segments[] segments;

    public Segments[] getSegments ()
    {
        return segments;
    }

    public void setSegments (Segments[] segments)
    {
        this.segments = segments;
    }

    @Override
    public String toString()
    {
        return "[segments = "+segments+"]";
    }
}
		
