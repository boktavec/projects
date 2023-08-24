package com.calibrate.stocktraderbe.controllers;

import com.calibrate.stocktraderbe.StockSystem;
import com.calibrate.stocktraderbe.models.Stock;
import com.calibrate.stocktraderbe.models.TimeSeriesData;
import com.calibrate.stocktraderbe.models.User;
import com.calibrate.stocktraderbe.services.StockTrackingService;
;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


@RestController
public class TraderController {

    StockSystem system = new StockSystem();

    public StockTrackingService stockMarket = new StockTrackingService();

    @PostMapping("/daily-stock")
    public TimeSeriesData getStockData(@RequestBody Stock stock) throws IOException {
        String stockName = stock.getStockName().toUpperCase();
        TimeSeriesData data = stockMarket.getDailyStockData(stockName);
        return data;

    }

    @PostMapping("/weekly-stock")
    public TimeSeriesData getWeeklyStockData(@RequestBody Stock stock) throws IOException {
        String stockName = stock.getStockName().toUpperCase();
        TimeSeriesData data = stockMarket.getWeeklyStockData(stockName);
        return data;

    }

    @GetMapping("/portfolio")
    public ArrayList<TimeSeriesData> stockList() throws IOException {

        User user = system.userSystem.get("tyler");

        ArrayList<TimeSeriesData> stocks = new ArrayList<>();
        ArrayList<String> stockList = user.getStockList();

        Iterator<String> iterator = stockList.iterator();
        while(iterator.hasNext()){
            String stock = iterator.next().toUpperCase();
            TimeSeriesData data = stockMarket.getDailyStockData(stock);

            stocks.add(data);
        }

        return stocks;

    }

    @PostMapping("/add-stock")
    public void addStock(@RequestBody Stock stock){

        User user = system.userSystem.get("tyler");

        String stockName = stock.getStockName().toUpperCase();

        user.addStockToList(stockName);

        system.userSystem.put("tyler", user);

    }

    @PostMapping("/remove-stock")
    public void removeStock(@RequestBody Stock stock){

        User user = system.userSystem.get("tyler");

        ArrayList<String> stockList = user.getStockList();

        String stockName = stock.getStockName().toUpperCase();

        stockList.remove(stockName);

        system.userSystem.put("tyler", user);

    }
}










