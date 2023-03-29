package org.jspider.DromeWebProject.service;

import org.jspider.DromeWebProject.model.Booking;
import org.jspider.DromeWebProject.model.Customer;
import org.jspider.DromeWebProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServices {

    @Autowired
    private BookingRepository repository;
    //bokking data

    public void addBooking(Booking b){
        repository.save(b);
    }

    public void addBookingDetails(Booking b){
        repository.save(b);
    }

    public List<Booking> getAllBookingInfo() {
        List<Booking> bookingList = repository.findAll();
        return bookingList;
    }
      public Booking showupdateBooking(int id) {

        return repository.findById(id).get();

    }

    public Booking modifyBooking(Booking b) {


        return repository.save(b);
    }

    public void deleteBooking(int id){
        repository.deleteById(id);

    }




}
