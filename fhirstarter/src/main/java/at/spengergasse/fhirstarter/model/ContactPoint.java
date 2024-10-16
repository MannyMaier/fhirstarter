package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "cp_contactpoint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactPoint extends Element {
    public enum SystemCode {phone, fax, email, pager, url, sms, other}

    @Enumerated(EnumType.STRING)
    @Column(name = "cp_systemcode")
    private SystemCode system;

    @Column(name = "cp_value")
    private String value;

    public enum ContactKind {home, work, temp, old, mobile}
    @Enumerated(EnumType.STRING)
    @Column(name = "cp_contactkind")
    private ContactKind use;

    @Min(1)
    @Column(name = "cp_rank")
    private Integer rank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_pe_id")
    private Period period;
}
