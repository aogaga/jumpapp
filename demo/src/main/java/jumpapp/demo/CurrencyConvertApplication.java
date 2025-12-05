package jumpapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CurrencyConvertApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertApplication.class, args);
	}

}
