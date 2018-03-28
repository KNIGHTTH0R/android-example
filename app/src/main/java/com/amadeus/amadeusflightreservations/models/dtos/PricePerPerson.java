package com.amadeus.amadeusflightreservations.models.dtos;

public class PricePerPerson
{
    private String total;
    private String totalTaxes;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getTotalTaxes ()
    {
        return totalTaxes;
    }

    public void setTotalTaxes (String totalTaxes)
    {
        this.totalTaxes = totalTaxes;
    }

    @Override
    public String toString()
    {
        return "[total = "+total+", totalTaxes = "+totalTaxes+"]";
    }
}
