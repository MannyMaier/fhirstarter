package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.model.Contract;
import at.spengergasse.fhirstarter.repository.ContractRepository;
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
public class ContractRepositoryTest {
    
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void testSaveAndLoadOneContract(){
        //1. Erstellen einer mit Daten befüllten Contractinstanz
        Contract c = returnOneContractJSON(resourceLoader, om);
        //2. Instanz in die DB speichern
        Contract savedP = contractRepository.save(c);
        //3. Gespeicherte Daten aus der DB lesen
        Contract loadedContract = contractRepository.findById(savedP.getId()).get();
        //4. Vergleich des gespeicherten Objekts mit dem geladenen
        //Mit assertThat werden alle Attribute von c und loadedContract auf Gleichheit getestet
        //Wenn ein Wert unterschiedlich ist, schlägt der Test fehlt
        //z.B. bei p.setActive(!p.getActive()); würden wir den Wert von active umkehren, dann würde der Test fehlschlagen
        //Probiere das ruhig mal aus
        //Listen können unterschiedliche Reihenfolgen haben, deshalb wird mit .ignoringCollectionOrder die Reihenfolgeprüfung ausgeschalten
        assertThat(loadedContract)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(c);
        //Einzelne Attribute können mit Assert auf Gleichheit getestet werden.
        //Dies ist bei Tests wichtig, um ein erwartetes Ergebnis mit dem tatsächlichen Wert zu vergleichen.
        //z.B. wird wie folgt getestet, ob der active Wert von c true ist.  Wenn nicht, schlägt der Test fehl
        //Es gibt viele assert Methoden, um verschiedene Werte zu prüfen.
        assertEquals(loadedContract.getVersion(), c.getVersion());
    }

    @Test
    public void saveAndUpdateOneContract(){

        Contract c = returnOneContractJSON(resourceLoader, om);
        Contract savedP = contractRepository.save(c);
        Contract loadedContract = contractRepository.findById(savedP.getId()).get();

        c.setVersion("Version 1");

        contractRepository.save(c);

        loadedContract = contractRepository.findById(c.getId()).get();


        assertThat(loadedContract)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(c);

        assertEquals(loadedContract.getVersion(), c.getVersion());

    }

    @Test
    public void saveAndDeleteOneContract(){
        Contract c = returnOneContractJSON(resourceLoader, om);
        Contract savedP = contractRepository.save(c);
        Contract loadedContract = contractRepository.findById(savedP.getId()).get();
        assertThat(loadedContract)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .ignoringFieldsMatchingRegexes(".*id")
                .ignoringFields("id")
                .isEqualTo(c);
        assertEquals(loadedContract.getVersion(), c.getVersion());


        contractRepository.delete(loadedContract);


        assertEquals(contractRepository.findById(loadedContract.getId()), Optional.empty());


    }
    public static  Contract returnOneContractJSON(ResourceLoader resourceLoader, ObjectMapper om) {
        String json = "";
        Contract c = null;
        //OM Configure
        try {
            File dataFile =
                    resourceLoader.getResource("classpath:Contract.json").getFile();
            System.out.println("File exists"+dataFile.exists());
            c = om.readValue(dataFile, Contract.class);
        } catch (Exception e) {
            System.out.println("Error reading JSON Object: " + e.getMessage());
        }
        return c;
    }

}
