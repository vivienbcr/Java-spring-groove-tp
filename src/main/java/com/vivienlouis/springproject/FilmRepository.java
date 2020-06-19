package com.vivienlouis.springproject;

import org.springframework.data.repository.CrudRepository;

import com.vivienlouis.springproject.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {


}
