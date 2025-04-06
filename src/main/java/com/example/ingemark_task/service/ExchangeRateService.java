package com.example.ingemark_task.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ingemark_task.model.ExchangeRate;
import com.example.ingemark_task.utils.NumberUtils;

@Service
public class ExchangeRateService {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateService.class);

    @Value("${exchange.api.url}")
    private String hnbApiUrl;

    /**
     * Converts the given EUR price to USD using the latest exchange rate from the HNB API.
     * Logs the conversion process for transparency.
     *
     * @param priceEur The price in EUR to be converted.
     *
     * @return The converted price in USD , rounded to two decimal places.
     */

    public double convertToUsd(double priceEur) {
        logger.info("Converting {} EUR to USD...", priceEur);

        //Making the API request to get the latest exchange rates
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExchangeRate[]> response = restTemplate.getForEntity(hnbApiUrl, ExchangeRate[].class);

        if (response.getBody().length == 0) {
            logger.error("Failed to retrieve exchange rates or no data received from the API.");
            throw new IllegalStateException("Exchange rates data not found or invalid response.");
        }
        List<ExchangeRate> rates = Arrays.asList(response.getBody());

        //Find the EUR to USD exchange rate
        double eurToUsdRate = rates.stream()
                                   .filter(rate -> "USD".equals(rate.getCurrency()))
                                   .mapToDouble(ExchangeRate::getMidRateAsDouble)
                                   .findFirst()
                                   .orElseThrow(() -> new IllegalStateException("Exchange rate for USD not found!"));

        return NumberUtils.roundToTwoDecimalPlaces(priceEur * eurToUsdRate);
    }
}

