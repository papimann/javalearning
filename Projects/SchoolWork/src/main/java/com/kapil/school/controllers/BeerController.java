package com.kapil.school.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.school.model.Beer;
import com.kapil.school.repository.BeerRepository;

@RestController
public class BeerController {

	@Autowired
	private BeerRepository repository;

	public BeerController(BeerRepository repository) {
		this.repository = repository;
	}

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@GetMapping("/good-beers")
	public Collection<Map<String, String>> goodBeers() {
		return repository.findAll().stream().filter(this::isGreatBeer).map(beer -> {
			Map<String, String> map = new HashMap<>();
			map.put("id", beer.getId().toString());
			map.put("name", beer.getName());
			return map;
		}).collect(Collectors.toList());
	}

	private boolean isGreatBeer(Beer beer) {
		return beer.getName().equalsIgnoreCase("Kentucky Vrunch Brand Stout")
				|| beer.getName().equalsIgnoreCase("Marshmallow Handjee");
	}

}
