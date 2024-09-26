package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "re_reference")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reference extends Element{

    @Column(name="re_reference")
    private  String reference;

    @Column(name="re_type")
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "re_id_identifier")
    private Identifier identifier;

    @Column(name="re_display")
    private String display;
}
