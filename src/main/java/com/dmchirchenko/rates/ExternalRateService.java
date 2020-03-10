package com.dmchirchenko.rates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ExternalRateService {
    private Logger logger = LoggerFactory.getLogger(ExternalRateService.class);

    private RestTemplate restTemplate = new RestTemplate();
    private String fooResourceUrl = "https://api.exchangeratesapi.io/history";

    @Value("${app.baseCurrency}")
    private String baseCurrency;

    public String getCurrencies() {
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/", String.class);
        logger.info(response.getStatusCode().toString());
        return response.getBody();
    }

    public RateDto find(Currency[] symbols, LocalDate start, LocalDate end ) {
        logger.info(String.format("Got request: %s %s %s", symbols, start, end));
        ///history?base=USD&symbols=GBP,EUR,PHP&start_at=2020-01-01&end_at=2020-03-11
        String currencies = Arrays.asList(symbols).stream()
                .map(Currency::toString)
                .collect(Collectors.joining(","));

        String requestPath = String.format("%s?base=%s&symbols=%s&start_at=%s&end_at=%s"
            ,fooResourceUrl, baseCurrency, currencies, start, end);

        logger.info("Requesting external service: " + requestPath);
        RateDto response = restTemplate.getForObject(requestPath, RateDto.class);
        return response;
    }
}
