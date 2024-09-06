package at.spengergasse.fhirstarter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "at_at1plf")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class At1PLF {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "at_id")
    private String id;

    @Column(name = "at_size")
    private Integer size;

    @Column(name = "at_title")
    private String title;

    @Column(name = "at_creation")
    private LocalDateTime creation;
}
