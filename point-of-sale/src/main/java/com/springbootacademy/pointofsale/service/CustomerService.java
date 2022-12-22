package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateByDto;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateQueryRequestDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateRequestDTO;
import com.springbootacademy.pointofsale.dto.response.ResponseActiveCustomerDTO;
import com.springbootacademy.pointofsale.dto.response.ResponseCustomerFilterDTO;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {
 public String save();

    String addCustomer(CustomerSaveRequestDTO customerDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id) throws NotFoundException;

   List<CustomerDTO> getByName(String customerName) throws NotFoundException;

    List<CustomerDTO> getAllCustomersByActiveState() throws NotFoundException;

    List<ResponseActiveCustomerDTO> getAllCustomersByActiveStateOnlyName() throws NotFoundException;

    String updateCustomerByQuery(CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO, int id);

    CustomerDTO getCustomerByNic(String nic);

    ResponseCustomerFilterDTO getCustomerByFilter(int id);

    String updateCustomerByRequest(CustomerUpdateByDto customerUpdateByDto, int id);

    CustomerDTO getCustomerByIDIsActive(int id);
}
