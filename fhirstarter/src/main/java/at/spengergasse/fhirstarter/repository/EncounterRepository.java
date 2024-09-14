package at.spengergasse.fhirstarter.repository;

import at.spengergasse.fhirstarter.entity.Encounter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends CrudRepository<Encounter, String> {
}
