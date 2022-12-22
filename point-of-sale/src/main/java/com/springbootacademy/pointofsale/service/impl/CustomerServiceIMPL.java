package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateByDto;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateQueryRequestDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateRequestDTO;
import com.springbootacademy.pointofsale.dto.response.ResponseActiveCustomerDTO;
import com.springbootacademy.pointofsale.dto.response.ResponseCustomerFilterDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.exception.EntryDuplicateException;
import com.springbootacademy.pointofsale.exception.EntryNotFoundException;
import com.springbootacademy.pointofsale.repo.CustomerRepo;
import com.springbootacademy.pointofsale.service.CustomerService;
import com.springbootacademy.pointofsale.util.mappers.CustomerMapper;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {
  public String save(){
       return "Hello Rashan";
  }

  @Autowired
  private CustomerRepo customerRepo;

  @Autowired

  private ModelMapper modelMapper;

  @Autowired
  private CustomerMapper customerMapper;

  @Override
  public String addCustomer(CustomerSaveRequestDTO customerDTO) {
    Customer customer=new Customer(
            customerDTO.getCustomerName(),
            customerDTO.getCustomerAddress(),
            customerDTO.getCustomerSalary(),
            customerDTO.getContactNumber(),
            customerDTO.getNic(),
            true
    );

    if(!customerRepo.existsById(customer.getCustomerId())){
      customerRepo.save(customer);
    }else{
      System.out.println("customer id alreay exists");
      return "customer id alreay exists";
    }

    return customer.getCustomerName()+" Saved";
  }

  @Override
  public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
    if(customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())){
      Customer customer = customerRepo.getById(customerUpdateRequestDTO.getCustomerId());
      customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
      customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
      customer.setCustomerSalary(customerUpdateRequestDTO.getCustomerSalary());
      customer.setContactNumber(customerUpdateRequestDTO.getContactNumber());
      customer.setNic(customerUpdateRequestDTO.getNic());
      customer.setActiveState(customerUpdateRequestDTO.isActiveState());

      return customerRepo.save(customer).getCustomerName()+"Updated";

    }else{
//      System.out.println("this customer not in database");
//      return "this customer not in database";
      throw new EntryDuplicateException("not in database");
    }


  }

  @Override
  public CustomerDTO getCustomerById(int id) {

    Optional<Customer> customer=customerRepo.findById(id);
    if(customer.isPresent()){
//      CustomerDTO customerDTO=new CustomerDTO(
//
//              customer.get().getCustomerId(),
//              customer.get().getCustomerName(),
//              customer.get().getCustomerAddress(),
//              customer.get().getCustomerSalary(),
//              customer.get().getContactNumber(),
//              customer.get().getNic(),
//              customer.get().isActiveState()
//      );
//      return customerDTO;
//      CustomerDTO customerDTO=modelMapper.map(customer.get(),CustomerDTO.class);

      CustomerDTO customerDTO=customerMapper.entityToDto(customer.get());
      return customerDTO;
    }else{
      return null;
    }

  }

  @Override








  public List<CustomerDTO> getAllCustomers() {

    List<Customer>getCustomers=customerRepo.findAll();
    List<CustomerDTO>customerDTOList=new ArrayList<>();
//    for (Customer c:getCustomers) {
//             CustomerDTO customerDTO=new CustomerDTO(
//                     c.getCustomerId(),
//                     c.getCustomerName(),
//                     c.getCustomerAddress(),
//                     c.getCustomerSalary(),
//                     c.getContactNumber(),
//                     c.getNic(),
//                     c.isActiveState()
//             );
//      customerDTOList.add(customerDTO);
//    }

    List<CustomerDTO>customerDTOS=modelMapper
            .map(getCustomers,new TypeToken<List<CustomerDTO>>(){}.getType());

    return customerDTOS;
  }

  @Override
  public boolean deleteCustomer(int id) throws NotFoundException {
    if(customerRepo.existsById(id)){
      customerRepo.deleteById(id);
    }else{
      throw new NotFoundException("not found customer for this is");
    }
    return true;
  }

  @Override
  public List<CustomerDTO> getByName(String customerName) throws NotFoundException {
    List<Customer>customers=customerRepo.findAllByCustomerNameEquals(customerName);
    if(customers.size()!=0){
      List<CustomerDTO>customerDTOS=modelMapper
              .map(customers,new TypeToken<List<CustomerDTO>>(){}.getType());
      return customerDTOS;
    }else{
      throw new NotFoundException("No result");
    }
  }

  @Override
  public List<CustomerDTO> getAllCustomersByActiveState() throws NotFoundException {
    boolean b=true;
    List<Customer>customers=customerRepo.findAllByActiveStateEquals(true);

    if (customers.size()!=0){
      List<CustomerDTO>customerDTOS=customerMapper.entityListToDtoList(customers);
      return customerDTOS;
    }else{
      throw new NotFoundException("No active customers found");
    }



  }

  @Override
  public List<ResponseActiveCustomerDTO> getAllCustomersByActiveStateOnlyName() throws NotFoundException {
    List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);

    if (customers.size() != 0) {
      List<ResponseActiveCustomerDTO> customerDTOS = customerMapper.entityListToDtoListOnlyName(customers);
      return customerDTOS;
    } else {
      throw new NotFoundException("No active customers found");
    }
  }

  @Override
  public String updateCustomerByQuery(CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO, int id) {
    if(customerRepo.existsById(id)){
         customerRepo.updateCustomerByQuery(customerUpdateQueryRequestDTO.getCustomerName(),
                 customerUpdateQueryRequestDTO.getNic(),
                 id
                 );
      return "Updated Successfull id "+id;
    }else{
      System.out.println("No customer found for this id"+id);
      return "no customer found for this id"+id;
    }

  }

  @Override
  public CustomerDTO getCustomerByNic(String nic) {
    Optional<Customer> customer=customerRepo.findAllByNicEquals(nic);
    if(customer.isPresent()){
      CustomerDTO customerDTO=modelMapper.map(customer.get(),CustomerDTO.class);
      return customerDTO;
    }else{
       throw new com.springbootacademy.pointofsale.exception.NotFoundException("not found");
    }

  }

  @Override
  public ResponseCustomerFilterDTO getCustomerByFilter(int id) {
    Optional<Customer> customer=customerRepo.findById(id);
    if(customer.isPresent()){
      ResponseCustomerFilterDTO responseCustomerFilterDTO=customerMapper.entityToResponseDto(customer.get());
     return responseCustomerFilterDTO;
    }else{
      throw new EntryNotFoundException("Not found customer");
    }
  }

  @Override
  public String updateCustomerByRequest(CustomerUpdateByDto customerUpdateByDto, int id) {

    if(customerRepo.existsById(id)){

      Customer customer = customerRepo.getById(id);
      customer.setCustomerName(customerUpdateByDto.getCustomerName());
      customer.setCustomerSalary(customerUpdateByDto.getCustomerSalary());
      customer.setNic(customerUpdateByDto.getNic());


      return customerRepo.save(customer).getCustomerName()+"Updated success" +id;

    }else{
      throw new EntryDuplicateException("not in database");
    }
  }

  @Override
  public CustomerDTO getCustomerByIDIsActive(int id) {
    Optional<Customer> customer=customerRepo.findById(id);
    if(customer.isPresent()){
        if(customer.get().isActiveState()){
          CustomerDTO customerDTO=modelMapper.map(customer.get(),CustomerDTO.class);
          return  customerDTO;
        }else {
          System.out.println("This is inactive customer");
        }
    }else{
      throw new com.springbootacademy.pointofsale.exception.NotFoundException("Not found customer");
    }
    return null;
  }

}
