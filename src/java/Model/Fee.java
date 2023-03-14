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
public class Fee implements Serializable{
    private String id;
    private String time;
    private long salary;
    private long insuarance;
    private int payment;
    private long subsidy;
    private int recive;

    public Fee() {
    }

    public Fee(String id, String time, long salary, long insuarance, int payment, long subsidy, int recive) {
        this.id = id;
        this.time = time;
        this.salary = salary;
        this.insuarance = insuarance;
        this.payment = payment;
        this.subsidy = subsidy;
        this.recive = recive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getInsuarance() {
        return insuarance;
    }

    public void setInsuarance(long insuarance) {
        this.insuarance = insuarance;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public long getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(long subsidy) {
        this.subsidy = subsidy;
    }

    public int getRecive() {
        return recive;
    }

    public void setRecive(int recive) {
        this.recive = recive;
    }

    @Override
    public String toString() {
        return "Fee{" + "id=" + id + ", time=" + time + ", salary=" + salary + ", insuaran=" + insuarance + ", payment=" + payment + ", subsidy=" + subsidy + ", recive=" + recive + '}';
    }
    
}
