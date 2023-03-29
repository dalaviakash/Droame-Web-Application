package org.jspider.DromeWebProject.service;

import org.jspider.DromeWebProject.model.Booking;
import org.jspider.DromeWebProject.model.Customer;
import org.jspider.DromeWebProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository repository;



    public void addCustomer(Customer c) {
        repository.save(c);

    }

    public void addCustomerDetails(Customer c) {
        repository.save(c);
    }

    public List<Customer> getAllCustomerInfo() {
        List<Customer> customerList = repository.findAll();
        return customerList;
    }

    public Customer showupdateCustomer(int id) {

        return repository.findById(id).get();

    }

    public Customer modifyCustomer(Customer c) {


       return repository.save(c);
    }

    public void deleteCustomer(int id){
         repository.deleteById(id);

    }


}


