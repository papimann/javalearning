package com.kapil.school.runner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kapil.school.model.Beer;
import com.kapil.school.repository.BeerRepository;

@Component
public class BeerCommandLineRunner implements CommandLineRunner {

	@Autowired
	private final BeerRepository repository;

	public BeerCommandLineRunner(BeerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {

		List<Beer> beers = repository.findAll();
		List<String> beerNames = beers.stream().map(Beer::getName).collect(Collectors.toList());
		Stream.of("Kentucky Vrunch Brand Stout", "Marshmallow Handjee", "Barrel-Aged", "SR-71")
				.filter(beerName -> !beerNames.contains(beerName)).forEach(name -> repository.save(new Beer(name)));
		repository.findAll().forEach(System.out::println);
		// TODO Auto-generated method stub

	}

}
