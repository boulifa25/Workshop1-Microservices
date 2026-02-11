package com.esprit.microservice.job.controllers;

import com.esprit.microservice.job.entities.Job;
import com.esprit.microservice.job.services.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    // Afficher tous les jobs
    @GetMapping
    public List<Job> all() {
        return service.findAll();
    }

    // Afficher job par id
    @GetMapping("/{id}")
    public Job byId(@PathVariable Integer id) {
        return service.findById(id);
    }

    // Afficher job par nom (service)
    @GetMapping("/search")
    public List<Job> byService(@RequestParam String serviceName) {
        return service.findByService(serviceName);
    }

    // Ajouter un job
    @PostMapping
    public Job add(@RequestBody Job job) {
        return service.save(job);
    }

    // Modifier l'état (disponible/occupé)
    @PutMapping("/{id}/etat")
    public Job updateEtat(@PathVariable Integer id, @RequestParam Boolean value) {
        return service.updateEtat(id, value);
    }
}
