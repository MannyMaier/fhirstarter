package at.spengergasse.fhirstarter.model;

import ch.qos.logback.classic.joran.action.ContextNameAction;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "hn_human_name")
@Builder
public class HumanName extends Element {
    public enum StatusCode {usual, official, temp, nickname, anonymus, old, maiden}

    @Enumerated(EnumType.STRING)
    @Column(name = "hn_use")
    private StatusCode use;

    @Column(name = "hn_text")
    private String text;

    @Column(name = "hn_family")
    private String family;

    @ElementCollection
    @CollectionTable(name = "hn_gi_given")
    private List<String> given = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "hn_pf_prefix")
    private List<String> prefix = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "hn_sf_suffix")
    private List<String> suffix = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hn_pe_id")
    private Period period;
}
