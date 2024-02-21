/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.dto.CustomerDto;
import hotel.service.ServiceFactory;
import hotel.service.custom.CustomerService;

/**
 *
 * @author Sanjaya
 */
public class CustomerController {

    private CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    public String saveCustomer(CustomerDto customerDto) throws Exception {
     return customerService.saveCustomer(customerDto);
    }
    
    
}
