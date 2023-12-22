package com.graphql.service;

import com.graphql.model.Movie;
import com.graphql.model.MovieInput;

import java.util.List;

public interface MovieService {
    Movie addMovie(MovieInput movieInput);
    Movie updateMovie(Integer id, MovieInput movieInput) throws Exception;
    void deleteMovie(Integer id);
    Movie findMovieById(Integer id) throws Exception;
    List<Movie> findAllMovies();
}
