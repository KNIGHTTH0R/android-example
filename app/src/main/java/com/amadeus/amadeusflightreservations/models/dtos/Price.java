package com.amadeus.amadeusflightreservations.models.dtos;

public class Price {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "[total = " + total + "]";
    }
}
