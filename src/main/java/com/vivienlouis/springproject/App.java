package com.vivienlouis.springproject;

import com.vivienlouis.springproject.model.Film;
import com.vivienlouis.springproject.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Autowired
    private FilmRepository filmRepository;

    /**
     * All film
     */

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    /**
     * One film
     */

    @GetMapping("/film")
    public @ResponseBody Film getFilm(@RequestParam Integer id) {
        Film film = filmRepository.findByFilmid(id);
        return film;
    }

    @DeleteMapping ("/film")
    public @ResponseBody ResponseEntity<String> deleteFilm(@RequestParam Integer id) {
        Film film = filmRepository.findByFilmid(id);
        filmRepository.delete(film);
        return ResponseEntity.status(202).body("accepted");
    }

    @PutMapping("/film")
    public @ResponseBody Film editFilm(@RequestParam Integer id,
                                         @RequestParam String titre,
                                         @RequestParam String url_affiche,
                                         @RequestParam String datesortie,
                                         @RequestParam String duree,
                                         @RequestParam Integer court,
                                         @RequestParam Integer anneeproduction,
                                         @RequestParam String synopsis,
                                         @RequestParam Integer etoilespresse,
                                         @RequestParam Integer etoilesspectateurs,
                                         @RequestParam Integer info,
                                         @RequestParam String genre,
                                         @RequestParam String destpublic,
                                         @RequestParam String remake,
                                         @RequestParam String titreoriginal,
                                         @RequestParam String distribuepar) {
        Film film = filmRepository.findByFilmid(id);
        film.setFilm_titre(titre);
        film.setFilm_url_affiche(url_affiche);
        film.setFilm_datesortie(datesortie);
        film.setFilm_duree(duree);
        film.setFilm_court(court);
        film.setFilm_anneeproduction(anneeproduction);
        film.setFilm_synopsis(synopsis);
        film.setFilm_etoilespresse(etoilespresse);
        film.setFilm_etoilesspectateurs(etoilesspectateurs);
        film.setFilm_info(info);
        film.setFilm_genre(genre);
        film.setFilm_public(destpublic);
        film.setFilm_remake(remake);
        film.setFilm_titreoriginal(titreoriginal);
        film.setFilm_distribuepar(distribuepar);
        filmRepository.save(film);
        return film;
    }
    @PostMapping("/film")
    public @ResponseBody Film postFilm(@RequestParam String titre,
                                       @RequestParam String url_affiche,
                                       @RequestParam String datesortie,
                                       @RequestParam String duree,
                                       @RequestParam Integer court,
                                       @RequestParam Integer anneeproduction,
                                       @RequestParam String synopsis,
                                       @RequestParam Integer etoilespresse,
                                       @RequestParam Integer etoilesspectateurs,
                                       @RequestParam Integer info,
                                       @RequestParam String genre,
                                       @RequestParam String destpublic,
                                       @RequestParam String remake,
                                       @RequestParam String titreoriginal,
                                       @RequestParam String distribuepar) {
        Film film = new Film();
        film.setFilm_titre(titre);
        film.setFilm_url_affiche(url_affiche);
        film.setFilm_datesortie(datesortie);
        film.setFilm_duree(duree);
        film.setFilm_court(court);
        film.setFilm_anneeproduction(anneeproduction);
        film.setFilm_synopsis(synopsis);
        film.setFilm_etoilespresse(etoilespresse);
        film.setFilm_etoilesspectateurs(etoilesspectateurs);
        film.setFilm_info(info);
        film.setFilm_genre(genre);
        film.setFilm_public(destpublic);
        film.setFilm_remake(remake);
        film.setFilm_titreoriginal(titreoriginal);
        film.setFilm_distribuepar(distribuepar);
        filmRepository.save(film);
        return film;
    }

    /**
     * AVIS
     */

    @GetMapping("/avis")
    public @ResponseBody String getAvis(@RequestParam Integer id) {
        Film film = filmRepository.findByFilmid(id);
        return "press:" + film.getFilm_etoilespresse() + ", spec :" + film.getFilm_etoilesspectateurs() ;
    }

}
