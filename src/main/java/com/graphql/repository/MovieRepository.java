package com.graphql.repository;

import com.graphql.model.Movie;
import com.graphql.model.MovieInput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
