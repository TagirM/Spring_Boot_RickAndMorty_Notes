package com.example.example4sem6_rikky_and_morty_rest.controllers.web;

import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rickandmorty")
public class RickAndMortyController {

    private final ServiceApi serviceApi;

    @GetMapping
    public String getCharacters(@RequestParam(name = "search", required = false) String name, Model model) {
        model.addAttribute("results", serviceApi.getAllCharacters(name));
        model.addAttribute("search", name);
        return "characters";
    }

    @GetMapping("/{id}")
    public String getCharacterInfo(@PathVariable Integer id, Model model) {
        Result result = serviceApi.getCharacterById(id);
        model.addAttribute("result", result);
        return "character-info";
    }
}
