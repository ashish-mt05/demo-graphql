package com.graphql.controller;

import com.graphql.model.Movie;
import com.graphql.model.MovieInput;
import com.graphql.service.MovieService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @MutationMapping
    public Movie addMovie(@Argument MovieInput movieInput){
        return movieService.addMovie(movieInput);
    }
    @QueryMapping
    public Movie findMovieById(@Argument Integer id) throws Exception {
        return movieService.findMovieById(id);
    }
    @QueryMapping
    public List<Movie> findAllMovies(){
        return movieService.findAllMovies();
    }

    @MutationMapping
    public Movie updateMovie(@Argument Integer id, @Argument MovieInput movieInput) throws Exception {

        return movieService.updateMovie(id, movieInput);
    }

    @MutationMapping
    public String deleteMovie(Integer id){
        movieService.deleteMovie(id);
        return "record deleted successfully with id :"+id;
    }
}
