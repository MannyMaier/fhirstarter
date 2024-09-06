package at.spengergasse.fhirstarter.repository;

import at.spengergasse.fhirstarter.model.Contract;
import org.springframework.data.repository.ListCrudRepository;

public interface ContractRepository extends ListCrudRepository<Contract, String> {
}
