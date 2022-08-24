package movies.controller;

import movies.model.Movie;
import movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Movie> movieList = (List<Movie>) movieService.findAllMovies();
        model.addAttribute("movies", movieList.isEmpty() ? Collections.emptyList() : movieList);
        return "index";
    }

    @GetMapping("/addmovie")
    public String showAddMovieForm(Movie movie) {
        return "add-movie";
    }

    @PostMapping("/addmovie")
    public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-movie";
        }
        movieService.createMovie(movie);
        model.addAttribute("movies", movieService.findAllMovies());
        return "redirect:/index";
    }

    @GetMapping("/update/{id}")
    public String showUpdateMovieForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieService.findMovieById(id).get());
        return "update-movie";
    }

    @PutMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") Long id, @Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            movie.setId(id);
            return "update-movie";
        }
        movieService.updateMovie(movie);
        model.addAttribute("movies", movieService.findAllMovies());
        return "redirect:/index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id, Model model) {
        movieService.deleteMovieById(id);
        model.addAttribute("movies", movieService.findAllMovies());
        return "redirect:/index";
    }

}
