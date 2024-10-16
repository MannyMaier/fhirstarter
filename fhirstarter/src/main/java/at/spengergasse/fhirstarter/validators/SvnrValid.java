package at.spengergasse.fhirstarter.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SvnrValidator.class})
@Documented
public @interface SvnrValid {
    String message() default "Ungültige Sozialversicherungsnummer";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
