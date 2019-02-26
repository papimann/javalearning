package com.kapil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.kapil.entity.Car;
import com.kapil.repo.CarRepository;

@EnableResourceServer
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository repository) {
		List<Car> cars = repository.findAll();
		List<String> carNames = cars.stream().map(Car::getName).collect(Collectors.toList());
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag",
					"Ford Pinto", "Yugo GV").forEach(name -> {
						if (!carNames.contains(name)) {
							Car car = new Car();
							car.setName(name);
							repository.save(car);
						}
					});
			repository.findAll().forEach(System.out::println);
		};
	}

}
