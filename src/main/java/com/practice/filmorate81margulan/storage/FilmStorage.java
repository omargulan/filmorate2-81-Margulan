package com.practice.filmorate81margulan.storage;

import com.practice.filmorate81margulan.model.Film;

import java.util.List;

public interface FilmStorage {
    Film create(Film film);
    Film update(Film film);
    List<Film> findAll();
    Film findById(int id);
}
