package com.calibrate.stocktraderbe.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class StockAPI {
    public String API(String stock) {
        String apiCall = String.format("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=4MMDJBHZI7B0EFBD", stock);
        return apiCall;
    }

    public String getData(String url) {
        try {
            OkHttpClient httpClient = new OkHttpClient();

            String requestUrl = url;

            Request request = new Request.Builder()
                    .url(requestUrl)
                    .build();

            Response response = httpClient.newCall(request).execute();
            int statusCode = response.code();

            String responseData = response.body().string();
            return responseData;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Unable to make request";
    }
}
