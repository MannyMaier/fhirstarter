package at.spengergasse.fhirstarter.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "com_communication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Communication extends BackboneElement{

    @OneToOne
    @JoinColumn(name = "com_language")
    private CodeableConcept language;

    @Column(name = "com_preferred")
    private Boolean preferred;
}
