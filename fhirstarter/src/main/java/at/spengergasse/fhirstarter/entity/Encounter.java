package at.spengergasse.fhirstarter.entity;

import at.spengergasse.fhirstarter.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "en_encounter")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Encounter extends DomainResource {

    public enum Statuscode {planned, arrived, triaged, @JsonProperty("in-progress") in_progress, onleave, finished, cancelled};


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "en_id_identifier")
    private List<Identifier> identifiers = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "en_status")
    private Statuscode status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sh_en_id")
    private List<StatusHistory> statusHistory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cc_en_id")
    private List<CodeableConcept> type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "en_subject_re_id", referencedColumnName = "id")
    private Reference subject;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "en_episodeofcare_re_id", referencedColumnName = "id")
    private Reference episodeOfCare;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "en_appointment_re_id", referencedColumnName = "id")
    private Reference appointment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "en_pe_id")
    private Period period;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "en_reasonreference_re_id", referencedColumnName = "id")
    private Reference reasonReference;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "en_partof_re_id", referencedColumnName = "id")
    private Reference partOf;
}
