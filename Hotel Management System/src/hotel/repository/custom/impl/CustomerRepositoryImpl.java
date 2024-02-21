/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.repository.custom.impl;

import hotel.dto.CustomerDto;
import hotel.entity.CustomerEntity;
import hotel.repository.CrudUtil;
import hotel.repository.custom.CustomerRepository;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public boolean save(CustomerEntity t) throws Exception {
     return CrudUtil.executeUpdate("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?)",
                t.getCustID(),
                t.getCustTitle(),
                t.getCustName(),
                t.getNIC(),
                t.getDOB(),
                t.getMobileNumber(),
                t.getCustAddress(),
                t.getCity(),
                t.getProvince(),
                t.getPostalCode()
        );
    }

    @Override
    public boolean update(CustomerEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(CustomerEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CustomerEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
