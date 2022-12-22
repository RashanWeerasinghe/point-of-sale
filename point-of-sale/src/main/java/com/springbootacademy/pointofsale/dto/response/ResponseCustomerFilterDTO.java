package com.springbootacademy.pointofsale.dto.response;

import java.util.ArrayList;

public class ResponseCustomerFilterDTO {

    private String customerName;
    private String customerAddress;
    private double customerSalary;

    public ResponseCustomerFilterDTO() {
    }

    public ResponseCustomerFilterDTO(String customerName, String customerAddress, double customerSalary) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    @Override
    public String toString() {
        return "ResponseCustomerFilterDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                '}';
    }
}
