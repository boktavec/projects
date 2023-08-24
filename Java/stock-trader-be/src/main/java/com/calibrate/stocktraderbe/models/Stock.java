package com.calibrate.stocktraderbe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class Stock {
    @JsonProperty("stockName")
    private String stockName;

}

