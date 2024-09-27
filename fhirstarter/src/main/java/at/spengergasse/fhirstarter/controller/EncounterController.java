package at.spengergasse.fhirstarter.controller;

import at.spengergasse.fhirstarter.entity.Encounter;
import at.spengergasse.fhirstarter.repository.EncounterRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/encounter")
public class EncounterController {

    @Autowired
    private EncounterRepository encounterRepository;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/")
    public Iterable<Encounter> getAllEncounters() {
        return encounterRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encounter> getEncounterById(@PathVariable String id) {
        Optional<Encounter> encounter = encounterRepository.findById(id);
        return encounter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Encounter> createEncounter(@Validated @RequestBody Encounter encounter) {
        encounter.setId(null); // ensure to create new names
        var saved = encounterRepository.save(encounter);
        return ResponseEntity.created(URI.create("/api/encounters/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Encounter> updateEncounter(@PathVariable(value = "id") String encounterId, @RequestBody Encounter encounterDetails) {
        return encounterRepository.findById(encounterId).map(encounter -> {
            encounter.setIdentifiers(encounterDetails.getIdentifiers());
            encounter.setStatus(encounterDetails.getStatus());
            encounter.setStatusHistory(encounterDetails.getStatusHistory());
            encounter.setType(encounterDetails.getType());
            encounter.setSubject(encounterDetails.getSubject());
            encounter.setEpisodeOfCare(encounterDetails.getEpisodeOfCare());
            encounter.setAppointment(encounterDetails.getAppointment());
            encounter.setPeriod(encounterDetails.getPeriod());
            encounter.setReasonReference(encounterDetails.getReasonReference());
            encounter.setPartOf(encounterDetails.getPartOf());
            encounter.setParticipant(encounterDetails.getParticipant());
            encounter.setDiagnosis(encounterDetails.getDiagnosis());

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            Encounter updatedEncounter = encounterRepository.save(encounter);

            transaction.commit();

            return ResponseEntity.ok(updatedEncounter);
        }).orElseGet(() -> createEncounter(encounterDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncounter(@PathVariable String id) {
        Optional<Encounter> encounter = encounterRepository.findById(id);
        if (encounter.isPresent()) {
            encounterRepository.delete(encounter.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
