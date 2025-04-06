package com.example.ingemark_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeRate {

    @JsonProperty("valuta")
    private String currency;

    @JsonProperty("srednji_tecaj")
    private String midRate;

    public ExchangeRate() {}

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getMidRateAsDouble() {
        return Double.parseDouble(midRate.replace(",", "."));
    }

    public void setMidRate(String midRate) {
        this.midRate = midRate;
    }
}