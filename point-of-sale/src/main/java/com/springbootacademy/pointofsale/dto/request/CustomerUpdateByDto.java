package com.springbootacademy.pointofsale.dto.request;

import java.util.ArrayList;

public class CustomerUpdateByDto {

    private String customerName;
    private double customerSalary;
    private String nic;

    public CustomerUpdateByDto() {
    }

    public CustomerUpdateByDto(String customerName, double customerSalary, String nic) {
        this.customerName = customerName;
        this.customerSalary = customerSalary;
        this.nic = nic;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "CustomerUpdateByDto{" +
                "customerName='" + customerName + '\'' +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                '}';
    }
}
