package com.amadeus.amadeusflightreservations.models.dtos;

public class AddressSearchDto {
    private String countryName;

    private String cityName;

    public String getCountryName ()
    {
        return countryName;
    }

    public void setCountryName (String countryName)
    {
        this.countryName = countryName;
    }

    public String getCityName ()
    {
        return cityName;
    }

    public void setCityName (String cityName)
    {
        this.cityName = cityName;
    }

    @Override
    public String toString()
    {
        return "[countryName = "+countryName+", cityName = "+cityName+"]";
    }
}

