package com.vivienlouis.springproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.vivienlouis.springproject.model.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {
    Film findByFilmid(Integer id);
}
