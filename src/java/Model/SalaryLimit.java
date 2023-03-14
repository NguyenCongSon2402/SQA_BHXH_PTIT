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
public class SalaryLimit implements Serializable{
    private double maxSalary;
    private double minSalary;

    public SalaryLimit() {
    }

    public SalaryLimit(double maxSalary, double minSalary) {
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    @Override
    public String toString() {
        return "SalaryLimit{" + "maxSalary=" + maxSalary + ", minSalary=" + minSalary + '}';
    }
    
    
}
