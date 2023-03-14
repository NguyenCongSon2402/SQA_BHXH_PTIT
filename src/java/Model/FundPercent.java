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
public class FundPercent implements Serializable{
    private double fund1;
    private double fund2;
    private double fund3;
    private double fund4;
    private double fund5;

    public FundPercent() {
    }

    public FundPercent(double fund1, double fund2, double fund3, double fund4, double fund5) {
        this.fund1 = fund1;
        this.fund2 = fund2;
        this.fund3 = fund3;
        this.fund4 = fund4;
        this.fund5 = fund5;
    }

    public double getFund1() {
        return fund1;
    }

    public void setFund1(double fund1) {
        this.fund1 = fund1;
    }

    public double getFund2() {
        return fund2;
    }

    public void setFund2(double fund2) {
        this.fund2 = fund2;
    }

    public double getFund3() {
        return fund3;
    }

    public void setFund3(double fund3) {
        this.fund3 = fund3;
    }

    public double getFund4() {
        return fund4;
    }

    public void setFund4(double fund4) {
        this.fund4 = fund4;
    }

    public double getFund5() {
        return fund5;
    }

    public void setFund5(double fund5) {
        this.fund5 = fund5;
    }

    @Override
    public String toString() {
        return "SalaryRegion{" + "fund1=" + fund1 + ", fund2=" + fund2 + ", fund3=" + fund3 + ", fund4=" + fund4 + ", fund5=" + fund5 + '}';
    }
    
    
}
