package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.entity.Patient;
import at.spengergasse.fhirstarter.model.GenderCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc    //ModelViewController ; ahmt den Client nach
public class PatientControllerTest {
//xTODO: Hier ist alles fertig


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;

    //test Get All patients
    //Erster Test, um alle Patienten unter der URL /api/patient mit GET abzufragen.
    //andExpect überprüft, ob der zurückgegebene Status 200 (OK) ist.
    @Test
    public void getAllPatients() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/patient"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Ein einzelner Patient wird mit der id mit GET abgefragt. Dabei muss der Patient mit der id in der DB existieren. //im import.sql muss dieser Patient somit eingefügt werden. //andExpect überprüft, ob der zurückgegebene Status 200 (OK) ist.
    @Test
    public void getAPatient() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/patient/1"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Es wird ein neuer Patient mit POST an den Controller geschickt und somit in der DB gespeichert. //Wir können die Methode aus PatientRepositoryTest, die uns eine Patienten Instanz erzeugt auch hier verwenden. //Der erwartete Rückgabecode ist "CREATED" Also 201.
    @Test
    public void postAPatient(){
        Patient patient = PatientRepositoryTest.returnOnePatient();
        patient.setGender(GenderCode.female);
        String json= null;

        try {
            json = om.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post("/api/patient/")
                    .accept(MediaType.APPLICATION_JSON) .contentType(MediaType.APPLICATION_JSON)
                    .content(json)) .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //PUT aktualisiert einen Patienten. Dieser muss somit bereits in der DB existieren (über import.sql) //Die id im Patienten und die id in der URL sollten gesetzt sein und müssen in der DB existieren. //Wir erwarten ein 200- OK für einen aktualisierten Patienten. //Kein 201 CREATED, sonst wäre der Patient neu angelegt worden.
    @Test
    public void putAPatient(){
        Patient patient = PatientRepositoryTest.returnOnePatient();
        patient.setId("1");
        patient.setGender(GenderCode.female);
        String json= null;

        try {
            json = om.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                    .put("/api/patient/1")
                    .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Der Patient wird geöscht. //Die id muss es bereits geben. //Erwartete Antwort ist 200 (OK)
    @Test
    public void deleteAPatient() {

      /*   Funktioniert so leider nicht


      Patient patient = PatientRepositoryTest.returnOnePatient();
        String  urlTemplate = "/api/patient/" + patient.getId().toString();


        try {
            PatientRepositoryTest repositoryTest = new PatientRepositoryTest();

            repositoryTest.saveOnePatient(patient);
        }catch (Exception e){
            System.out.println("Ein Fehler ist beim Speichern des Patienten aufgetreten: " + e.getMessage());
        }

*/

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.delete("/api/patient/3"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
