package at.spengergasse.fhirstarter.entity;

import at.spengergasse.fhirstarter.model.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pr_practitioner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Practitioner extends DomainResource {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pr_id", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<Identifier>();


    @Column(name = "pr_active")
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="hn_pr_id",nullable = true, referencedColumnName = "id")
    private List<HumanName> name = new ArrayList<HumanName>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cp_pr_id", referencedColumnName = "id")
    private List<ContactPoint> telecom = new ArrayList<ContactPoint>();

    @Enumerated(EnumType.STRING)
    @Column(name = "pr_gender")
    private GenderCode gender;

    @Column(name = "pr_birthdate")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "ad_pr_id", referencedColumnName = "id")
    private List<Address> address = new ArrayList<Address>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="at_pr_id", referencedColumnName = "id")
    private List<Attachment> photo = new ArrayList<Attachment>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "qu_pr_id", referencedColumnName = "id")
    private List<Qualification> qualification = new ArrayList<Qualification>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="com_pr_id")
    private List<Communication> communication = new ArrayList<>();

}
