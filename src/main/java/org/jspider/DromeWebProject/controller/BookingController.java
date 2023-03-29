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

    @GetMapping("/bookingform")
    public String addBooking(Model model){
        model.addAttribute("booking",new Booking());
        return "bookingform";

    }
     @PostMapping("/insertbooking")
    public String addBookingDetails(Booking b){
        services.addBookingDetails(b);
        return "redirect:/bookingform";

    }

    @GetMapping("/booked")
    public String getAllBookingInfo(Model model){
        model.addAttribute("record",services.getAllBookingInfo());

        return "bookinglist";
    }

    @GetMapping("/updatebooking/{id}")
    public String showupdateBooking(@PathVariable(value = "id")int id, Model model){

        model.addAttribute("record",services.showupdateBooking(id));
        return "updatebooking";
    }
    @PostMapping("/modifybooking/{id}")
    public String modifyBooking(@PathVariable int id, @ModelAttribute("record") Booking b, Model model){
        Booking booking=services.showupdateBooking(id);
        booking.setBookingId(id);
        booking.setLocationId(b.getLocationId());
        booking.setDroneShotId(b.getDroneShotId());
        booking.setCreatedTime(b.getCreatedTime());
        services.modifyBooking(booking);
        return "redirect:/booked";
    }
    @GetMapping("/deletebooking/{id}")
    public String deleteBooking(@PathVariable(value = "id")int id){
        services.deleteBooking(id);
        return "redirect:/booked";
    }



}
