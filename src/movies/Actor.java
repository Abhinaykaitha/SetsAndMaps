/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

/**
 *
 * @author Kaitha, Abhinay Reddy;
 */
public class Actor extends Person  {
    private int age;
    private double remuneration;

    public Actor(int age, double remuneration, String firstName, String lastName) {
        super(firstName, lastName);
        this.age = age;
        this.remuneration = remuneration;
    }

    public int getAge() {
        return age;
    }

    public double getRemuneration() {
        return remuneration;
    }
    int flag;
    @Override
    public int compareTo(Person o){
Actor A=(Actor) o;
return Double.compare(this.remuneration, A.remuneration);
    }
       @Override
    public String toString() {
        return super.toString() + "\t\tAge: " + age;
    }
    
}
