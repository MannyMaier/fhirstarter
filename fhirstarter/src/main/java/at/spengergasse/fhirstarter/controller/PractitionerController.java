package at.spengergasse.fhirstarter.controller;

import at.spengergasse.fhirstarter.entity.Practitioner;
import at.spengergasse.fhirstarter.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/api/practitioner")
@CrossOrigin(origins = "http://localhost:4200")
public class PractitionerController {

    @Autowired
    PractitionerRepository practitionerRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<Practitioner> getAllPractitioners() {
        return practitionerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practitioner> getPractitioner(@PathVariable String id) {
        return practitionerRepository.findById(id)
                .map(practitioner -> ResponseEntity.ok().body(practitioner))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Practitioner> createPractitioner(@Validated @RequestBody Practitioner practitioner) {
        practitioner.setId(null);
        var saved = practitionerRepository.save(practitioner);
        return ResponseEntity.created(URI.create("/api/practitioner/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practitioner> updatePractitioner(@PathVariable(value = "id") String practitionerId,
                                                           @RequestBody Practitioner practitionerDetails) {
        return practitionerRepository.findById(practitionerId).map(practitioner -> {
            practitioner.setActive(practitionerDetails.getActive());
            practitioner.setGender(practitionerDetails.getGender());
            practitioner.setName(practitionerDetails.getName());
            practitioner.setTelecom(practitionerDetails.getTelecom());
            practitioner.setBirthDate(practitionerDetails.getBirthDate());
            practitioner.setAddress(practitionerDetails.getAddress());
            practitioner.setPhoto(practitionerDetails.getPhoto());
            practitioner.setQualification(practitionerDetails.getQualification());
            practitioner.setCommunication(practitionerDetails.getCommunication());
            practitioner.setIdentifier(practitionerDetails.getIdentifier());

            Practitioner updatedPractitioner = practitionerRepository.save(practitioner);
            return ResponseEntity.ok(updatedPractitioner);
        }).orElseGet(() -> createPractitioner(practitionerDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePractitioner(@PathVariable(value = "id") String practitionerId) {
        return practitionerRepository.findById(practitionerId).map(practitioner -> {
            practitionerRepository.delete(practitioner);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

