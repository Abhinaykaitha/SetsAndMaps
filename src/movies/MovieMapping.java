/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kaitha, Abhinay Reddy;
 */
public class MovieMapping {
    private HashMap<Movie, LinkedList<Person>> moviemap;

    public MovieMapping() {
        this.moviemap = new HashMap<>();
    }

    public HashMap<Movie, LinkedList<Person>> getMoviemap() {
        return moviemap;
    }

    public void addMovieCrewPerson(Movie movie, Person person) {
        if (moviemap.containsKey(movie)) {
            LinkedList<Person> P = moviemap.get(movie);
            P.add(person);
            moviemap.put(movie,P);
        } else {
            LinkedList<Person> P = new LinkedList<>();
            P.add(person);
            moviemap.put(movie, P);
        }
    }
    public List<Movie> getListOfMoviesAPersonActed(String actorFullName) {
        List<Movie> movies = new ArrayList<>();
        String[] name = actorFullName.split(" ");
        for (Movie movie : moviemap.keySet()) {
            for (Actor a : movie.getCharacters().values()) {
                if (a.getFirstName().equals(name[0]) && a.getLastName().equals(name[1])) {
                    movies.add(movie);
                }
            }
        }
        return movies;
    }  
     public List<Technician> getAllTechnicians(String movieName) {
        List<Technician> T = new ArrayList<>();
        for (Movie m : moviemap.keySet()) {
            if (m.getTitle().equals(movieName)) {
                LinkedList<Person> persons = moviemap.get(m);
                for (Object person : persons) {
                    if (person instanceof Technician) {
                        Technician technicians = (Technician) person;
                        T.add(technicians);
                    }
                }
                break;
            }
        }
        return T;
    }
      public List<String> getListOfCharacterNames(String actor) {
        List<String> characters = new ArrayList<>();
        String[] name = actor.split(" ");
        for (Movie movie : moviemap.keySet()) {
            for (String c : movie.getCharacters().keySet()) {
                if ((movie.getCharacters().get(c).getFirstName().equals(name[0])) && (movie.getCharacters().get(c).getLastName().equals(name[1]))) {
                    characters.add(c);
                }
            }
        }
        return characters;
    }
        public List<Actor> getAllActors() {
        List<Actor> A = new ArrayList<>();
        for (Movie movie : moviemap.keySet()) {
            for (Actor actor : movie.getCharacters().values()) {
                if (!A.contains(actor)) {
                    A.add(actor);
                }
            }
        }
        return A;
    }
    @Override
           public String toString() {
        String M = "";
        for (Movie mov : moviemap.keySet()) {
            List techList = getAllTechnicians(mov.getTitle());
            String technicianString = "";
            for (Object tech : techList) {
                technicianString += "\n" + tech.toString();
            }
            M += "******************************************************\n" + mov.toString()
                    + "------------------------------------------------------\n"
                    + "Movie crew\n"
                    + "------------------------------------------------------\n"
                    + "\tName\t\t\tRole\n"
                    + "------------------------------------------------------" + technicianString + "\n\n";

        }
        return M;
    }
}
