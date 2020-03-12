package co2103.hw1.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Movie;

public class MovieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Movie.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "Please enter a title.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "", "Please enter a city.");
		
		Movie movie = (Movie) target;
		for (Movie m : Hw1Application.movies) {
			if (m.getId() == movie.getId()) {
				errors.rejectValue("id", "", "This ID is already taken.");
			}
		}
	}

}
