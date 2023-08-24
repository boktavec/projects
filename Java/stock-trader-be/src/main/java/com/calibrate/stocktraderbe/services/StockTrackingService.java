package com.calibrate.stocktraderbe.services;


import com.calibrate.stocktraderbe.models.DailyStockData;
import com.calibrate.stocktraderbe.models.TimeSeriesData;
import com.calibrate.stocktraderbe.models.WeeklyStockData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class StockTrackingService  {
    private String apiUrl = "https://www.alphavantage.co/query?";
    private String apiKey = "&apikey=4MMDJBHZI7B0EFBD";

    private String report;

    public TimeSeriesData getDailyStockData(String stock) throws IOException{

        URL fullApiUrl = new URL(String.format("%sfunction=TIME_SERIES_DAILY&symbol=%s%s", apiUrl, stock, apiKey));

        HttpURLConnection connection = (HttpsURLConnection) fullApiUrl.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();


        if(responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            DailyStockData data = objectMapper.readValue(String.valueOf(sb), new TypeReference<DailyStockData>() {});
            TimeSeriesData dataForDate = data.getTimeSeriesDataForDate("2023-08-15");
            return dataForDate;

        } else {
            return null;
        }

    }


    public TimeSeriesData getWeeklyStockData(String stock) throws IOException{

        URL fullApiUrl = new URL(String.format("%sfunction=TIME_SERIES_WEEKLY&symbol=%s%s", apiUrl, stock, apiKey));

        HttpURLConnection connection = (HttpsURLConnection) fullApiUrl.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();


        if(responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            WeeklyStockData data = objectMapper.readValue(String.valueOf(sb), new TypeReference<WeeklyStockData>() {});
            TimeSeriesData dataForDate = data.getTimeSeriesDataForDate("2023-08-15");
            return dataForDate;

        } else {
            return null;
        }

    }

}
