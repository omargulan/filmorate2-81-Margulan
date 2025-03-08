package com.practice.filmorate81margulan.storage;

import com.practice.filmorate81margulan.model.Film;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class InMemoryFilmStorage implements FilmStorage{
    private final Map<Integer, Film> films = new HashMap<>();
    private int count = 1;


    @Override
    public Film create(Film film) {
        film.setId(count++);

        // присваивание уникального идентификатора
        films.put(film.getId(), film);
        // добавление в структуру
        return film;
    }

    @Override
    public Film update(Film film) {
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public List<Film> findAll() {
        return new ArrayList<>(films.values());
    }

    @Override
    public Film findById(int id) {
        return films.get(id);
    }
}
