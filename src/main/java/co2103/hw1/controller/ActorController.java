package co2103.hw1.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Actor;
import co2103.hw1.domain.Movie;

@Controller
public class ActorController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new ActorValidator());
	}
	
	@GetMapping("/actors")
	public String listActors(@RequestParam("movie") int movieId, Model m) {
		for (Movie movie : Hw1Application.movies) {
			if (movie.getId() == movieId) {
				m.addAttribute("actors", movie.getActors());
			}
		}
		m.addAttribute("movie", movieId);
		return "actors/list";
	}
	
	@RequestMapping("/newActor")
	public String newActor(@RequestParam("movie") int movie, Model m) {
		m.addAttribute("actor", new Actor());
		m.addAttribute("movie", movie);
		return "actors/form";
	}
	
	@PostMapping("/addActor")
	public String addActor(@RequestParam("movie") int movieId, @Valid @ModelAttribute Actor actor, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute("movie", movieId);
			return "actors/form";
		}
		for (Movie movie : Hw1Application.movies) {
			if (movie.getId() == movieId) {
				List<Actor> actors = movie.getActors();
				actors.add(actor);
			}
		}
		return "redirect:movies";
	}
}
