/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

import enums.Roles;

/**
 *
 * @author Kaitha, Abhinay Reddy;
 */
public class Technician extends Person{
    Roles Role;

    public Technician(String firstName, String lastName, Roles Role) {
        super(firstName, lastName);
        this.Role = Role;
    }

    public Roles getRole() {
        return Role;
    }
    
    @Override
    public int compareTo(Person o) {
        Technician T = (Technician) o;
        return Role.compareTo(T.getRole());
    }

    @Override
    public String toString() {
        return super.toString()+ "\t\t\t"+ Role;
    }
}
