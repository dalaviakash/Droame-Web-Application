package org.jspider.DromeWebProject.controller;


import org.jspider.DromeWebProject.model.Booking;
import org.jspider.DromeWebProject.model.Customer;
import org.jspider.DromeWebProject.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller  //this Annotation is used to request froword by front controller
public class ProjectController {

    //created list to store data
    List<Customer>customerList=new ArrayList<>();

    @Autowired  // this Annotation is used to inject the dependancy
    private CustomerServices services;

//this method is created to get landind page
    @GetMapping("/welcome") // this annotation is used to get data
    public String get(){
    return "welcome";
}


    //this method is created to add data
   @GetMapping("/addcustomerform")
    public String addCustomer(Model model){
    model.addAttribute("customer",new Customer());
     return "addcustomerform";
}

    //this method is created to added data inserted into database
    @PostMapping("/insertdata")
    public String addCustomerDetails(Customer c){
    services.addCustomerDetails(c);
    return "inserted";
    }

    //this method is created to showing message
    @GetMapping("/inserted")
    public String insertedSuccessfull(){
    return "inserted";
    }


    //this method is created to get all information from database
   @GetMapping("/admin")
    public String getAllcustomerInfo(Model model){
    model.addAttribute("records",services.getAllCustomerInfo());

    return "customerlist";
   }

    //this method is created to grt data to first form for update
     @GetMapping("/updatecustomer/{id}")
      public String showupdateCustomer(@PathVariable(value = "id")int id, Model model){

           model.addAttribute("records",services.showupdateCustomer(id));
           return "updatecustomer";
   }

    //this method is created to modify data to save
@PostMapping("/modify/{id}") //this anotation is used insert data
   public String modifyCustomer(@PathVariable int id, @ModelAttribute("records") Customer c,Model model){
    Customer customer=services.showupdateCustomer(id);
    customer.setCustomerId(id);
    customer.setCustomerName(c.getCustomerName());
    customer.setEmail(c.getEmail());
    customer.setPhoneNumber(c.getPhoneNumber());
    services.modifyCustomer(customer);
    return "redirect:/admin";
   }


    //this method is created to delete data from database
@GetMapping("/delete/{id}")
   public String deleteCustomer(@PathVariable(value = "id")int id){
   services.deleteCustomer(id);
   return "redirect:/admin";
   }




}
