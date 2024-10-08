package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "contct_contact")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Contact extends BackboneElement{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cc_contct_id", referencedColumnName = "id")
    private CodeableConcept purpose;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="hn_contct_id", referencedColumnName = "id")
    private HumanName name;
}

