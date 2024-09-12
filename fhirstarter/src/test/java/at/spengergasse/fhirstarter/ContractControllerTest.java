package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.model.Contract;
import at.spengergasse.fhirstarter.model.GenderCode;
//import at.spengergasse.fhirstarter.model.Organization;
import at.spengergasse.fhirstarter.repository.ContractRepository;
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
public class ContractControllerTest {

    //Anmerkung: Da es keine Imports zu Contract gibt speichere ich bei jedem Test einen Contract aus der Contract.json Datei in die DB. So kann ich sie bearbeiten(CRUD-Operationen durchführen)

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    ContractRepository contractRepository;


    @Test
    @Order(0)
    public void getAllContracts(){
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/contract"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect((ResultMatcher) content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect((ResultMatcher) jsonPath("$status", is("resolved")))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void getAContract() {
        Contract con = ContractRepositoryTest.returnOneContractJSON(resourceLoader, om);
        Contract savedcon = contractRepository.save(con);
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/contract/C-123"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }


    @Test
    @Order(2)
    public void postAContract(){

        Contract contract = ContractRepositoryTest.returnOneContractJSON(resourceLoader, om);
        contract.setVersion("Version 1");
        String json= null;

        try {
            json = om.writeValueAsString(contract);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post("/api/contract/")
                            .accept(MediaType.APPLICATION_JSON) .contentType(MediaType.APPLICATION_JSON)
                            .content(json)) .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void putAContract(){
        Contract contract = ContractRepositoryTest.returnOneContractJSON(resourceLoader, om);
        contract.setVersion("Version 1");
        String contractId = contract.getId();
        String json= null;

        System.out.println("TEST");
        System.out.println(contract.getId());

        try {
            json = om.writeValueAsString(contract);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api/contract/" + contractId)
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
    public void deleteAContract() {
        Contract con = ContractRepositoryTest.returnOneContractJSON(resourceLoader, om);
        Contract savedcon = contractRepository.save(con);

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.delete("/api/contract/C-123"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
