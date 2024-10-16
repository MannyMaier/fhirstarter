package at.spengergasse.fhirstarter.validators;

import at.spengergasse.fhirstarter.entity.Patient;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PatientValidator implements ConstraintValidator<PatientValid, Patient> {
    @Override
    public void initialize(PatientValid constraintAnnotation){
    }
    @Override
    public boolean isValid(Patient patient, ConstraintValidatorContext context) {
        if(patient.getDeceasedBoolean() != null &&
                patient.getDeceasedDateTime() != null )
        {
            return false;
        }
        return true;
    }
}
