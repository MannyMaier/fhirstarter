package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.entity.Encounter;
import at.spengergasse.fhirstarter.repository.EncounterRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EncounterControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    EncounterRepository encounterRepository;

    @Test
    @Order(0)
    public void getAllEncounters(){
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/encounter"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect((ResultMatcher) content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect((ResultMatcher) jsonPath("$[0].status", is("planned")))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void getAnEncounter() {
        Encounter enc = EncounterRepositoryTest.returnOneEncounterJSON(resourceLoader, om);
        Encounter savedEnc = encounterRepository.save(enc);
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/encounter/" + savedEnc.getId()))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @Order(2)
    public void postAnEncounter(){
        Encounter encounter = EncounterRepositoryTest.returnOneEncounterJSON(resourceLoader, om);
        encounter.setStatus(Encounter.Statuscode.planned);
        String json = null;

        try {
            json = om.writeValueAsString(encounter);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post("/api/encounter/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void putAnEncounter(){
        Encounter encounter = EncounterRepositoryTest.returnOneEncounterJSON(resourceLoader, om);
        encounterRepository.save(encounter);
        encounter.setStatus(Encounter.Statuscode.planned);
        String encounterId = encounter.getId();
        String json = null;

        try {
            json = om.writeValueAsString(encounter);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api/encounter/" + encounterId)
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(4)
    public void deleteAnEncounter() {
        Encounter enc = EncounterRepositoryTest.returnOneEncounterJSON(resourceLoader, om);
        Encounter savedEnc = encounterRepository.save(enc);

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.delete("/api/encounter/" + savedEnc.getId()))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}