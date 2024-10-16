package at.spengergasse.fhirstarter.validators;

import at.spengergasse.fhirstarter.entity.Patient;
import at.spengergasse.fhirstarter.model.CodeableConcept;
import at.spengergasse.fhirstarter.model.Coding;
import at.spengergasse.fhirstarter.model.Identifier;
import ch.qos.logback.core.helpers.CyclicBuffer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.annotation.Annotation;
import java.util.List;

public class SvnrValidator implements ConstraintValidator<SvnrValid, Patient> {

    @Override
    public void initialize(SvnrValid constraintAnnotation){
    }
    @Override
    public boolean isValid(Patient patient, ConstraintValidatorContext context) {

        List<Identifier> identifiers = patient.getIdentifier();
        String svnr = "";
        String dob = patient.getBirthDate().toString();
        System.out.println("Birthdate: "+ dob);

        for (Identifier identifier : identifiers) {
           for(Coding coding : identifier.getType().getCoding()){
                if(coding.getCode().equals("SS")){
                     svnr = identifier.getValue();
                }
           }
        }

        WebClient client = WebClient.create();
        if(!svnr.isEmpty()){
            WebClient.ResponseSpec responseSpec = client.get()
                    .uri(String.format("http://www2.argedaten.at/php/svnummer.php?str[1]=%s&str[2]=%s", svnr, dob))
                    .retrieve();
            String responseBody = responseSpec.bodyToMono(String.class).block();
            if (responseBody == null){
                return false;
            }
            return responseBody.contains("OK!");
        }else {
            return true;
        }
    }
}
