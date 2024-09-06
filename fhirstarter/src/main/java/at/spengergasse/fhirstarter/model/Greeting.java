package at.spengergasse.fhirstarter.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "g_greeting")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private long l;
    private String format;

}
