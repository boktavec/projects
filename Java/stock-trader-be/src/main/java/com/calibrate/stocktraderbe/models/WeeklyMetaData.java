package com.calibrate.stocktraderbe.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeeklyMetaData {
    @JsonProperty("1. Information")
    private String information;
    @JsonProperty("2. Symbol")
    private String symbol;
    @JsonProperty("3. Last Refreshed")
    private String lastRefreshed;
    @JsonProperty("4. Time Zone")
    private String timeZone;
}
