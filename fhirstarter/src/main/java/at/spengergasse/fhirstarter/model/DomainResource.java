package at.spengergasse.fhirstarter.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class DomainResource extends Resource{

    //CascadeType.All -> wenn die DomainResource gelöscht wird, dann auch das Narrative
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dr_na_id")
    private Narrative text;
}
