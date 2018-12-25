/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

import enums.Genre;
import enums.MPAA_Rating;
import enums.Roles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kaitha, Abhinay Reddy;
 */
public class MovieMappingTest {

    MovieMapping instance;
    Movie bahubali = new Movie("Bahubali", Genre.DRAMA, MPAA_Rating.G, 130000000);
    Movie billa = new Movie("Billa", Genre.MYSTERY, MPAA_Rating.NC_17, 100000000);
    Person a1 = new Actor( 28, 500000.0,"Prabas", "Raju");
    Person a2 = new Actor(27, 400000.0,"Rana", "Daggubati" );
    Person a3 = new Actor(39, 300000.0,"Anushka", "Shetty" );
    Person a4 = new Actor( 40, 350000.0,"Ramya", "Krishna");
    Person t1 = new Technician("Rajamouli", "SS", Roles.ART_DIRECTOR);
    Person t2 = new Technician("Keeravani", "MM", Roles.MUSIC_EDITOR);

    public MovieMappingTest() {
        instance = new MovieMapping();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance.addMovieCrewPerson(bahubali, a1);
        instance.addMovieCrewPerson(bahubali, a2);
        instance.addMovieCrewPerson(bahubali, a3);
        instance.addMovieCrewPerson(bahubali, a4);
        instance.addMovieCrewPerson(bahubali, t1);
        instance.addMovieCrewPerson(bahubali, t2);
        instance.addMovieCrewPerson(billa, a1);
        instance.addMovieCrewPerson(billa, a3);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMoviemap method, of class MovieMapping.
     */
    @Test
    public void testGetMoviemap() {
        System.out.println("getMoviemap");
        int expResult = 2;
        int result = instance.getMoviemap().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of addMovieCrewPerson method, of class MovieMapping.
     */
    @Test
    public void testAddMovieCrewPerson() {
        System.out.println("addMovieCrewPerson");
        Movie m = new Movie("Darling", Genre.ROMANCE, MPAA_Rating.NC_17, 7000000);
        int expResult = instance.getMoviemap().size() + 1;
        instance.addMovieCrewPerson(m, a1);
        assertEquals(expResult, instance.getMoviemap().size());
    }

    /**
     * Test of getListOfMoviesAPersonActed method, of class MovieMapping.
     */
    @Test
    public void testGetListOfMoviesAPersonActed() {
        bahubali.addCharacter("bahubali", (Actor) a1);
        billa.addCharacter("billa", (Actor) a1);
        System.out.println("getListOfMoviesAPersonActed");
        String personName = "Prabas Raju";
        List<Movie> expResult = new ArrayList<>();
        expResult.add(billa);
        expResult.add(bahubali);
        List<Movie> result = instance.getListOfMoviesAPersonActed(personName);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllTechnicians method, of class MovieMapping.
     */
    @Test
    public void testGetAllTechnicians() {
        System.out.println("getAllTechnicians");
        String movieName = "Billa";
        List<Technician> expResult = new ArrayList<>();
        List<Technician> result = instance.getAllTechnicians(movieName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfCharacterNames method, of class MovieMapping.
     */
    @Test
    public void testGetListOfCharacterNames() {
        System.out.println("getListOfCharacterNames");
        bahubali.addCharacter("Bahubali", (Actor) a1);
        billa.addCharacter("Ranga", (Actor) a1);
        List<String> expResult = new ArrayList<>();
        expResult.add("Ranga");
        expResult.add("Bahubali");
        List<String> result = instance.getListOfCharacterNames("Prabas Raju");
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class MovieMapping.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "[Prabas Raju		Age: 28, Anushka Shetty		Age: 39]";
        String result = instance.getMoviemap().get(billa).toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortActors method, of class MovieMapping.
     */
    @Test
    public void testGetAllActors() {
        billa.addCharacter("Ranga", (Actor) a1);
        billa.addCharacter("Maya", (Actor) a3);
        System.out.println("getAllActors");
        List<Actor> expResult = new ArrayList<>();
        expResult.add((Actor) a1);
        expResult.add((Actor) a3);
        List<Actor> result = instance.getAllActors();
        assertEquals(expResult, result);
    }

}
