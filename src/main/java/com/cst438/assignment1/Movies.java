package com.cst438.assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Movies {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/")
    public String index(Model model) {
        long movies = movieRepository.count(true);
        String numMovies = Long.toString(movies);
        model.addAttribute("numMovies", numMovies);
        return "index";
    }

    @GetMapping("/movies/new")
    public String createMovieRating(Model model) {
        Rating rating = new Rating();
        model.addAttribute("movie", rating);
        return "movie_form";
    }

    @PostMapping("/movies/new")
    public String processMovieForm(@Valid Rating rating, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "movie_form";
        }
        movieRepository.save(rating);
        return "movie_show";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        Iterable<Rating> movies = movieRepository.findAllMovieRatingsOrderByTitleDateDesc();
        model.addAttribute("ratings", movies);
        return "movie_list";
    }
}
