package com.example.animalfacts.service;

import com.example.animalfacts.model.AnimalFact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class AnimalFactsServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AnimalFactsService animalFactsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCatAndDogFacts() {
        String catFactUrl = "https://meowfacts.herokuapp.com/";
        String dogFactUrl = "https://dog-api.kinduff.com/api/facts";

        Map<String, Object> catFactResponse = new HashMap<>();
        catFactResponse.put("data", new String[]{"Random cat fact"});

        Map<String, Object> dogFactResponse = new HashMap<>();
        dogFactResponse.put("facts", new String[]{"Random dog fact"});

        when(restTemplate.getForObject(catFactUrl, Map.class)).thenReturn(catFactResponse);
        when(restTemplate.getForObject(dogFactUrl, Map.class)).thenReturn(dogFactResponse);

        AnimalFact animalFact = animalFactsService.getCatAndDogFacts();

        assertNotNull(animalFact.getCatFact());
        assertNotNull(animalFact.getDogFact());
    }
}
