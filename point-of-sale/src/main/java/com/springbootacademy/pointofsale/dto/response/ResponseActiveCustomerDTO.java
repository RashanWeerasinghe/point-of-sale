package com.springbootacademy.pointofsale.dto.response;

import java.util.ArrayList;

public class ResponseActiveCustomerDTO {

    private String customerName;
    private ArrayList contactNumber;

    public ResponseActiveCustomerDTO() {
    }

    @Override
    public String toString() {
        return "ResponseActiveCustomerDTO{" +
                "customerName='" + customerName + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }

    public ResponseActiveCustomerDTO(String customerName, ArrayList contactNumber) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }
}
