package at.spengergasse.fhirstarter.controller;

import at.spengergasse.fhirstarter.model.Contract;
import at.spengergasse.fhirstarter.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/api/contract")
@CrossOrigin(origins = "http://localhost:4200")
public class ContractController {

    @Autowired
    ContractRepository contractRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContract(@PathVariable String id) {
        return contractRepository.findById(id)
                .map(contract -> ResponseEntity.ok().body(contract))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Contract> createContract(@Validated @RequestBody Contract contract) {
        contract.setId(null);
        var saved = contractRepository.save(contract);
        return ResponseEntity.created(URI.create("/api/contract/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable(value = "id") String contractId,
                                                           @RequestBody Contract contractDetails) {
        return contractRepository.findById(contractId).map(contract -> {

            contract.setIdentifier(contractDetails.getIdentifier());
            contract.setVersion(contractDetails.getVersion());
            contract.setCode(contractDetails.getCode());
            contract.setContentDefinition(contractDetails.getContentDefinition());

            Contract updatedContract = contractRepository.save(contract);
            return ResponseEntity.ok(updatedContract);
        }).orElseGet(() -> createContract(contractDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContract(@PathVariable(value = "id") String contractId) {
        return contractRepository.findById(contractId).map(contract -> {
            contractRepository.delete(contract);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
