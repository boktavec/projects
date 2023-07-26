package com.calibrate.smallmart;

import com.calibrate.smallmart.data.ProductData;
import com.calibrate.smallmart.managers.ProductManager;
import com.calibrate.smallmart.managers.UserManager;
import com.calibrate.smallmart.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmallmartApplication {


	public static void main(String[] args) {
		//Insert product data in the product manager
		ProductData.productData();

		User john = new User("john", "jenkins", "johnjenkins@email.com", "1234 Street Way", "MasterCard");
		UserManager.userManager.put(john.getUserEmail(), john);

		SpringApplication.run(SmallmartApplication.class, args);

	}

}
