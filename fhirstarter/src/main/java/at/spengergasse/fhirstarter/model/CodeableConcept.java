package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cc_codeableconcept")
@Builder
public class CodeableConcept extends Element {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "co_cc_id")
    private List<Coding> coding = new ArrayList<>();

    @Column(name = "cc_text")
    private String text;
}

