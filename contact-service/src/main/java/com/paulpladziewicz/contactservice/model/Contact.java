package com.paulpladziewicz.contactservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(unique = true, length = 150)
    private String email;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @Column(name = "linkedin_url", length = 255)
    private String linkedInUrl;

    @Column(columnDefinition = "TEXT")
    private String details;

    @Column(name = "last_contacted")
    private LocalDateTime lastContacted;
}
