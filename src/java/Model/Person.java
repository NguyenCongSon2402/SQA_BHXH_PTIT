/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author CongSon
 */
public class Person implements Serializable{

    private String fullName;
    private int birthYear;
    private String homeTown;

    public Person() {
    }

    public Person(String fullName, int birthYear, String homeTown) {
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.homeTown = homeTown;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "Person{" + "fullName=" + fullName + ", birthYear=" + birthYear + ", homeTown=" + homeTown + '}';
    }
    
    
}
