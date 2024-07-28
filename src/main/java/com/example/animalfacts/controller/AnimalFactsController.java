package com.example.animalfacts.controller;

import com.example.animalfacts.model.AnimalFact;
import com.example.animalfacts.service.AnimalFactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/animal-facts")
public class AnimalFactsController {

    @Autowired
    private AnimalFactsService animalFactsService;

    @GetMapping("/cats-dogs")
    public AnimalFact getCatAndDogFacts() {
        return animalFactsService.getCatAndDogFacts();
    }
}
