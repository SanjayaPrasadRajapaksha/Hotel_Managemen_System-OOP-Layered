/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.service.custom.impl;

import hotel.dto.CustomerDto;
import hotel.entity.CustomerEntity;
import hotel.repository.RepositoryFactory;
import hotel.repository.custom.CustomerRepository;
import hotel.service.custom.CustomerService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = (CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.CUSTOMER);

    @Override
    public String saveCustomer(CustomerDto customerDto) throws Exception {
        if (customerRepository.save(new CustomerEntity(customerDto.getCustID(), customerDto.getCustTitle(), customerDto.getCustName(), customerDto.getNIC(), customerDto.getDOB(), customerDto.getMobileNumber(), customerDto.getCustAddress(), customerDto.getCity(), customerDto.getProvince(), customerDto.getPostalCode()))) {
            return "SuccessFully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateCustomer(CustomerDto customerDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String deleteCustomer(CustomerDto customerDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CustomerDto getCustomer(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CustomerDto> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
