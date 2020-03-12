package co2103.hw1.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co2103.hw1.domain.Actor;

public class ActorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Actor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "", "Please enter a surname.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "Please enter a first name.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "", "Please enter an age.");
		
		Actor actor = (Actor) target;
		if (!actor.getLanguage().equals("English") && !actor.getLanguage().equals("Spanish") && !actor.getLanguage().equals("German")) {
			errors.rejectValue("language", "", "Language must be English, Spanish or German.");
		}
		
		if (actor.getAge() < 1 || actor.getAge() > 120) {
			errors.rejectValue("age", "", "Age must be between 1 and 120.");
		}
	}

}
