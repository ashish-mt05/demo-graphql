package com.graphql.service;

import com.graphql.model.Movie;
import com.graphql.model.MovieInput;
import com.graphql.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repository;

    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Movie addMovie(MovieInput movieInput) {
        return repository.save(
                Movie
                        .builder()
                        .title(movieInput.getTitle())
                        .duration(movieInput.getDuration())
                        .review(movieInput.getReview())
                        .build()
        );
    }

    @Override
    public Movie updateMovie(Integer id, MovieInput movieInput) throws Exception {
        Movie movie = repository.findById(id).orElseThrow(() -> new Exception("Record not found with id : " + id));
        movie.setTitle(movieInput.getTitle());
        movie.setDuration(movieInput.getDuration());
        movie.setReview(movieInput.getReview());

        return repository.save(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Movie findMovieById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Record not found with id : " + id));
    }

    @Override
    public List<Movie> findAllMovies() {
        return repository.findAll();
    }
}
