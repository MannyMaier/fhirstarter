package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "na_narrative")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Narrative extends Element{
    public enum NarrativeStatusCode {generated, extensions, additional, empty}

    @Enumerated(EnumType.STRING)
    @Column(name = "na_status")
    private NarrativeStatusCode status;

    @Column(name = "na_div", length = 5000)
    private String div;
}
