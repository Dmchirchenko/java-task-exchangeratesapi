package com.dmchirchenko.rates;

import java.time.LocalDate;

public class RateRequestBody {
        Currency[] symbols;
        LocalDate start_at;
        LocalDate end_at;

    public void setSymbols(Currency[] symbols) {
        this.symbols = symbols;
    }

    public void setStart_at(LocalDate start_at) {
        this.start_at = start_at;
    }

    public void setEnd_at(LocalDate end_at) {
        this.end_at = end_at;
    }
}