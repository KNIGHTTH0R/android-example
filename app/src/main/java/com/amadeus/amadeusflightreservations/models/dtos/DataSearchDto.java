package com.amadeus.amadeusflightreservations.models.dtos;

public class DataSearchDto {
    private String iataCode;

    private AddressSearchDto address;

    private String subType;

    private String name;

    private String detailedName;

    private String type;

    public String getIataCode ()
    {
        return iataCode;
    }

    public void setIataCode (String iataCode)
    {
        this.iataCode = iataCode;
    }

    public AddressSearchDto getAddress ()
    {
        return address;
    }

    public void setAddress (AddressSearchDto address)
    {
        this.address = address;
    }

    public String getSubType ()
    {
        return subType;
    }

    public void setSubType (String subType)
    {
        this.subType = subType;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDetailedName ()
    {
        return detailedName;
    }

    public void setDetailedName (String detailedName)
    {
        this.detailedName = detailedName;
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
        return "[iataCode = "+iataCode+", address = "+address+", subType = "+subType+", name = "+name+", detailedName = "+detailedName+", type = "+type+"]";
    }
}
