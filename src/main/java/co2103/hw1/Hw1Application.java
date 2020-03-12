package co2103.hw1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co2103.hw1.domain.Actor;
import co2103.hw1.domain.Movie;

@SpringBootApplication
public class Hw1Application implements CommandLineRunner {

	public static List<Movie> movies = new ArrayList<>();
	
	public static void main(String[] args) {
		SpringApplication.run(Hw1Application.class, args);
	}

	@Override
	public void run(String... args)	{
		Movie movie1 = new Movie();
		movie1.setId(0);
		movie1.setTitle("Star Wars");
		movie1.setCity("London");
		
		List<Actor> actors = new ArrayList<>();
		
		Actor actor1 = new Actor();
		actor1.setSurname("Ford");
		actor1.setFirstName("Harrison");
		actor1.setLanguage("English");
		actor1.setAge(77);
		actors.add(actor1);
		
		Actor actor2 = new Actor();
		actor2.setSurname("Hamill");
		actor2.setFirstName("Mark");
		actor2.setLanguage("English");
		actor2.setAge(68);
		actors.add(actor2);
		
		movie1.setActors(actors);
		movies.add(movie1);
	}
}
