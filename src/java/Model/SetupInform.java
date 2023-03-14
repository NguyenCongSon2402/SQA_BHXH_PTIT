/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Data.*;
import Model.FundPercent;
import Model.SalaryLimit;
import Model.SalaryRegion;
import java.io.Serializable;

/**
 *
 * @author CongSon
 */
public class SetupInform implements Serializable{

    private FundPercent fundPercent;
    private SalaryLimit salaryLimit;
    private SalaryRegion salaryRegion;

    public SetupInform() {
    }

    public SetupInform(FundPercent fundPercent, SalaryLimit salaryLimit, SalaryRegion salaryRegion) {
        this.fundPercent = fundPercent;
        this.salaryLimit = salaryLimit;
        this.salaryRegion = salaryRegion;
    }

    public FundPercent getFundPercent() {
        return fundPercent;
    }

    public void setFundPercent(FundPercent fundPercent) {
        this.fundPercent = fundPercent;
    }

    public SalaryLimit getSalaryLimit() {
        return salaryLimit;
    }

    public void setSalaryLimit(SalaryLimit salaryLimit) {
        this.salaryLimit = salaryLimit;
    }

    public SalaryRegion getSalaryRegion() {
        return salaryRegion;
    }

    public void setSalaryRegion(SalaryRegion salaryRegion) {
        this.salaryRegion = salaryRegion;
    }

    @Override
    public String toString() {
        return "SetupInform{" + "fundPercent=" + fundPercent + ", salaryLimit=" + salaryLimit + ", salaryRegion=" + salaryRegion + '}';
    }
    
    
}
