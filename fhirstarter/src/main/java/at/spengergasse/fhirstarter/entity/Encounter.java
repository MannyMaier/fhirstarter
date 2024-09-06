package at.spengergasse.fhirstarter.entity;

import at.spengergasse.fhirstarter.model.DomainResource;
import at.spengergasse.fhirstarter.model.Identifier;
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
}
