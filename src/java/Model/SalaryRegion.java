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
public class SalaryRegion  implements Serializable{
    private long salaryRegion1;
    private long salaryRegion2;
    private long salaryRegion3;
    private long salaryRegion4;

    public SalaryRegion() {
    }

    public SalaryRegion(long salaryRegion1, long salaryRegion2, long salaryRegion3, long salaryRegion4) {
        this.salaryRegion1 = salaryRegion1;
        this.salaryRegion2 = salaryRegion2;
        this.salaryRegion3 = salaryRegion3;
        this.salaryRegion4 = salaryRegion4;
    }

    public long getSalaryRegion1() {
        return salaryRegion1;
    }

    public void setSalaryRegion1(long salaryRegion1) {
        this.salaryRegion1 = salaryRegion1;
    }

    public long getSalaryRegion2() {
        return salaryRegion2;
    }

    public void setSalaryRegion2(long salaryRegion2) {
        this.salaryRegion2 = salaryRegion2;
    }

    public long getSalaryRegion3() {
        return salaryRegion3;
    }

    public void setSalaryRegion3(long salaryRegion3) {
        this.salaryRegion3 = salaryRegion3;
    }

    public long getSalaryRegion4() {
        return salaryRegion4;
    }

    public void setSalaryRegion4(long salaryRegion4) {
        this.salaryRegion4 = salaryRegion4;
    }

    @Override
    public String toString() {
        return "SalaryRegion{" + "salaryRegion1=" + salaryRegion1 + ", salaryRegion2=" + salaryRegion2 + ", salaryRegion3=" + salaryRegion3 + ", salaryRegion4=" + salaryRegion4 + '}';
    }
    
    
    
}
