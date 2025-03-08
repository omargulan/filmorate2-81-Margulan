package com.practice.filmorate81margulan.service;

import com.practice.filmorate81margulan.exception.NotFoundException;
import com.practice.filmorate81margulan.exception.ValidationException;
import com.practice.filmorate81margulan.model.Film;
import com.practice.filmorate81margulan.storage.FilmStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmStorage filmStorage;

    public List<Film> findAll() { // можно использовать Collection<Film>
        return filmStorage.findAll();
    }
    public Film create(Film film) {
        // ValidationException
        // название не может быть пустым;
        if(film.getName() == null || film.getName().isBlank()) {
            throw new ValidationException("название не может быть пустым");
        }
        // максимальная длина описания — 200 символов;
        if(film.getDescription().length() > 200) {
            throw new ValidationException("максимальная длина описания — 200 символов;");
        }

        // дата релиза — не раньше 28 декабря 1895 года;
        if(film.getReleaseDate().isBefore(LocalDate.of(1895, 12, 28))) {
            throw new ValidationException("дата релиза — не раньше 28 декабря 1895 года;");
        }

        // продолжительность фильма должна быть положительной.
        if(film.getDuration() <= 0){
            throw new ValidationException("продолжительность фильма должна быть положительной.");
        }



        // присваивание уникального идентификатора

        // добавление в структуру
        return filmStorage.create(film);
    }
    public Film update(Film film) {
        // ValidationException
        // название не может быть пустым;
        if(film.getName() == null || film.getName().isBlank()) {
            throw new ValidationException("название не может быть пустым");
        }
        // максимальная длина описания — 200 символов;
        if(film.getDescription().length() > 200) {
            throw new ValidationException("максимальная длина описания — 200 символов;");
        }

        // дата релиза — не раньше 28 декабря 1895 года;
        if(film.getReleaseDate().isBefore(LocalDate.of(1895, 12, 28))) {
            throw new ValidationException("дата релиза — не раньше 28 декабря 1895 года;");
        }

        // продолжительность фильма должна быть положительной.
        if(film.getDuration() <= 0){
            throw new ValidationException("продолжительность фильма должна быть положительной.");
        }

        // существует ли фильм с таким идентификатором
        Film existingFilm=filmStorage.findById(film.getId());
        if(existingFilm==null) {
            throw new NotFoundException("Не существует ли фильм с таким идентификатором");
        }

        // добавление в структуру

        return filmStorage.findById(film.getId());
    }
}
