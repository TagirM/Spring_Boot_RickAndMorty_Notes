package com.example.example4sem6_rikky_and_morty_rest.controllers.rest;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping
    public ResponseEntity<List<Result>> getCharacters(String name){
        return ResponseEntity.ok(serviceApi.getAllCharacters(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getCharacterById(@PathVariable Integer id)    {
        return ResponseEntity.ok(serviceApi.getCharacterById(id));
    }

}
