package com.amadeus.amadeusflightreservations.models.dtos;

public class Aircraft
{
    private String code;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "[code = "+code+"]";
    }
}
