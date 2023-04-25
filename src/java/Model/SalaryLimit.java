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
    private long maxSalary;
    private long minSalary;

    public SalaryLimit() {
    }

    public SalaryLimit(long maxSalary, long minSalary) {
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(long minSalary) {
        this.minSalary = minSalary;
    }

    @Override
    public String toString() {
        return "SalaryLimit{" + "maxSalary=" + maxSalary + ", minSalary=" + minSalary + '}';
    }
    
    
}
