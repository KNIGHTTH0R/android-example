package com.amadeus.amadeusflightreservations.models.dtos;

public class FamilyCombosDto {
    private Dictionaries dictionaries;

    private DataCombos[] data;

    public Dictionaries getDictionaries ()
    {
        return dictionaries;
    }

    public DataCombos[] getData ()
    {
        return data;
    }

    public void setData (DataCombos[] data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "[dictionaries =, data = "+data+", meta = ";
    }

}
