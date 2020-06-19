package com.vivienlouis.springproject;

import com.vivienlouis.springproject.model.Film;
import com.vivienlouis.springproject.repository.FilmRepository;
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
    @GetMapping("/film")
    public @ResponseBody Film getFilm(@RequestParam Integer id) {
        Film film = filmRepository.findByFilmid(id);
        return film;
    }
    @GetMapping("/avis")
    public @ResponseBody String getAvis(@RequestParam Integer id) {
        Film film = filmRepository.findByFilmid(id);
        return "press:" + film.getFilm_etoilespresse() + ", spec :" + film.getFilm_etoilesspectateurs() ;
    }

}
