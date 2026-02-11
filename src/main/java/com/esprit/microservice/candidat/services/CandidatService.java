package com.esprit.microservice.candidat.services;

import com.esprit.microservice.candidat.entities.Candidat;
import com.esprit.microservice.candidat.repositories.CandidatRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    private final CandidatRepository candidatRepository;

    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    public Candidat addCandidat(Candidat c) {
        return candidatRepository.save(c);
    }

    public Candidat updateCandidat(int id, Candidat newC) {
        return candidatRepository.findById(id).map(old -> {
            old.setNom(newC.getNom());
            old.setPrenom(newC.getPrenom());
            old.setEmail(newC.getEmail());
            return candidatRepository.save(old);
        }).orElse(null);
    }

    public String deleteCandidat(int id) {
        if (candidatRepository.existsById(id)) {
            candidatRepository.deleteById(id);
            return "candidat supprimé";
        }
        return "candidat non supprimé";
    }
}
