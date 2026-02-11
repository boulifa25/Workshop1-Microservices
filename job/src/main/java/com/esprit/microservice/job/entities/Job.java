package com.esprit.microservice.job.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String service;   // nom du job / service

    private Boolean etat;     // true = disponible, false = occupé
}
