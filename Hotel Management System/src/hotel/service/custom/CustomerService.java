/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.service.custom;

import hotel.dto.CustomerDto;
import hotel.service.SuperService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public interface CustomerService extends SuperService {

    String saveCustomer(CustomerDto customerDto) throws Exception;

    String updateCustomer(CustomerDto customerDto) throws Exception;

    String deleteCustomer(CustomerDto customerDto) throws Exception;

    CustomerDto getCustomer(String id) throws Exception;

    List<CustomerDto> getAll() throws Exception;
}
