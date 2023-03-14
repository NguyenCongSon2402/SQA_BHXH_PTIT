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
public class Staff extends Person implements Serializable {

    private String userName;
    private String department;

    public Staff() {
    }

    public Staff(String userName, String department) {
        this.userName = userName;
        this.department = department;
    }

    public Staff(String userName, String department, String fullName, int birthYear, String homeTown) {
        super(fullName, birthYear, homeTown);
        this.userName = userName;
        this.department = department;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Staff{" + "userName=" + userName + ",fullName=" + this.getFullName() + ", birthYear=" + this.getBirthYear() + ", homeTown=" + this.getHomeTown() + ", department=" + department + '}';
    }

}
