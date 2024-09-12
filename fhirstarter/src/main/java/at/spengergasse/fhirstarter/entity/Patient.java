package at.spengergasse.fhirstarter.entity;

import at.spengergasse.fhirstarter.model.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pa_patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Patient extends DomainResource {

    //TODO: at_attachement hat keinen Schlüssel zu Patient


    //diese Spalte wird in id_identifier erzeugt (obwohls hier geschrieben wird)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pa_id")
    private List<Identifier> identifier = new ArrayList<>();


    @Column(name = "pa_active")
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hn_pa_id")
    private List<HumanName> name = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_pa_id")
    private List<ContactPoint> telecom = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "pa_gender")
    private GenderCode gender;

    @Column(name = "pa_birthdate")
    private LocalDate birthDate;

    @Column(name= "pa_deceasedboolean")
    private Boolean deceasedBoolean;

    @Column(name="pa_deceaseddatetime")
    private LocalDateTime deceasedDateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ad_pa_id")
    private List<Address> address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "at_pa_id")
    private List<Attachment> photo;

    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name = "re_pa_id")
    private List<Reference> generalPractitioner;
}
