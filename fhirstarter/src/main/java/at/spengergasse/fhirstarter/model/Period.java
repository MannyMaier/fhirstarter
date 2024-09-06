package at.spengergasse.fhirstarter.model;

import jakarta.persistence.*;
import lombok.*;

import java.rmi.server.UID;
import java.time.LocalDateTime;

@Entity
@Table(name = "pe_period")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Period extends Element {

    @Column(name = "pe_start")
    private LocalDateTime start;

    @Column(name = "pe_end")
    private LocalDateTime end;
}
