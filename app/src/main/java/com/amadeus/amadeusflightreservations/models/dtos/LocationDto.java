package com.amadeus.amadeusflightreservations.models.dtos;

import com.amadeus.amadeusflightreservations.models.dtos.DataSearchDto;

public class LocationDto {

    private DataSearchDto[] data;

    public DataSearchDto[] getData() {
        return data;
    }

    public void setData(DataSearchDto[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "[data = " + data + ", meta =]";
    }

}
