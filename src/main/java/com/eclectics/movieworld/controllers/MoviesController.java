/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclectics.movieworld.controllers;

import com.eclectics.movieworld.entities.Movie;
import com.eclectics.movieworld.repositories.MovieRepository;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kiburu
 */
@RestController
@RequestMapping("movies")
@CrossOrigin
@Api(tags = "Movies")
public class MoviesController {
    
    @Autowired
    MovieRepository movieRepository;

    // get all movies
    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) String title) {
        try {
            List<Movie> movies = new ArrayList<Movie>();

            if (title == null)
                movieRepository.findAll().forEach(movies::add);
            else
                movieRepository.findByTitleContaining(title).forEach(movies::add);

            if (movies.isEmpty()) {
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // get one movie by id
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long id) {
        Optional<Movie> movieData = movieRepository.findById(id);

        if (movieData.isPresent()) {
            return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // create a movie
    @PostMapping("/create")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            Movie _movie = movieRepository
                .save(movie);
            return new ResponseEntity<>(_movie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // update a single movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        Optional<Movie> movieData = movieRepository.findById(id);

        if (movieData.isPresent()) {
            Movie _movie = movieData.get();
            _movie.setTitle(movie.getTitle());
            _movie.setDescription(movie.getDescription());
            _movie.setRecomendation(movie.getRecomendation());
            _movie.setRating(movie.getRating());
            _movie.setIsWatched(movie.isIsWatched());
            _movie.setType(movie.getType());
            return new ResponseEntity<>(movieRepository.save(_movie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete a single movie
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id) {
        try {
            movieRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // delete all movies
    @DeleteMapping("/all")
    public ResponseEntity<HttpStatus> deleteAllMovies() {
        try {
            movieRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
