package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "di_diagnosis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Diagnosis extends BackboneElement{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "di_condition_re_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Reference condition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cc_di_id")
    private CodeableConcept use;

    //Nur positive Werte erlaubt
    @Column(name = "di_rank", columnDefinition = "integer CHECK (di_rank >= 0)")
    private Integer rank;
}
