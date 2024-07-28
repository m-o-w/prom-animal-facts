package com.example.animalfacts.service;

import com.example.animalfacts.model.AnimalFact;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AnimalFactsService {

    private final RestTemplate restTemplate = new RestTemplate();

    public AnimalFact getCatAndDogFacts() {
        String catFactUrl = "https://meowfacts.herokuapp.com/";
        String dogFactUrl = "https://dog-api.kinduff.com/api/facts";

        Map<String, Object> catFactResponse = restTemplate.getForObject(catFactUrl, Map.class);
        Map<String, Object> dogFactResponse = restTemplate.getForObject(dogFactUrl, Map.class);

        String catFact = extractCatFactFromResponse(catFactResponse);
        String dogFact = extractDogFactFromResponse(dogFactResponse);

        AnimalFact animalFact = new AnimalFact();
        animalFact.setCatFact(catFact);
        animalFact.setDogFact(dogFact);

        return animalFact;
    }

    private String extractCatFactFromResponse(Map<String, Object> response) {
        return ((List<String>) response.get("data")).get(0);
    }

    private String extractDogFactFromResponse(Map<String, Object> response) {
        return ((List<String>) response.get("facts")).get(0);
    }
}
