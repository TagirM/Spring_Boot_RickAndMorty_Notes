package com.example.example4sem6_rikky_and_morty_rest.service;

import com.example.example4sem6_rikky_and_morty_rest.domain.Result;

import java.util.List;

public interface ServiceApi {
    List<Result> getAllCharacters(String name);
    Result getCharacterById(Integer id);
}
