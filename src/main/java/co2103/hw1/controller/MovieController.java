package co2103.hw1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Actor;
import co2103.hw1.domain.Movie;

@Controller
public class MovieController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new MovieValidator());
	}
	
	@GetMapping("/movies")
	public String listMovies(Model m) {
		m.addAttribute("movies", Hw1Application.movies);
		return "movies/list";
	}
	
	@RequestMapping("/newMovie")
	public String newMovie(Model m) {
		m.addAttribute("movie", new Movie());
		return "movies/form";
	}
	
	@PostMapping("/addMovie")
	public String addMovie(@Valid @ModelAttribute Movie movie, BindingResult result) {
		if (result.hasErrors()) {
			return "movies/form";
		}
		List<Actor> actors = new ArrayList<>();
		movie.setActors(actors);
		Hw1Application.movies.add(movie);
		return "redirect:movies";
	}
}
