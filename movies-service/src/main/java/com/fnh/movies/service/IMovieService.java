package com.fnh.movies.service;

import com.fnh.movies.model.Movie;

import java.util.List;

public interface IMovieService {

    Movie validateAndGetMovie(String imdbId);

    List<Movie> getMovies();

    Movie saveMovie(Movie movie);

    void deleteMovie(Movie movie);
}