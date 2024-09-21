package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.entity.Encounter;
import at.spengergasse.fhirstarter.repository.EncounterRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EncounterRepositoryTest {

    @Autowired
    EncounterRepository encounterRepository;
    @Autowired
    ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void testSaveAndLoadOneEncounter(){
        //1. Erstellen einer mit Daten befüllten Encounterinstanz
        Encounter e = returnOneEncounterJSON(resourceLoader, om);
        //2. Instanz in die DB speichern
        Encounter savedE = encounterRepository.save(e);
        //3. Gespeicherte Daten aus der DB lesen
        Encounter loadedEncounter = encounterRepository.findById(savedE.getId()).get();
        //4. Vergleich des gespeicherten Objekts mit dem geladenen
        assertThat(loadedEncounter)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(e);
    }

    @Test
    public void saveAndUpdateOneEncounter(){

        // Man darf keine Id angeben!
        Encounter e = returnOneEncounterJSON(resourceLoader, om);

        // Speichern des neuen Encounter
        Encounter savedE = encounterRepository.save(e);

        // Sicherstellen, dass die ID existiert
        assertNotNull(savedE.getId(), "Encounter ID sollte nicht null sein!");

        // Laden des gespeicherten Encounter
        Encounter loadedEncounter = encounterRepository.findById(savedE.getId())
                .orElseThrow(() -> new RuntimeException("Encounter nicht gefunden!"));

        // Status aktualisieren
        e.setStatus(Encounter.Statuscode.cancelled);

        // Speichern der aktualisierten Encounter
        Encounter updatedE = encounterRepository.save(e);

        // Laden des aktualisierten Encounter
        loadedEncounter = encounterRepository.findById(updatedE.getId())
                .orElseThrow(() -> new RuntimeException("Aktualisierter Encounter nicht gefunden!"));

        // Vergleich der geladenen und der aktualisierten Entität
        assertThat(loadedEncounter)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .isEqualTo(updatedE);
    }

    @Test
    public void saveAndDeleteOneEncounter(){
        Encounter e = returnOneEncounterJSON(resourceLoader, om);
        Encounter savedE = encounterRepository.save(e);
        Encounter loadedEncounter = encounterRepository.findById(savedE.getId()).get();
        assertThat(loadedEncounter)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(e);

        encounterRepository.delete(loadedEncounter);

        assertThat(encounterRepository.findById(loadedEncounter.getId())).isEmpty();
    }

    public static Encounter returnOneEncounterJSON(ResourceLoader resourceLoader, ObjectMapper om) {
        Encounter e = null;
        try {
            File dataFile = resourceLoader.getResource("classpath:Encounter.json").getFile();
            System.out.println("File exists: " + dataFile.exists());
            e = om.readValue(dataFile, Encounter.class);
        } catch (Exception ex) {
            System.out.println("Error reading JSON Object: " + ex.getMessage());
        }
        return e;
    }
}