package com.dmchirchenko.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
class RateController {

    @Autowired
    RateService rateService;

    @Autowired
    ExternalRateService externalRateService;

    @PostMapping("/rate")
    RateDto get(@RequestBody RateRequestBody body) {
        return rateService.find(body.symbols, body.start_at, body.end_at);
    }

}