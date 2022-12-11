package com.fnh.movies.repository;

import com.fnh.movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends MongoRepository<Movie, String> {
}