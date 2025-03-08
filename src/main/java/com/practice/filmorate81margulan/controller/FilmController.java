package com.practice.filmorate81margulan.controller;

import com.practice.filmorate81margulan.model.Film;
import com.practice.filmorate81margulan.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController {
// структура для хранения объектов - хэш-таблица/список
    private final FilmService filmService;

    @GetMapping
    public Collection<Film> findAll() { // можно использовать Collection<Film>
        return filmService.findAll();
    }

    @PostMapping
    public Film create(@RequestBody Film film) {

        // присваивание уникального идентификатора
        filmService.create(film);
        // добавление в структуру
        return film;
    }

    @PutMapping
    public Film update(@RequestBody Film film) {

        // добавление в структуру
        filmService.update(film);
        return film;
    }
}


