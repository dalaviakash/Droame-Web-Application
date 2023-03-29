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

    ////this method is created to add booking

    public void addCustomer(Customer c) {
        repository.save(c);

    }

    //this method is created to add all data
    public void addCustomerDetails(Customer c) {
        repository.save(c);
    }


    //this method is created to get all data
    public List<Customer> getAllCustomerInfo() {
        List<Customer> customerList = repository.findAll();
        return customerList;
    }

    //this method is created to show all update data
    public Customer showupdateCustomer(int id) {

        return repository.findById(id).get();

    }


    //this method is created to modify data to save
    public Customer modifyCustomer(Customer c) {


       return repository.save(c);
    }


    //this method is created to delete data
    public void deleteCustomer(int id){
         repository.deleteById(id);

    }


}


