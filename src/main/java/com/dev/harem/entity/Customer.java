package com.dev.harem.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();
    public Customer() {

    }
    public Customer(Long id, String firstName,String lastName, String email,String phoneNumber){
        this.id = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
