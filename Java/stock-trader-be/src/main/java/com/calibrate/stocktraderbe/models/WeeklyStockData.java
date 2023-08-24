package com.calibrate.stocktraderbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true) @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class WeeklyStockData {
    @JsonProperty("Meta Data")
    private WeeklyMetaData metaData;
    @JsonProperty("Weekly Time Series")
    private Map<String, TimeSeriesData> timeSeriesData;
    public TimeSeriesData getTimeSeriesDataForDate(String date) {
        return timeSeriesData.get(date);
    }
}
