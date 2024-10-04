package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.entity.Encounter;
import at.spengergasse.fhirstarter.repository.EncounterRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EncounterRepositoryTest {

    @Autowired
    EncounterRepository encounterRepository;
    @Autowired
    ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    @Autowired
    private ResourceLoader resourceLoader;

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

    @Test
    @Transactional
    public void testSaveAndLoadOneEncounter() {
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
                .isEqualTo(savedE);
    }

    @Test
    @Transactional
    public void saveAndUpdateOneEncounter() {

        Encounter e = returnOneEncounterJSON(resourceLoader, om);
        Encounter savedE = encounterRepository.save(e);
        Encounter loadedEncounter = encounterRepository.findById(savedE.getId()).get();

        savedE.setStatus(Encounter.Statuscode.cancelled);

        encounterRepository.save(savedE);

        loadedEncounter = encounterRepository.findById(savedE.getId()).get();


        assertThat(loadedEncounter)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(savedE);

        assertEquals(loadedEncounter.getStatus(), savedE.getStatus());

    }

    @Test
    @Transactional
    public void saveAndDeleteOneEncounter() {
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
}