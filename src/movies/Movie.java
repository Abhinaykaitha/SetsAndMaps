/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

import enums.Genre;
import enums.MPAA_Rating;
import java.util.HashMap;

/**
 *
 * @author Kaitha, Abhinay Reddy;
 */
public class Movie implements Comparable<Movie> {
    private String title;
    private Genre genre;
    private MPAA_Rating rating;
    private double collections;
    private HashMap<String, Actor> characters;

    public Movie(String title, Genre genre, MPAA_Rating rating, double collections) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.collections = collections;
        this.characters = new HashMap<>();
    }
    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public MPAA_Rating getRating() {
        return rating;
    }

    public double getCollections() {
        return collections;
    }

    public HashMap<String, Actor> getCharacters() {
        return characters;
    }
     public void addCharacter(String characterName, Actor actor) {
        characters.put(characterName, actor);
    }
     public int compareTo(Movie o){
         return this.genre.compareTo(o.getGenre());
     }

   // public int compareTo(Genre g) {
     //   return g.compareTo(this.genre);
    //}
    public String toString() {
        String print = "";
        for (String character : characters.keySet()) {
            String A = characters.get(character).toString().substring(0, characters.get(character).toString().indexOf("\t"));
            print =print+ character + "\t\t\t" + A + "\n";
        }
        String g = "";
        switch(genre){
            case BIOGRAPHY:
                g = g+ "Biography";
                break;
            case DRAMA:
                g =g+ "Drama";
                break;
            case FANTASY:
                g =g+ "Fantasy";
                break;
            case HORROR:
                g = g+"Horror";
                break;
            case MYSTERY:
                g =g+ "Mystery";
                break;
            case POETRY:
                g = g+"Poetry";
                break;
            case ROMANCE:
                g =g+ "Romance";
                break;
            case SCIENCE_FICTION:
                g =g+ "Science_Fiction";
                break;
            case THRILLER:
                g =g+ "Thriller";
                break;
        }
        return title+ "\nGenre: " + g + "\t\tRating: " + rating + " (" +rating.getAge() + " Years)"+ 
                            "\nCollections: $" + String.format("%.2f", collections) + 
                            "\nCast:\n"
                + "------------------------------------------------------\n"
                + "Character Played	Actor Name\n"
                + "------------------------------------------------------\n" + print;
    }

}
