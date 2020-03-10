package com.dmchirchenko.rates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
    List<Rate> findByCurrencyAndDateBetween(Currency currency, LocalDate start, LocalDate end);
}
