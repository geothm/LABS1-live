package ro.irian.pizzaapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import ro.irian.labs.pizzaapp.PizzaController;

@SpringBootApplication
@ComponentScan(basePackages = {"ro.irian.*"})
@EntityScan(basePackages = {"ro.irian.*"})
public class PizzaAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(PizzaAppApplication.class, args);
	}

}
