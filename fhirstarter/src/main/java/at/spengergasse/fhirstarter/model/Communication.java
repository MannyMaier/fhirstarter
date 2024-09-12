package at.spengergasse.fhirstarter.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "com_communication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Communication extends BackboneElement{

    @OneToOne
    @JoinColumn(name = "com_language")
    private CodeableConcept language;

    @Column(name = "com_preferred")
    private Boolean preferred;
}
