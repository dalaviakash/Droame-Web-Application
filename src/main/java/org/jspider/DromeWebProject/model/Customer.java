package org.jspider.DromeWebProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer_info")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation is used for generate primary key automatically
    @Column(name ="customer_id" )
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name ="email" )
    private String email;
    @Column(name ="phone_number" )
    private long phoneNumber;
}
