package at.spengergasse.fhirstarter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;



@Entity
@Table(name = "sh_statushistory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class StatusHistory extends BackboneElement {

    public enum Statuscode {planned, arrived, triaged, @JsonProperty("in-progress") in_progress, onleave, finished, cancelled};

    @Enumerated(EnumType.STRING)
    @Column(name = "sh_status", nullable = false)
    private Statuscode status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sh_pe_id", nullable = false)
    @NotNull
    private Period period;
}
