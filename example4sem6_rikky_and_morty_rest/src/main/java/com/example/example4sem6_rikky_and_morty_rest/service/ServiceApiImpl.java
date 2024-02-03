package com.example.example4sem6_rikky_and_morty_rest.service;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    private static final String CHARACTER_API = "https://rickandmortyapi.com/api/character";

    /**
     * Весь перечень героев, либо результат поиска героя по имени
     * @param name Имя героя
     * @return Список героев
     */
    public List<Result> getAllCharacters(String name) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(CHARACTER_API, HttpMethod.GET, entity, Characters.class);
        List<Result> results = Objects.requireNonNull(response.getBody()).getResults();
        if (name!=null){
            List<Result> searchResults = new ArrayList<>();
            for (Result result : results) {
                if (result.getName().equals(name)){
                    searchResults.add(result);
                }
            }
            return searchResults;
        }
        return results;
    }

    /**
     * Поиск героя по Id
     * @param id
     * @return героя
     */
    public Result getCharacterById(Integer id) {
        List<Result> characterResult = getAllCharacters(null);
        for (Result result :
                characterResult) {
            if (result.getId().equals(id)){
                return result;
            }
        }
        throw new RuntimeException("Character with id = " + id + " is absent.");
    }
}
