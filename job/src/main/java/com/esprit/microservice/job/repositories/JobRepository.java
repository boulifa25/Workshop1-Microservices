package com.esprit.microservice.job.repositories;

import com.esprit.microservice.job.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findByServiceContainingIgnoreCase(String service);
}
