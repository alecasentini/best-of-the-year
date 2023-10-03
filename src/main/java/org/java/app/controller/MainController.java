package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.java.app.movie.Movie;
import org.java.app.song.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {
		final String name = "Alessandro";
		model.addAttribute("name",name);
		
		return "index";
	}
	
	private List<Movie> getBestMovies() {
		 List<Movie> movies = new ArrayList<>();
		    movies.add(new Movie(1, "Jurassic Park"));
		    movies.add(new Movie(2, "Titanic"));
		    movies.add(new Movie(3, "Avatar"));
		    movies.add(new Movie(4, "E.T."));
		    movies.add(new Movie(5, "Lo squalo"));
		    return movies;
	}
	
	private List<Song> getBestSongs() {
	    List<Song> songs = new ArrayList<>();
		songs.add(new Song(1, "Thriller"));
	    songs.add(new Song(2, "One More Time"));
	    songs.add(new Song(3, "Master of Puppet"));
	    songs.add(new Song(4, "2 Minutes to Midnight"));
	    songs.add(new Song(5, "Smells Like Teen Spirit"));
		return songs;
	}
	
	@GetMapping("/movies")
	public String movies(Model model){
	    List<Movie> bestMovies = getBestMovies();
	    model.addAttribute("movies", bestMovies);
	    return "movies";
	}

	@GetMapping("/songs")
	public String songs(Model model){
	    List<Song> bestSongs = getBestSongs();
	    model.addAttribute("songs", bestSongs);
	    return "songs";
	}

	
	@GetMapping("/movies/{id}")
	public String movie(@PathVariable int id, Model model) {
	    List<Movie> bestMovies = getBestMovies();
	    if (id > 0 && id <= bestMovies.size()) {
	        Movie movie = bestMovies.get(id - 1);
	        model.addAttribute("movie", movie.getTitle());
	    } else {
	        model.addAttribute("movie", "Movie not found");
	    }
	    return "movie-id";
	}

	
	@GetMapping("/songs/{id}")
	public String song(@PathVariable int id, Model model) {
		List<Song> bestSongs = getBestSongs();
		if (id > 0 && id <= bestSongs.size()) {
	        Song song = bestSongs.get(id - 1);
	        model.addAttribute("song", song.getTitle());
	    } else {
	        model.addAttribute("song", "Song not found");
	    }
		return "song-id";
	}

}
