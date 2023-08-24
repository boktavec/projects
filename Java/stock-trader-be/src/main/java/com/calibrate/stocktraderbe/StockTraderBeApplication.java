package com.calibrate.stocktraderbe;

import com.calibrate.stocktraderbe.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockTraderBeApplication {

	static StockSystem system = new StockSystem();

	public static void main(String[] args) {

		User user = new User("tyler");
		user.addStockToList("DAVA");
		user.addStockToList("AAPL");
		user.addStockToList("NUE");
		user.addStockToList("MSFT");
		user.addStockToList("COKE");

		system.userSystem.put("tyler", user);


		SpringApplication.run(StockTraderBeApplication.class, args);


	}

}
