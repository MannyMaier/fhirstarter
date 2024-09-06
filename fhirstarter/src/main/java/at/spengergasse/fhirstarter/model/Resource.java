package at.spengergasse.fhirstarter.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


//@MappedSuperclass -> Die Id wird in den erbenden Klassen gemappt; Es wird keine Tabelle Resource erstellt
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class Resource {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
}
