package java.practice.royalmarket.application.service;

import java.practice.royalmarket.domain.dto.CustomerDTO;
import java.util.List;

public interface ICustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(long customerId);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO modifyCustomer(CustomerDTO customerDTO);

    void deleteCustomer(long customerId);

}
