package com.dmchirchenko.rates;

import java.time.LocalDate;
import java.util.Map;

public class RateDto {

    private Map<LocalDate, Map<Currency, Double>> rates;

    public Map<LocalDate, Map<Currency, Double>> getRates() {
        return rates;
    }

    public void setRates(Map<LocalDate, Map<Currency, Double>> rates) {
        this.rates = rates;
    }
}



