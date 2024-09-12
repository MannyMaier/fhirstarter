package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "qu_qualification")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Qualification extends BackboneElement{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_qu_id", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<Identifier>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="qu_cc_id")
    @NonNull
    private CodeableConcept code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qu_pe_id")
    private Period period;
}
