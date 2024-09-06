package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.entity.Patient;
import at.spengergasse.fhirstarter.entity.Practitioner;
import at.spengergasse.fhirstarter.model.GenderCode;
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
public class PractitionerControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;

    @Autowired
    ResourceLoader resourceLoader;



    @Test
    @Order(0)
    public void getAllPractitioners(){
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/practitioner"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect((ResultMatcher) content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                            .andExpect((ResultMatcher) jsonPath("$[0].name", is("Anne")))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void getAPractitioner() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/practitioner/f005"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }


    @Test
    @Order(2)
    public void postAPractitioner(){

        Practitioner practitioner = PractitionerRepositoryTestv2.returnOnePractitionerJSON(resourceLoader, om);
        practitioner.setGender(GenderCode.male);
        String json= null;

        try {
            json = om.writeValueAsString(practitioner);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post("/api/practitioner/")
                            .accept(MediaType.APPLICATION_JSON) .contentType(MediaType.APPLICATION_JSON)
                            .content(json)) .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void putAPractitioner(){
        Practitioner practitioner = PractitionerRepositoryTestv2.returnOnePractitionerJSON(resourceLoader, om);
        practitioner.setGender(GenderCode.male);
        String practitionerId = practitioner.getId();
        String json= null;

        System.out.println("TEST");
        System.out.println(practitioner.getId());

        try {
            json = om.writeValueAsString(practitioner);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api/practitioner/" + practitionerId)
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(4)
    public void deleteAPatient() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.delete("/api/practitioner/f005"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
