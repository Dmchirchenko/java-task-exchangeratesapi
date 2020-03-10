package com.dmchirchenko.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class RateService {
    @Autowired
    RateRepository rateRepository;

    @Autowired
    ExternalRateService externalRateService;

    public RateDto find(Currency[] symbols, LocalDate start, LocalDate end) {
        RateDto result;
        result = externalRateService.find(symbols, start, end);
//        for( Currency currency : Arrays.asList(symbols)){
//            List<Rate> rates = rateRepository.findByCurrencyAndDateBetween(currency, start, end);
//            result.
//        }
//
//        if(rate == null){
//            rate = externalRateService.find(cur);
//            rateRepository.save(rate);
//        }
        return result;
    }
}


//        //test
//        RateDto testRate = new RateDto();
//        testRate.setCurrency("UAH");
//        testRate.setDate(LocalDate.now());
//        testRate.setValue(25.5);
//
//        rateRepository.save(testRate);

