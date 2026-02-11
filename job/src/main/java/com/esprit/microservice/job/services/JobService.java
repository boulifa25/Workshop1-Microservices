package com.esprit.microservice.job.services;

import com.esprit.microservice.job.entities.Job;
import com.esprit.microservice.job.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository repo;

    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public List<Job> findAll() {
        return repo.findAll();
    }

    public Job findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<Job> findByService(String service) {
        return repo.findByServiceContainingIgnoreCase(service);
    }

    public Job save(Job job) {
        return repo.save(job);
    }

    public Job updateEtat(Integer id, Boolean etat) {
        Job job = repo.findById(id).orElse(null);
        if (job == null) return null;
        job.setEtat(etat);
        return repo.save(job);
    }
}
