package com.vivienlouis.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Autowired
    private FilmRepository filmRepository;
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Film> getAllFilms() {
        return filmRepository.findAll();
    }

}
