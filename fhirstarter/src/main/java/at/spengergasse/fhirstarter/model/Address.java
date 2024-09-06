package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ad_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends Element{
    public enum UseCode {home, work, temp, old, billing}
    @Enumerated(EnumType.STRING)
    @Column(name = "ad_usecode")
    private UseCode use;

    public enum TypeCode {postal, physical, both}
    @Enumerated(EnumType.STRING)
    @Column(name = "ad_typecode")
    private TypeCode type;

    @Column(name = "ad_text")
    private String text;

    @ElementCollection
    @CollectionTable(name = "ad_line")
    private List<String> line = new ArrayList<>();

    @Column(name = "ad_city")
    private String city;

    @Column(name = "ad_district")
    private String district;

    @Column(name = "ad_state")
    private String state;

    @Column(name = "ad_postalCode")
    private String postalCode;

    @Column(name = "ad_country")
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ad_pe_id")
    private Period period;
}
