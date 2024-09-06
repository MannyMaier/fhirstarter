package at.spengergasse.fhirstarter;

import at.spengergasse.fhirstarter.entity.Patient;
import at.spengergasse.fhirstarter.entity.Practitioner;
import at.spengergasse.fhirstarter.model.*;
import at.spengergasse.fhirstarter.repository.PatientRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;              //oder Jakarta?

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Durch diese Annotation wird aus der Klasse eine Testklasse
@SpringBootTest
public class PatientRepositoryTest {
    @Autowired
    PatientRepository patientRepository;

    @Test
    @Transactional
    public void testSaveAndLoadOnePatient() {
        //1. Erstellen einer mit Daten befüllten Patienteninstanz
        Patient p = returnOnePatient();

        //2. Instanz in die DB speichern
        Patient savedP = patientRepository.save(p);

        //3. Gespeicherte Daten aus der DB lesen
        Patient loadedPatient =
                patientRepository.findById(savedP.getId()).get();       //.get liefert das Patienten Objekt aus, findet ers nicht, liefert er ein Null-Patientenobjekt
        System.out.println(loadedPatient);

        //4. Vergleich des gespeicherten Objekts mit dem geladenen
        //Alle einfachen Datentypen können mit Equals verglichen werden.
        //Assert prüft, ob die beiden gleich sind. Schlägt ein Assert fehl, ist der Test fehlgeschlagen
        //Asserts sind die eigentlichen "Tests"
        assertEquals(p.getBirthDate(), loadedPatient.getBirthDate());
        assertEquals(p.getDeceasedDateTime(),
                loadedPatient.getDeceasedDateTime());
        assertEquals(p.getGender(), loadedPatient.getGender());
        assertEquals(p.getText(), loadedPatient.getText());

        //andere Tests mit Pirker im Unterricht
        assertNotNull(loadedPatient);

        assertEquals(p.getActive(), loadedPatient.getActive());

        assertTrue(CollectionUtils.isEqualCollection(p.getIdentifier(), loadedPatient.getIdentifier()));

        //Es sollen alle Attribute verglichen werden, auch die geerbten.
        //Collections werden mit CollectionUtils auf gleichheit getestet.
        // Dabei werden die einzelnen Elemente verglichen,nicht ob die Collectionobjekte gleich sind.
        assertTrue(CollectionUtils.isEqualCollection(p.getIdentifier(),
                loadedPatient.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(p.getName(),
                loadedPatient.getName()));
        assertTrue(CollectionUtils.isEqualCollection(p.getTelecom(),
                loadedPatient.getTelecom()));
        assertTrue(CollectionUtils.isEqualCollection(p.getAddress(),
                loadedPatient.getAddress()));
        //Es sollen alle Collections getestet werden.

        assertTrue(CollectionUtils.isEqualCollection(p.getGeneralPractitioner(), loadedPatient.getGeneralPractitioner()));

    }

    //Ein Patientenobjekt. Alle Attribute sollen Werte bekommen.
    //Auch die Collections sollen zumindest 1 Wert haben.
    public static Patient returnOnePatient() {
        List<Identifier> identifiers = new ArrayList<>();
        List<Coding> codings = new ArrayList<>();
        List<ContactPoint> contactPoints = new ArrayList<>();
        List<HumanName> names = new ArrayList<>();
        List<Address> address = new ArrayList<>();
        List<String> prefixes = null;
        List<String> suffixes = null;
        List<Reference> practitioners = new ArrayList<>();

        //Ein Coding Objekt wird mit wie bisher mit einem Konstruktor gebaut.
        codings.add(new Coding("System", "0.1.1", "Code", "<div>...<div>", false));
        //Eine Period mit Konstruktor
        Period period = new Period(LocalDateTime.of(2000, 01, 01, 1, 1),
                LocalDateTime.of(2001, 01, 01, 1, 1));
        //Eine Period mit dem Builder Pattern. Es ist offensichtlicher, welche Attribute gesetzt werden.
        Period period2 = Period.builder()
                .start(LocalDateTime.of(2000, 01, 01, 1, 1))
                .end(LocalDateTime.of(2010, 02, 02, 2, 2))
                .build();
        Period period3 = Period.builder()
                .start(LocalDateTime.of(2001, 01, 01, 1, 1))
                .end(LocalDateTime.of(2011, 02, 02, 2, 2))
                .build();
        CodeableConcept ccType = CodeableConcept.builder()
                .coding(codings)
                .text("<div></div>")
                .build();// new CodeableConcept(codings, "Text");
        identifiers.add(
                Identifier.builder()
                        .use(Identifier.IdentifierUseCode.official)
                        .period(period)
                        .system("System")
                        .type(ccType)
                        .value("value")
                        .build()
        );


        practitioners.add(
                Reference.builder()
                        .build()
        );

        contactPoints.add(
                ContactPoint.builder()
                        .period(period2)
                        .rank(1)
                        .system(ContactPoint.SystemCode.email)
                        .use(ContactPoint.ContactKind.home)
                        .value("pirker@spengergasse.at")
                        .build());
                //new ContactPoint(ContactPoint.SystemCode.phone, "123454321", ContactPoint.ContactKind.home, 1, period2);


        List<String> givenNames = new ArrayList<>();
        givenNames.add("Simon");
        givenNames.add("2.Vorname");
        names.add(HumanName.builder()
                .family("Pirker")
                .given(givenNames)

                .period(Period.builder().start(LocalDateTime.now()).end(LocalDateTime.now()).build())

                .build());
        address.add(
                Address.builder()
                        .city("Wien")
                        .country("Österreich")
                        .district("Wien")
                        .line(List.of("Spengergasse 20"))
                        .postalCode("1050")
                        .period(period3)
                        .state("Wien")
                        .text("<div>.../</div>")
                        .type(Address.TypeCode.both)
                        .use(Address.UseCode.home)
                        .build()
        );
        return Patient.builder()
                .active(true)
                .birthDate(LocalDate.of(1999, 01, 01))
                .identifier(identifiers)
                .deceasedBoolean(false)
                .gender(GenderCode.male)
                .name(names)
                .telecom(contactPoints)
                .address(address)
                .generalPractitioner(practitioners)
                .build();
    }
}
