package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.entity.Practitioner;
import at.spengergasse.fhirstarter.model.GenderCode;
import at.spengergasse.fhirstarter.repository.PractitionerRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PractitionerRepositoryTestv2 {

    //TODO:nein, fertiggestellt PractitionerControllerTest als nächstes

    @Autowired
    PractitionerRepository practitionerRepository;
    @Autowired
    ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    @Autowired
    private ResourceLoader resourceLoader;

    public static Practitioner returnOnePractitionerJSON(ResourceLoader resourceLoader, ObjectMapper om) {
        String json = "";
        Practitioner p = null;
        //OM Configure
        try {
            File dataFile =
                    resourceLoader.getResource("classpath:Practitioner.json").getFile();
            System.out.println("File exists" + dataFile.exists());
            p = om.readValue(dataFile, Practitioner.class);
        } catch (Exception e) {
            System.out.println("Error reading JSON Object: " + e.getMessage());
        }
        return p;
    }

    @Test
    public void testSaveAndLoadOnePractitioner() {
        //1. Erstellen einer mit Daten befüllten Practitionerinstanz
        Practitioner p = returnOnePractitionerJSON(resourceLoader, om);
        //2. Instanz in die DB speichern
        Practitioner savedP = practitionerRepository.save(p);
        //3. Gespeicherte Daten aus der DB lesen
        Practitioner loadedPractitioner = practitionerRepository.findById(savedP.getId()).get();
        //4. Vergleich des gespeicherten Objekts mit dem geladenen
        //Mit assertThat werden alle Attribute von p und loadedPractitioner auf Gleichheit getestet
        //Wenn ein Wert unterschiedlich ist, schlägt der Test fehlt
        //z.B. bei p.setActive(!p.getActive()); würden wir den Wert von active umkehren, dann würde der Test fehlschlagen
        //Probiere das ruhig mal aus
        //Listen können unterschiedliche Reihenfolgen haben, deshalb wird mit .ignoringCollectionOrder die Reihenfolgeprüfung ausgeschalten
        assertThat(loadedPractitioner)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(p);
        //Einzelne Attribute können mit Assert auf Gleichheit getestet werden.
        //Dies ist bei Tests wichtig, um ein erwartetes Ergebnis mit dem tatsächlichen Wert zu vergleichen.
        //z.B. wird wie folgt getestet, ob der active Wert von p true ist.  Wenn nicht, schlägt der Test fehl
        //Es gibt viele assert Methoden, um verschiedene Werte zu prüfen.
        assertEquals(loadedPractitioner.getActive(), p.getActive());
    }

    @Test
    public void saveAndUpdateOnePractitioner() {

        Practitioner p = returnOnePractitionerJSON(resourceLoader, om);
        Practitioner savedP = practitionerRepository.save(p);
        Practitioner loadedPractitioner = practitionerRepository.findById(savedP.getId()).get();

        savedP.setGender(GenderCode.male);

        practitionerRepository.save(savedP);

        loadedPractitioner = practitionerRepository.findById(savedP.getId()).get();


        assertThat(loadedPractitioner)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(savedP);

        assertEquals(loadedPractitioner.getActive(), savedP.getActive());

    }

    @Test
    public void saveAndDeleteOnePractitioner() {
        Practitioner p = returnOnePractitionerJSON(resourceLoader, om);
        Practitioner savedP = practitionerRepository.save(p);
        Practitioner loadedPractitioner = practitionerRepository.findById(savedP.getId()).get();
        assertThat(loadedPractitioner)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(p);
        assertEquals(loadedPractitioner.getActive(), p.getActive());


        practitionerRepository.delete(loadedPractitioner);


        assertEquals(practitionerRepository.findById(loadedPractitioner.getId()), Optional.empty());


    }

}
