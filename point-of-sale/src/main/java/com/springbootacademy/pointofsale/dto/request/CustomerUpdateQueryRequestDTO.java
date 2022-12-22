package com.springbootacademy.pointofsale.dto.request;

import java.util.ArrayList;

public class CustomerUpdateQueryRequestDTO {
    private String customerName;
    private String nic;

    public CustomerUpdateQueryRequestDTO() {
    }

    public CustomerUpdateQueryRequestDTO(String customerName, String nic) {
        this.customerName = customerName;
        this.nic = nic;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "CustomerUpdateQueryRequestDTO{" +
                "customerName='" + customerName + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
