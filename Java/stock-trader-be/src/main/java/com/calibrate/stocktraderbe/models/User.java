package com.calibrate.stocktraderbe.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@NoArgsConstructor @Getter @Setter @ToString
public class User {
    private String name;
    private ArrayList<String> stockList;

    public User(String name) {
        this.name = name;
        this.stockList = new ArrayList<>();
    }

    public void addStockToList(String stockName) {
        stockList.add(stockName);
    }
}
