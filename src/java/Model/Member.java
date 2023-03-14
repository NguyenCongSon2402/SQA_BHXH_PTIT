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
public class Member extends Person implements Serializable {

    private String id;

    public Member() {
    }

    public Member(String id) {
        this.id = id;
    }

    public Member(String id, String fullName, int birthYear, String homeTown) {
        super(fullName, birthYear, homeTown);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ",fullName=" + this.getFullName() + ", birthYear=" + this.getBirthYear() + ", homeTown=" + this.getHomeTown() + '}';
    }

}
