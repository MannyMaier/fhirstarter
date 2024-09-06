package at.spengergasse.fhirstarter;


import at.spengergasse.fhirstarter.entity.Practitioner;
import at.spengergasse.fhirstarter.model.*;
import at.spengergasse.fhirstarter.repository.PractitionerRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PractitionerRepositoryTest {
    @Autowired
    PractitionerRepository practitionerRepository;

    @Test
    @Transactional
    public void testSaveAndLoadOnePractitioner() {
        //1. Erstellen einer mit Daten befüllten Practitionereninstanz
        Practitioner p = returnOnePractitioner();

        //2. Instanz in die DB speichern
        Practitioner savedP = practitionerRepository.save(p);

        //3. Gespeicherte Daten aus der DB lesen
        Practitioner loadedPractitioner =
                practitionerRepository.findById(savedP.getId()).get();       //.get liefert das Practitioneren Objekt aus, findet ers nicht, liefert er ein Null-Practitionerenobjekt
        System.out.println(loadedPractitioner);

        //4. Vergleich des gespeicherten Objekts mit dem geladenen
        //Alle einfachen Datentypen können mit Equals verglichen werden.
        //Assert prüft, ob die beiden gleich sind. Schlägt ein Assert fehl, ist der Test fehlgeschlagen
        //Asserts sind die eigentlichen "Tests"
        assertEquals(p.getBirthDate(), loadedPractitioner.getBirthDate());

        assertEquals(p.getGender(), loadedPractitioner.getGender());
        assertEquals(p.getText(), loadedPractitioner.getText());

        //andere Tests mit Pirker im Unterricht
        assertNotNull(loadedPractitioner);

        assertEquals(p.getActive(), loadedPractitioner.getActive());

        assertTrue(CollectionUtils.isEqualCollection(p.getIdentifier(), loadedPractitioner.getIdentifier()));

        //Es sollen alle Attribute verglichen werden, auch die geerbten.
        //Collections werden mit CollectionUtils auf gleichheit getestet.
        // Dabei werden die einzelnen Elemente verglichen,nicht ob die Collectionobjekte gleich sind.
        assertTrue(CollectionUtils.isEqualCollection(p.getIdentifier(),
                loadedPractitioner.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(p.getName(),
                loadedPractitioner.getName()));
        assertTrue(CollectionUtils.isEqualCollection(p.getTelecom(),
                loadedPractitioner.getTelecom()));
        assertTrue(CollectionUtils.isEqualCollection(p.getAddress(),
                loadedPractitioner.getAddress()));
        //Es sollen alle Collections getestet werden.
    }










    //Ein Practitionerobjekt. Alle Attribute sollen Werte bekommen.
    //Auch die Collections sollen zumindest 1 Wert haben.
    public static Practitioner returnOnePractitioner() {
        List<Identifier> identifiers = new ArrayList<>();
        List<Coding> codings = new ArrayList<>();
        List<ContactPoint> contactPoints = new ArrayList<>();
        List<HumanName> names = new ArrayList<>();
        List<Address> address = new ArrayList<>();
        List<String> prefixes = null;
        List<String> suffixes = null;

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

        List<Attachment> attachments = new ArrayList<>();

        attachments.add(
                Attachment.builder()
                        .data("Attachmeant Data")
                        .build()
        );

        List<Qualification> qualifications = new ArrayList<>();

        qualifications.add(
                Qualification.builder()
                        .code(CodeableConcept.builder()
                                .text("Meine Qualifikation")
                                .build())
                        .build()
        );

        List<Communication> communications = new ArrayList<>();



        //TODO:nein, siehe anderes todo hier weiter communication einfügen; PractitionerRepotest fertig machen; und -Controllertest

        communications.add(
                Communication.builder()
                        .language(CodeableConcept.builder()
                                .text("Spanisch")
                                .build())
                        .build()
        );


        return Practitioner.builder()
                .active(true)
                .birthDate(LocalDate.of(1999, 01, 01))
                .identifier(identifiers)
                .gender(GenderCode.male)
                .name(names)
                .telecom(contactPoints)
                .address(address)
                .photo(attachments)
                .qualification(qualifications)
                .communication(communications)
                .build();
    }
}
