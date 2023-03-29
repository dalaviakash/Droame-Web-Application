package org.jspider.DromeWebProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "booking_info")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is used to generate primary key auromatically
    @Column(name = "booking_id")
    private int BookingId;
    @Column(name = "location_id")
    private long locationId;
    @Column(name = "drone_shot_id")
    private String droneShotId;
    @Column(name = "created_time")
    private String createdTime;
}
