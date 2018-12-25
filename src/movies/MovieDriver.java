/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

import enums.Genre;
import enums.MPAA_Rating;
import enums.Roles;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kaitha, Abhinay Reddy;
 */
public class MovieDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
MovieMapping map1 = new MovieMapping();
        Scanner scan = new Scanner(new File("movies.txt"));
        scan.nextLine();
        while (scan.hasNext()) {
            String title = scan.nextLine();
            String genre1 = scan.nextLine();
            String genres;
            if (genre1.contains(" ")) {
                genres = genre1.replace(" ", "_");
            } else {
                genres = genre1;
            }
            Genre genre = Genre.valueOf(genres.toUpperCase());
            String col = scan.next().substring(1);
            double C = Double.parseDouble(col);
            String values = scan.nextLine();
            if (values.equals(" Billion") || values.equals(" billion")) {
                C =C* 1000000000;
            } else {
                C = C*1000000;
            }
            String rating1 = scan.nextLine();
            MPAA_Rating rating = MPAA_Rating.valueOf(rating1.toUpperCase());
            Movie movie = new Movie(title, genre, rating, C);
            String x = scan.nextLine();
            do {
                String actors;
                if (!x.equals("Actors")) {
                    actors = x;
                } else {
                    actors = scan.nextLine();
                }
                String[] actorss = actors.split(" - ");
                String[] name = actorss[1].split(" ");
                int age = scan.nextInt();
                scan.nextLine();
                String renumeration = scan.next().substring(1);
                scan.nextLine();
                double renumerationDouble = Double.parseDouble(renumeration) * 1000000;
                Actor actor = new Actor(age, renumerationDouble, name[0], name[1]);
                movie.addCharacter(actorss[0], actor);
                if (scan.hasNext()) {
                    x = scan.nextLine();
                } else {
                    break;
                }
            } while (!x.equals("Technicians"));
            do {
                String techNames;
                if (!x.equals("Technicians")) {
                    techNames = x;
                } else {
                    techNames = scan.nextLine();
                }
                String[] techName = techNames.split(" ");
                String techRole = scan.nextLine();
                String roles;
                if (techRole.contains(" ")) {
                    roles = techRole.replace(" ", "_");
                } else {
                    roles = techRole;
                }
                Roles role = Roles.valueOf(roles.toUpperCase());
                Person P = new Technician(techName[0], techName[1], role);
                map1.addMovieCrewPerson(movie, P);
                if (scan.hasNext()) {
                    x = scan.nextLine();
                } else {
                    break;
                }
            } while (!x.equals("Movie"));
        }
        System.out.println("******************************************************\n"
                + "Details of all movies in map1");
        System.out.print(map1.toString().substring(0, map1.toString().length()-1));
        System.out.println("******************************************************\n"
                + "\n"
                + "******************************************************\n"
                + "All technicians mapped with in movie Avengers\n"
                + "******************************************************");
        for (Technician tech : map1.getAllTechnicians("Avengers: Infinity War")) {
            System.out.println(tech);
        }
        System.out.println("\n******************************************************\n"
                + "Character names of actor Prabas Raju in different movies\n"
                + "******************************************************");
        for (String movie : map1.getListOfCharacterNames("Prabhas Raju")) {
            System.out.println(movie);
        }
        System.out.println("\n******************************************************\n"
                + "List of movies Anushka Shetty acted\n"
                + "******************************************************");
        for (Movie movie : map1.getListOfMoviesAPersonActed("Anushka Shetty")) {
            System.out.println(movie.getTitle());
        }
        System.out.println("\n******************************************************\n"
                + "List of all actors from all movies in the map\n"
                + "******************************************************");
        List<Actor> actors = map1.getAllActors();
        Collections.sort(actors);
        for (Movie movie : map1.getMoviemap().keySet()) {
            for (Actor A : actors) {
                for (Actor actor : movie.getCharacters().values()) { 
                    if (actor.getFirstName().equals(A.getFirstName()) && actor.getLastName().equals(A.getLastName())) {
                        System.out.println(A);
                    }
                }
            }
        }
        System.out.println("\n******************************************************\n"
                + "List of all movies sorted based on gross collections in descending order\n"
                + "******************************************************");
        List<Double> collection = new ArrayList<>();
        for (Movie M : map1.getMoviemap().keySet()) {
            collection.add(M.getCollections());
        }
        Collections.sort(collection, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o2, o1);
            }
        });
        for (Double dd : collection) {
            for (Movie movie : map1.getMoviemap().keySet()) {
                if (movie.getCollections() == dd) {
                    System.out.println(movie.getTitle() + "\t\t$" + String.format("%.2f", dd));
                }
            }
        }
    }
}
