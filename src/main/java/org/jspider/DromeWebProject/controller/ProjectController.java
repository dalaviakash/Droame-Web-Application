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

@Controller
public class ProjectController {
    List<Customer>customerList=new ArrayList<>();

    @Autowired
    private CustomerServices services;


@GetMapping("/welcome")
    public String get(){
    return "welcome";
}
@GetMapping("/addcustomerform")
public String addCustomer(Model model){
    model.addAttribute("customer",new Customer());
     return "addcustomerform";
}

    @PostMapping("/insertdata")
    public String addCustomerDetails(Customer c){
    services.addCustomerDetails(c);
    return "inserted";
    }

    @GetMapping("/inserted")
    public String insertedSuccessfull(){
    return "inserted";
    }


   @GetMapping("/admin")
    public String getAllcustomerInfo(Model model){
    model.addAttribute("records",services.getAllCustomerInfo());

    return "customerlist";
   }
@GetMapping("/updatecustomer/{id}")
   public String showupdateCustomer(@PathVariable(value = "id")int id, Model model){

           model.addAttribute("records",services.showupdateCustomer(id));
           return "updatecustomer";
   }
@PostMapping("/modify/{id}")
   public String modifyCustomer(@PathVariable int id, @ModelAttribute("records") Customer c,Model model){
    Customer customer=services.showupdateCustomer(id);
    customer.setCustomerId(id);
    customer.setCustomerName(c.getCustomerName());
    customer.setEmail(c.getEmail());
    customer.setPhoneNumber(c.getPhoneNumber());
    services.modifyCustomer(customer);
    return "redirect:/admin";
   }
@GetMapping("/delete/{id}")
   public String deleteCustomer(@PathVariable(value = "id")int id){
   services.deleteCustomer(id);
   return "redirect:/admin";
   }




}
