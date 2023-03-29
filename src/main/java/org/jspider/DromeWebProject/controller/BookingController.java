package org.jspider.DromeWebProject.controller;

import org.jspider.DromeWebProject.model.Booking;
import org.jspider.DromeWebProject.model.Customer;
import org.jspider.DromeWebProject.service.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class BookingController {
    List<Booking> bookingList=new ArrayList<>();

    @Autowired
    private BookingServices services;

    ////this method is created to add booking data
    @GetMapping("/bookingform")
    public String addBooking(Model model){
        model.addAttribute("booking",new Booking());
        return "bookingform";

    }

    //this method is created to insert data
     @PostMapping("/insertbooking")
    public String addBookingDetails(Booking b){
        services.addBookingDetails(b);
        return "redirect:/bookingform";

    }

    //this method is created to get all booked data
    @GetMapping("/booked")
    public String getAllBookingInfo(Model model){
        model.addAttribute("record",services.getAllBookingInfo());

        return "bookinglist";
    }

    //this method is created to get data for update
    @GetMapping("/updatebooking/{id}")
    public String showupdateBooking(@PathVariable(value = "id")int id, Model model){

        model.addAttribute("record",services.showupdateBooking(id));
        return "updatebooking";
    }

    //this method is created to updated data store
    @PostMapping("/modifybooking/{id}") //pathvariable anotation is used to pass id on url
    public String modifyBooking(@PathVariable int id, @ModelAttribute("record") Booking b, Model model){
        Booking booking=services.showupdateBooking(id);
        booking.setBookingId(id);
        booking.setLocationId(b.getLocationId());
        booking.setDroneShotId(b.getDroneShotId());
        booking.setCreatedTime(b.getCreatedTime());
        services.modifyBooking(booking);
        return "redirect:/booked";
    }

    //this method is created to delete the data
    @GetMapping("/deletebooking/{id}")
    public String deleteBooking(@PathVariable(value = "id")int id){
        services.deleteBooking(id);
        return "redirect:/booked";
    }



}
