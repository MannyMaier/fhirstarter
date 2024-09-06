package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "id_identifier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Identifier extends Element{

    public enum IdentifierUseCode{usual, official, temp, secondary, old}

    @Enumerated(EnumType.STRING)
    @Column(name = "id_use")
    private IdentifierUseCode use;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cc_id")
    private CodeableConcept type;

    @Column(name="id_system")
    private String system;

    @Column(name="id_value")
    private String value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pe_id", referencedColumnName = "id")
    private Period period;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_re_id", referencedColumnName = "id")
    private Reference assigner;
}
