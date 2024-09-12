package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class Element  {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name = "id")
    private String id;

}
