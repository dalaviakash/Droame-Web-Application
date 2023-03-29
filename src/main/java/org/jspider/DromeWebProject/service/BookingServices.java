package org.jspider.DromeWebProject.service;

import org.jspider.DromeWebProject.model.Booking;
import org.jspider.DromeWebProject.model.Customer;
import org.jspider.DromeWebProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //this annotation is used service layer to show this page is not a simple page
public class BookingServices {

    @Autowired
    private BookingRepository repository;
    //bokking data

    ////this method is created to add booking
    public void addBooking(Booking b){
        repository.save(b);
    }

    //this method is created to add all data
    public void addBookingDetails(Booking b){
        repository.save(b);
    }

    //this method is created to get all data
    public List<Booking> getAllBookingInfo() {
        List<Booking> bookingList = repository.findAll();
        return bookingList;
    }

    //this method is created to show all update data
      public Booking showupdateBooking(int id) {

        return repository.findById(id).get();

    }

    //this method is created to modify data to save
    public Booking modifyBooking(Booking b) {


        return repository.save(b);
    }


    //this method is created to delete data
    public void deleteBooking(int id){
        repository.deleteById(id);

    }




}
