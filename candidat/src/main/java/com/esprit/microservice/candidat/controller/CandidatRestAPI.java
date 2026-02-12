package com.esprit.microservice.candidat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.microservice.candidat.entities.Candidat;
import com.esprit.microservice.candidat.services.CandidatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/candidats")
public class CandidatRestAPI {

    private final CandidatService candidatService;

    public CandidatRestAPI(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, i'm the candidate Micro-Service";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> create(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> update(@PathVariable int id, @RequestBody Candidat candidat) {
        Candidat updated = candidatService.updateCandidat(id, candidat);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return new ResponseEntity<>(candidatService.deleteCandidat(id), HttpStatus.OK);
    }
}
