package com.calibrate.stocktraderbe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
class DailyMetaData {
    @JsonProperty("1. Information")
    private String information;
    @JsonProperty("2. Symbol")
    private String symbol;
    @JsonProperty("3. Last Refreshed")
    private String lastRefreshed;
    @JsonProperty("4. Output Size")
    private String outputSize;
    @JsonProperty("5. Time Zone")
    private String timeZone;

}