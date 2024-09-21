-- Diese Inserts funktionieren (Stand 12.09.2024)

SET FOREIGN_KEY_CHECKS = 0;


-- Inserts für ad_address
INSERT INTO `fhirstarter`.`ad_address` (`ad_pe_id`, `ad_typecode`, `ad_usecode`, `ad_city`, `ad_country`, `ad_district`, `id`, `ad_pa_id`, `ad_postal_code`, `ad_state`, `ad_text`) VALUES('2022-01-01', 'both', 'home', 'New York', 'USA', 'Manhattan', '1', '123 Main St', '10001', 'NY', 'Home Address'),('2022-01-02', 'postal', 'work', 'San Francisco', 'USA', 'Financial District', '2', '456 Market St', '94105', 'CA', 'Work Address'),('2022-01-03', 'physical', 'temp', 'Los Angeles', 'USA', 'Hollywood', '3', '789 Sunset Blvd', '90028', 'CA', 'Temporary Address');

-- Inserts für ad_line
INSERT INTO `fhirstarter`.`ad_line` (`address_id`, `line`)VALUES('1', 'Apartment 5B'),('2', 'Suite 1000'),('3', 'Building C');

-- Inserts für at_at1plf
INSERT INTO `fhirstarter`.`at_at1plf` (`at_size`, `at_creation`, `at_id`, `at_title`)VALUES(1024, '2022-01-01 12:00:00', '1', 'Document 1'),(2048, '2022-01-02 14:30:00', '2', 'Report 1'),(4096, '2022-01-03 10:45:00', '3', 'Presentation 1');

-- Inserts für at_attachment
INSERT INTO `fhirstarter`.`at_attachment` (`at_duration`, `at_frames`, `at_height`, `at_pages`, `at_size`, `at_width`, `at_creation`, `at_content_type`, `at_hash`, `at_language`, `at_title`, `at_url`, `id`, `at_data`) VALUES (120.5, 30, 720, 10, 2048, 1280, '2022-01-01 08:30:00', 'pdf', 'abcdef123456', 'en', 'Attachment 1', 'http://example.com/attachment1', '1', NULL), (180.2, 24, 1080, 15, 4096, 1920, '2022-01-02 15:45:00', 'jpg', 'ghijkl789012', 'es', 'Attachment 2', 'http://example.com/attachment2', '2', NULL), (90.7, 20, 480, 5, 1024, 640, '2022-01-03 11:15:00', 'docx', 'mnopqr345678', 'fr', 'Attachment 3', 'http://example.com/attachment3', '3', NULL);

-- Inserts für cc_codeableconcept
INSERT INTO `fhirstarter`.`cc_codeableconcept` (`cc_text`, `id`)VALUES('Concept 1', '1'),('Concept 2', '2'),('Concept 3', '3');

-- Inserts für co_coding
INSERT INTO `fhirstarter`.`co_coding` (`co_user_selected`, `co_cc_id`, `co_code`, `co_display`, `co_system`, `co_version`, `id`)VALUES(1, '1', 'A001', 'Code A', 'http://example.com/systemA', '1.0', '1'),(0, '2', 'B002', 'Code B', 'http://example.com/systemB', '2.0', '2'),(1, '3', 'C003', 'Code C', 'http://example.com/systemC', '3.0', '3');

-- Inserts für cp_contactpoint
INSERT INTO `fhirstarter`.`cp_contactpoint` (`cp_rank`, `cp_contactkind`, `cp_pe_id`, `cp_systemcode`, `id`, `cp_pa_id`, `cp_value`)VALUES(1, 'home', '2022-01-01', 'phone', '1', '123456789', '123-456-7890'),(2, 'work', '2022-01-02', 'email', '2', 'work@example.com', 'work@example.com'),(3, 'temp', '2022-01-03', 'sms', '3', '987654321', '987-654-3210');

-- Inserts für g_greeting
INSERT INTO `fhirstarter`.`g_greeting` (`l`, `format`, `id`)VALUES(1, 'Hello, {name}!', '1'),(2, 'Greetings, {name}!', '2'),(3, 'Hi there, {name}!', '3');

-- Inserts für hn_human_name
INSERT INTO `fhirstarter`.`hn_human_name` (`hn_family`, `hn_pe_id`, hn_use, `hn_text`, `id`) VALUES ('Doe', '2022-01-01', 'official', 'John Doe', '1'), ('Smith', '2022-01-02', 'usual', 'Jane Smith', '2'), ('Johnson', '2022-01-03', 'maiden', 'Alice Johnson', '3');
-- Inserts für hn_gi_given
INSERT INTO `fhirstarter`.`hn_gi_given` (`given`, `human_name_id`)VALUES('John', '1'),('Jane', '2'),('Alice', '3');

-- Inserts für hn_pf_prefix
INSERT INTO `fhirstarter`.`hn_pf_prefix` (`human_name_id`, `prefix`)VALUES('1', 'Mr.'),('2', 'Ms.'),('3', 'Mrs.');

-- Inserts für hn_sf_suffix
INSERT INTO `fhirstarter`.`hn_sf_suffix` (`human_name_id`, `suffix`)VALUES('1', 'Jr.'),('2', 'II'),('3', 'Sr.');

-- Inserts für id_identifier
INSERT INTO `fhirstarter`.`id_identifier` (`id_cc_id`, `id_pe_id`, `id_re_id`, `id_system`, `id_value`, `id`, `id_pa_id`, `id_use`) VALUES ('1', '1', '1', 'identifiertest', 'value odf identifier', '1', '1', 'old');

-- Inserts für na_narrative
INSERT INTO `fhirstarter`.`na_narrative` (`id`, `na_div`, `na_status`)VALUES('1', '<div>Document 1 content</div>', 'generated'),('2', '<div>Report 1 content</div>', 'additional'),('3', '<div>Presentation 1 content</div>', 'empty');

-- Inserts für pa_patient
INSERT INTO `fhirstarter`.`pa_patient` (`pa_active`, `pa_deceasedboolean`, `pa_birthdate`, `pa_deceaseddatetime`, `dr_na_id`, `id`, `pa_gender`)VALUES(1, 0, '1990-05-15', NULL, '1', '1', 'male'),(1, 1, '1985-03-20', '2022-01-02 12:30:00', '2', '2', 'female'),(0, 0, '2000-10-10', NULL, '3', '3', 'other');

-- Inserts für pe_period
INSERT INTO `fhirstarter`.`pe_period` (`pe_end`, `pe_start`, `id`) VALUES ('2022-01-01', '2021-01-01', '1'), ('2022-01-02', '2021-02-01', '2'), ('2022-01-03', '2021-03-01', '3');





SET FOREIGN_KEY_CHECKS = 0;

-- Inserts für pr_practitioner
INSERT INTO `fhirstarter`.`pr_practitioner` (`id`, `pr_gender`, `pr_birthdate`, `dr_na_id`) VALUES ('f005', 'female', '1959-03-11', 'na01');

-- Inserts für id_identifier
INSERT INTO `fhirstarter`.`id_identifier` (`id`, `id_pr_id`, `id_use`, `id_system`, `id_value`) VALUES ('i01', 'f005', 'official', 'urn:oid:2.16.528.1.1007.3.1', '118265112'), ('i02', 'f005', 'usual', 'urn:oid:2.16.840.1.113883.2.4.6.3', '191REW8WE916');

-- Inserts für hn_human_name
INSERT INTO `fhirstarter`.`hn_human_name` (`id`, `hn_pr_id`, `hn_use`, `hn_family`) VALUES ('h005', 'f005', 'official', 'Anne');

-- Inserts für hn_gi_given
INSERT INTO `fhirstarter`.`hn_gi_given` (`given`, `human_name_id`) VALUES ('Langeveld', 'h005');

-- Inserts für hn_sf_suffix
INSERT INTO `fhirstarter`.`hn_sf_suffix` (`human_name_id`, `suffix`) VALUES ('h005', 'MD');

INSERT INTO `fhirstarter`.`hn_pf_prefix` (`human_name_id`, `prefix`) VALUES ('h005', 'Mrs.');

INSERT INTO `fhirstarter`.`hn_pf_prefix` (`human_name_id`, `prefix`) VALUES ('h005', 'Dr.');

-- Inserts für cp_contatactpoint
INSERT INTO `fhirstarter`.`cp_contactpoint` (`id`, `cp_pr_id`, `cp_systemcode`, `cp_value`, `cp_contactkind`) VALUES ('cp01', 'f005', 'phone', '0205563847', 'work'), ('cp02', 'f005', 'email', 'a.langeveld@bmc.nl', 'work'), ('cp03', 'f005', 'fax', '0205668916', 'work');

-- Inserts für ad_address
INSERT INTO `fhirstarter`.`ad_address` (`ad_pr_id`, `id`, `ad_usecode`, `ad_city`, `ad_postal_code`, `ad_country`) VALUES ('f005', 'a005', 'work', 'Amsterdam', '1105 AZ', 'NLD');


-- Füge eine Zeile in die `ad_line` Tabelle ein und verknüpfe sie mit der Adresse
INSERT INTO `fhirstarter`.`ad_line` (`address_id`, `line`) VALUES ('a005', 'Galapagosweg 9');



INSERT INTO `fhirstarter`.`at_attachment` (`id`, `at_pr_id`, `at_content_type`, `at_data`) VALUES ('at01', 'f005', 'jpeg', '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');
INSERT INTO `fhirstarter`.`at_attachment` (`id`, `at_pr_id`, `at_content_type`, `at_data`) VALUES ('at02', 'f005', 'jpeg', '/9j/4AAQSkZJRgABAQEAlgCWAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCACCAHQDASIAAhEBAxEB/8QAHAAAAgIDAQEAAAAAAAAAAAAABQYABAIDBwEI/8QAPxAAAgEDAwEGAwQGCAcAAAAAAQIDAAQRBRIhMQYTIkFRYRRxgTKRobEHFSMzQsEWF1JygtHh8CRDYoSS0vH/xAAaAQADAQEBAQAAAAAAAAAAAAACAwQFAAEG/8QALBEAAgIBBAAEBQQDAAAAAAAAAAECEQMEEiExEzJBUQUUIoHwM2FxkSQ04f/aAAwDAQACEQMRAD8A6aySIeTxWSuR51rZ2bqa0S3UcJ2kjPnzjApz4XINexuuNVitSFd1B8yT0rW2swlcmYKMZyaERzafJcs0skTsT9k8ge3NLuv6raWtzKIZbZWkTZ4VwR9MYpDyDo474H2DUY7mPdHLuHqPOt8k6L3Y73BdsZIOBxmuLrrOpQMsbF3iAyoJ4Pzq9b/pEktwsN/abYwcd5ET4fnQeN7DPl2uTssUUJTerGT5GvWjgKblHXpS7aXMgt7eeOZTFKgZSeDg/hRKC7WWUw8gjy6UyM7EyjRvZVGea0sBnirGE8+tTag5OKaAU2LAcCqV5eG1iaRycDyoszxHgDNBNfKC1IwvI86OPYEugH/TaEbiIWYL6VZt+2EUqqWt5EB9RSFqET20xkRlVTzgGtkepR3VuUacI3lijpeoFs6/BJ38KyKeDUrn2m9tIbSzWCSUlkJGfWpQbV7hb0dCmuLONG2yBnxwAaR9avmRTCJCJJOW58vSlzsnrM3w2oX80rMY8RoCc5Y8/kPxofca0Z7wsXDkAliFwoOeealzTXlRVgg5LcMEUOnadAZ7otKcbtrEgc9AAMZNUdM0aXWdVa9uY8Qg/s4UGAB5f/aqFTfywNIzFVwpUc5I86PJ2osNOVLd2WNxgYBHrz91RSbb4L4RpfuNkfZu2uYsNGqg+vlQPVuwEJidohkgHjHWiM0eq3GlrqFhcq0f2mQA7mHoP9igdrB2ourp++uO6TJ8PdM4UfMH+dckn0gVuXNm/SJZYtKhsZ5RG9s20bz1Xn/SjUepRW9zGEkD7UxvLjge5rd/R2G40/ZdrslYcSxvyD6jNc9vOzU9hfTIZrglclZVbr9fL5USbirYGyM20hwv73VYY3voby3uIVYZWHLED1PpVZu1sqxK0kic0PtPjrfs/dPLNNJbmLI348JyPTg+n1pQa8KkkoMeQ9Ksxahvszs8FCVIc7rtjcd2e4dCaWb/ALRahqCPHPJge1BpbwZJBxVdpu9UkNg0fjTYijC4W6WNjvYqfeq8LsgzuNbludw7tmya1soKlfOhcm+w+iyJhjg1KF5mHAGRUryj3YxhsWS2guLZCSko3DaeQy8j7xkUsyy6lPqQgcyvG7ZCMSQB1DfKj1r2d13cGEWxgcg7uRTHZ9ntRuIpI7+FDlcKyDH0I6UmUop3ZXg3JbZC/pazzWs9u90VJIKsowdh9D1p50PsZpr23fSrH4huIdAXP1NJUlnc6Peh5PBHG25jgtgf78qMS6tcXlo4spe+iJ2OqNgqfQ/SlSfqjQilJVZ0bsve2FnavAbyIQ7yEQ8YGcZHqKv3faAxIZbGw+PhQkO0DYKfQgZ+hrk8CK7Rg6dOhGMMMYI9iM0+6VdyNbpax3bxpgjYqHC/4iM/gK5SdUBLEvN2W7f9IFhdzLatA8UpOO7kGDXmtahaQL3Igkee5wy4GeM44rX/AET0yxC3vjludxeSeViS2fyA9Kq3elXOs6nG0M8kSwoq7eQGHUn8aCbl0zysd3Hgtarpmo6ho0GmaQtsrTkh+9nCEgeS56/6Uu/1T9pZUxI9gv8A3B/9a6FFAsNlHamLKoARkdGHQj3B86Z7aYT2sUv9tQ34VRipqiHLBN2zhr/oa7RDkTWR9lm5/ECtX9U2t24zMGK+qAN+Vd8qAimtN9MBRivQ+fh+jiLvMzTyBh1GcUQg7D6dEAGy/wAzXaryxtr+PZcRhschhwR9aWtS7PvaAzW5aWEdQftL/mKnyRyLm7HQcOqEhOymlquO4X7qlMIj4qUi2NpGkKo6AVmM+VebQD1rNeTxQcnFG/0ay1PabuHft9DilLV+wUegWl12gsLu5hCAZg2hg4LAc/8ASM5zXVLXThFGJpgC/UIRwPnWN1H8VHJHKFdHUqyEcEHyPtVmLDKrYt5aaSOT6XfoWKXcXTklCSD/ADptte0un20adza7yvGTz9aBat2Yn0eVpIA8lgxwr/xRegb29/voO9vMr5UEHrxU8ri6L4KORWOuo9opb/uJbdAYLeQSSRZ5kx5fKrVlr9tJcd5E5CnqpHIP8qS9Ohu5JGMLbSOueKvW8E9nfBrtMwuDlsYxSXkd2MlhglSOgw6lHJu/eOCcghTjFNFonw9hBGeCqKPwpR0TN7dRRQeK0iw0jk5zjovzJ/DNOAOXwau09tWZmbh0aDfMjlGABHr51l33eBZIz1yPka03tuHUsPtAcGqFrKySBScZ55qgSW4NQcK2dxK5JzVm3vlmjifPhlHHtQ683W8sbKvgkbBbGRz5GqdpIyaeoB/dykCuOrgIT6NBLMzq5jBPKgcZqVcde8IfHUCpQeHH2O3y9xJ2N5ir2nLCbxO8YALzz5nyqpIq7TlyTVa3nEFwH2scHkHzFRRajJWUtNp0OEzK42sSv97isBDg5x86rQ3CqAu4qh/hkXKH6+X4VcSRYiAQUB8jyD/dP8q0naJTU0CkEYBB4IPQ0vXfZWAyb7b9mmcmE/Z+h6j8acVg3L3ieJPMVjJbK43RHI8wfKlzhGaphwnKHRz46Vc28uYoEQEYLCQfzonadnLjUkAvJB3PXEeSf/I8fdmmgQRl9soKn1Fb44O6I7t3kz5Y6fWp1pIJ2x71M2uDGysrfTbRLe2jWONOij8/c+9bS+JFJPXisiuFO5gT6Cq0rcccYqlJJUiZu+WX8K4wRzQW8gNvcAg5U/hRRHLIHB5869uYBcwED7XUGvTugPq9ybfR2ulR5ML4406nB6j5UNhmEttH3YIR/wBp4hg80VGpWdqstleSohcdGqo2n2t64ms75opVGCqHAce4P514HtaXKL9rex/DqJHAYcc1K5R2ik7UaVrEluby6ljI3xSRJgFD04AxnqPpUpbzU6octLuVqSGXu4lf982ayMZYjbLgj2pR1DWpLe+7vPhxwaI2Opi7twxfa3TIrGx55xV5Vwxfiq6Q4afeTIrRuwKr0JTOKLQs5XMcJ2n+KA7gf8JNIcOoXFrdoXk3JnnjqKcbO4aCQNby7S2DgnKt/lW5hkpQ+l2Ll3YUgkltZu8i7wwn7cToQB7j0NEWVZ4xNA2CfTz+dYW90l2pWRNko6ow/KtUsMttmWzGR/HEfP5UR52ZmQOuHGGFa1JJ8LH6UL1HXIbW2+JncBTwAByx9KVrj9IEdo103csxUL3UckZQ5J5JPOccdOteNooxaXLl8qOh4UL/AJ1VmPODXKLXtZrYlFxLqMpSQs2wNwASeg8h6elHdL7Q6nFKUvXa7R1GzOAV9ycc8UPiIpyfDskFdpjk2qQ2S5k3nHXaM0E1DtMzs4ty6x48PGMms40upHlIRWicZBB6UGa01AiUW8ySAEjZIMYon+wGHFBP6jTc6wtsfiJgspI9POtcXaCGeB/2gjc9fU+1SaxEtmUltg0yc7T5/KlSO2e4uJVWAxFDymeaW9yNTFixZE79B5g7SWdlEIVuFbzPeNk5qUlfq63Hr7+GpXbmevRYHy7KmodyVaR+T1BNDdK1DuLl7d5QFY+Dmh15fhoG3BskY4ORQ3Twk14kzuMxjIU/xVFj0/07ZHz0dNklmWOSpv3H9dbt0XZKS5XzUcD5mnLQ9f0q/wBMt43uooZ8bdkjhCSPTPXyrkcjlklb/lgZO3Pl5UHTtMrOgit5BsPAVVfPvVWDGsSqJsajR6XFBRcmn7n0tZ3qq6q1wrKOjZHH1o9HqNqE8VwjH0DAmvlXTNbMeowvcRhVlcAO/JOemSBgc+tda03VxDCDOq8DIAHQUWTK4uqM9YIu9rv7Fr9Id13csFzbx9SS8RTdn39ienpxSPJrka4eSKcZGWjViwX7zgUz69qTNbm4kUpGoys3nilSz1Zbt2hFpJcPnHePH4QT79M0G6zY0c4RgoPsuxPFqCLI9zBZxL071tzN584q6ySYW5gkLADwyRgqGHyPNUrqzvryS3bdZx2yt9nJJHzwOlXLltRMAt7eW3UqQGZgTgDrj0NDJFOSXFr+jSe2V3pswhR38Xq2Qatp2tgnkDy29xbyfxNFyGpRmJuLprK9tVju1G4SwOGAX1xxirdvfC0yu9cL4e8YZpkHSpmZizY55HCcaf5+cjzZ66t6SLa4mLnjaYa0XKWCXDG7hu1uGGTIiHn7qUv15qOkxNPbyxMGOQSMH6Vei/SfqrwBJIIQB1YJkmmWUeG07x9fz/wLNbWjHKfFuD57DUoOe2DTnf8AG91n+ER1KHaOSye/5/QsLDIciJDhepcBfzqsyCS6jkiXxrw2BgNXkswMUkwQK8bAHec8+gHy5rPT9QknhYtb/wDEKMbgn2j8h04rqF67WYpQ2x5fpRjrNreSWLOJ0gjxtfdwDn5D8KE2ljJZRsY45LhU5aRUIA9ufzo7NFi2M93PMVGGO7oD5AD1oRdSvmZUkkcSpgeInA60XSMNueobcvT3At8y/ENMrhGchggGdvz96eOy+r6pq9zDZwQm7m25baQPCOufT/WlOPToZMLcQ3neNzvjQEfdRPT9M1HSdUtrvT7rYpOwyMNvHmDzQyqXDG4MeW/oXHqda1OX9a6Ztn0+CKKF8uHbByvQYoVPffDxC2gtVQyLk92Mf7NDZr5njImlLMZNwbvMge+Kyn1O2nBliWWaVRy4XaB99clRuY8MYVxZksa2qh53cE9EV8ffUe6JEcaPhmPAJzzVS3t83H6w1UOtsoyitIBuP1/lWVs015ctcTSra2YyFCgbiPmeldQyWRJlXWba7UxzQSK8hBB2hRk+/GTxS9PDchQGdty888c0xzalZLdG3tjvIH2uv41Q1GdRjgfM16uOD5fX5P8AIe0CxxTSENktKB4xnj86YtHhszCRP3ZlY+bdPpSs9yolZUnSFT1wQN1YwT2KXSAtuckeLPH317Qt5cu3apUhjkEkUrxgYCsQMx7uPnUogkamNSGfGP7VSisX81mXG5g6zVW1RVZQR4eCKZUijSebairkhjgYycdalSp8psfDPKKnayR0dFV2UMeQDjPIrQAPjIzjnj8qlSmR8qAf6s/ubdNJZPESevX60c0tVa2yQDhzjI9qlSgNzR/ofcE6o7LJhWIBOcA0Y0uRxbjxt+5z1qVKOIOTpizcyyTfEtLIzsDwWOSK3RMz7A7FhjoTmpUokAuzBeJnI4I6Vo1NiYup++pUrx9ny+r/ANl/yKY8Vy2eefOsF4B+dSpTDn2dH0d2OlwksTx61KlSgJX2f//Z');



INSERT INTO `fhirstarter`.`cc_codeableconcept` (`id`) VALUES ('PRHCC'), ('PRHCC2');


INSERT INTO `fhirstarter`.`com_communication` (`id`, `com_pr_id`, `com_language`) VALUES ('com01', 'f005', 'PRHCC');


INSERT INTO `fhirstarter`.`co_coding` (`id`, `co_cc_id`, `co_system`, `co_code`, `co_display`) VALUES ('co1', 'PRHCC', 'urn:ietf:bcp:47', 'fr', 'France');

INSERT INTO `fhirstarter`.`qu_qualification` (`id`, `qu_pr_id`, `qu_cc_id`, `qu_pe_id`) VALUES ('qu1', 'f005', 'PRHCC', 'pe1'), ('qu2', 'f005', 'PRHCC2', 'pe2');

INSERT INTO `fhirstarter`.`co_coding` (`id`, `co_cc_id`, `co_system`, `co_code`, `co_display`, `co_user_selected`) VALUES ('co2', 'PRHCC', 'https://fhir.cerner.com/ec2458f2-1e24-41c8-b71b-0e701af7583d/codeSet/29600', '677091', 'MD', 1), ('co3', 'PRHCC', 'https://fhir.cerner.com/ec2458f2-1e24-41c8-b71b-0e701af7583d/codeSet/29600', '677079', 'PhD', 1);


INSERT INTO `fhirstarter`.`pe_period` (`pe_start`, `id`) VALUES ('2014-07-09 06:00:00','pe1'), ('2014-07-09 06:00:00','pe2');

-- Inserts für na_narrative
INSERT INTO `fhirstarter`.`na_narrative` (`id`, `na_div`, `na_status`)VALUES('na01', '<div xmlns=\"http://www.w3.org/1999/xhtml\"><p><b>Generated Narrative</b></p><div style=\"display: inline-block; background-color: #d9e0e7; padding: 6px; margin: 4px; border: 1px solid #8da1b4; border-radius: 5px; line-height: 60%\"><p style=\"margin-bottom: 0px\">Resource &quot;f005&quot; </p></div><p><b>identifier</b>: id: 118265112 (OFFICIAL), id: 191REW8WE916 (USUAL)</p><p><b>name</b>: Langeveld Anne (OFFICIAL)</p><p><b>telecom</b>: ph: 0205563847(WORK), <a href=\"mailto:a.langeveld@bmc.nl\">a.langeveld@bmc.nl</a>, fax: 0205668916(WORK)</p><p><b>address</b>: Galapagosweg 9 Amsterdam 1105 AZ NLD (WORK)</p><p><b>gender</b>: female</p><p><b>birthDate</b>: 1959-03-11</p><p><b>communication</b>: France <span style=\"background: LightGoldenRodYellow; margin: 4px; border: 1px solid khaki\"> (<a href=\"http://terminology.hl7.org/3.1.0/CodeSystem-v3-ietf3066.html\">Tags for the Identification of Languages</a>#fr)</span></p></div>', 'generated');


SET FOREIGN_KEY_CHECKS = 1;










    SET FOREIGN_KEY_CHECKS = 0;

-- Inserts für pr_practitioner
INSERT INTO `fhirstarter`.`pr_practitioner` (`id`, `pr_gender`, `pr_birthdate`, `dr_na_id`) VALUES ('f006', 'male', '1980-05-15', 'na02');

-- Inserts für id_identifier
INSERT INTO `fhirstarter`.`id_identifier` (`id`, `id_pr_id`, `id_use`, `id_system`, `id_value`) VALUES ('i03', 'f006', 'official', 'urn:oid:2.16.528.1.1007.3.1', '123456789'), ('i04', 'f006', 'usual', 'urn:oid:2.16.840.1.113883.2.4.6.3', '987654321');

-- Inserts für hn_human_name
INSERT INTO `fhirstarter`.`hn_human_name` (`id`, `hn_pr_id`, `hn_use`, `hn_family`) VALUES ('h006', 'f006', 'official', 'Müller');

-- Inserts für hn_gi_given
INSERT INTO `fhirstarter`.`hn_gi_given` (`given`, `human_name_id`) VALUES ('Max', 'h006');

-- Inserts für hn_sf_suffix
INSERT INTO `fhirstarter`.`hn_sf_suffix` (`human_name_id`, `suffix`) VALUES ('h006', 'MD');

-- Inserts für cp_contatactpoint
INSERT INTO `fhirstarter`.`cp_contactpoint` (`id`, `cp_pr_id`, `cp_systemcode`, `cp_value`, `cp_contactkind`) VALUES ('cp04', 'f006', 'phone', '0123456789', 'work'), ('cp05', 'f006', 'email', 'm.mueller@example.com', 'work'), ('cp06', 'f006', 'fax', '9876543210', 'work');

-- Inserts für ad_address
INSERT INTO `fhirstarter`.`ad_address` (`ad_pr_id`, `id`, `ad_usecode`, `ad_city`, `ad_postal_code`, `ad_country`) VALUES ('f006', 'a006', 'work', 'Wien', '1010', 'AUT');

-- Füge eine Zeile in die `ad_line` Tabelle ein und verknüpfe sie mit der Adresse
INSERT INTO `fhirstarter`.`ad_line` (`address_id`, `line`) VALUES ('a006', 'Stephansplatz 1');

-- Inserts für at_attachment
INSERT INTO `fhirstarter`.`at_attachment` (`id`, `at_pr_id`, `at_content_type`, `at_data`) VALUES ('at03', 'f006', 'jpeg', '/aefdafasZ');

-- Inserts für cc_codeableconcept
INSERT INTO `fhirstarter`.`cc_codeableconcept` (`id`) VALUES ('PRHCC3'), ('PRHCC4');

-- Inserts für com_communication
INSERT INTO `fhirstarter`.`com_communication` (`id`, `com_pr_id`, `com_language`) VALUES ('com02', 'f006', 'PRHCC3');

-- Inserts für co_coding
INSERT INTO `fhirstarter`.`co_coding` (`id`, `co_cc_id`, `co_system`, `co_code`, `co_display`) VALUES ('co4', 'PRHCC3', 'urn:ietf:bcp:47', 'de', 'Germany');

-- Inserts für qu_qualification
INSERT INTO `fhirstarter`.`qu_qualification` (`id`, `qu_pr_id`, `qu_cc_id`, `qu_pe_id`) VALUES ('qu3', 'f006', 'PRHCC3', 'pe3'), ('qu4', 'f006', 'PRHCC4', 'pe4');

-- Inserts für co_coding
INSERT INTO `fhirstarter`.`co_coding` (`id`, `co_cc_id`, `co_system`, `co_code`, `co_display`, `co_user_selected`) VALUES ('co5', 'PRHCC3', 'https://fhir.cerner.com/ec2458f2-1e24-41c8-b71b-0e701af7583d/codeSet/29600', '123456', 'MD', 1), ('co6', 'PRHCC3', 'https://fhir.cerner.com/ec2458f2-1e24-41c8-b71b-0e701af7583d/codeSet/29600', '654321', 'PhD', 1);

-- Inserts für pe_period
INSERT INTO `fhirstarter`.`pe_period` (`pe_start`, `id`) VALUES ('2000-01-01 00:00:00','pe3'), ('2000-01-01 00:00:00','pe4');

-- Inserts für na_narrative
INSERT INTO `fhirstarter`.`na_narrative` (`id`, `na_div`, `na_status`)VALUES('na02', '<div xmlns=\"http://www.w3.org/1999/xhtml\"><p><b>Generated Narrative</b></p><div style=\"display: inline-block; background-color: #d9e0e7; padding: 6px; margin: 4px; border: 1px solid #8da1b4; border-radius: 5px; line-height: 60%\"><p style=\"margin-bottom: 0px\">Resource "f006" </p></div><p><b>identifier</b>: id: 123456789 (OFFICIAL), id: 987654321 (USUAL)</p><p><b>name</b>: Müller Max (OFFICIAL)</p><p><b>telecom</b>: ph: 0123456789(WORK), <a href=\"mailto:m.mueller@example.com\">m.mueller@example.com</a>, fax: 9876543210(WORK)</p><p><b>address</b>: Stephansplatz 1 Wien 1010 AUT (WORK)</p><p><b>gender</b>: male</p><p><b>birthDate</b>: 1980-05-15</p><p><b>communication</b>: Germany <span style=\"background: LightGoldenRodYellow; margin: 4px; border: 1px solid khaki\"> (<a href=\"http://terminology.hl7.org/3.1.0/CodeSystem-v3-ietf3066.html\">Tags for the Identification of Languages</a>#de)</span></p></div>', 'generated');

SET FOREIGN_KEY_CHECKS = 1;

-- ENDE Stand (12.09.2024)

-- Encounter

-- Encounter

-- Deaktivieren der Fremdschlüsselprüfung vor dem Import
SET FOREIGN_KEY_CHECKS = 0;

-- Narrative Beschreibung des Encounters
INSERT INTO `na_narrative` (`id`, `na_div`, `na_status`) VALUES ('f201', '<div xmlns="http://www.w3.org/1999/xhtml"><p><b>Generated Narrative</b></p><div style="display: inline-block; background-color: #d9e0e7; padding: 6px; margin: 4px; border: 1px solid #8da1b4; border-radius: 5px; line-height: 60%"><p style="margin-bottom: 0px">Resource &quot;f201&quot; </p></div><p><b>identifier</b>: id: Encounter_Roel_20130404 (TEMP)</p><p><b>status</b>: finished</p><p><b>class</b>: ambulatory (Details: http://terminology.hl7.org/CodeSystem/v3-ActCode code AMB = \'ambulatory\', stated as \'ambulatory\')</p><p><b>type</b>: Consultation <span style="background: LightGoldenRodYellow; margin: 4px; border: 1px solid khaki"> (<a href="https://browser.ihtsdotools.org/">SNOMED CT</a>#11429006)</span></p><p><b>priority</b>: Normal <span style="background: LightGoldenRodYellow; margin: 4px; border: 1px solid khaki"> (<a href="https://browser.ihtsdotools.org/">SNOMED CT</a>#17621005)</span></p><p><b>subject</b>: <a href="patient-f201.html">Patient/f201: Roel</a> &quot;Roel&quot;</p><h3>Participants</h3><table class="grid"><tr><td>-</td><td><b>Actor</b></td></tr><tr><td>*</td><td><a href="practitioner-f201.html">Practitioner/f201</a> &quot;Dokter Bronsig&quot;</td></tr></table><p><b>serviceProvider</b>: <a href="organization-f201.html">Organization/f201</a> &quot;Artis University Medical Center (AUMC)&quot;</p></div>', 'generated');

-- Identifier für den Encounter
INSERT INTO `id_identifier` (`id`, `id_use`, `id_value`) VALUES ('f201', 'temp', 'Encounter_Roel_20130404');

-- Das ist der Encounter
INSERT INTO `en_encounter` (`id`, `dr_na_id`, `en_episodeofcare_re_id`, `en_partof_re_id`, `en_pe_id`, `en_reasonreference_re_id`, `en_subject_re_id`, `en_status`) VALUES ('f201', 'f201',  NULL, 'f203', 'f201', NULL, 'f201', 'finished');

-- Appointment für den Encounter
INSERT INTO `re_reference` (`id`, `re_en_id`, `re_reference`) VALUES ('f202', 'f201', 'Appointment/example');

-- Statusverlauf des Encounters
INSERT INTO `sh_statushistory` (`id`, `sh_en_id`, `sh_pe_id`, `sh_status`) VALUES ('f201', 'f201', 'f201', 'in_progress');

INSERT INTO `pe_period` (`id`, `pe_start`) VALUES ('f201', '2013-03-08 00:00:00');

-- Teilnehmer am Encounter
INSERT INTO `pp_participant` (`id`, `pp_individual_re_id`, `pp_pe_id`) VALUES ('f201', 'f201', NULL);

-- Insert für die Tabelle re_reference
-- Dies wird benötigt, um auf die Referenz in der di_diagnosis Tabelle zu verweisen

INSERT INTO `re_reference` (`id`, `re_reference`, `re_type`, `re_display`, `re_id_id`) VALUES ('re_ref1', 'Complications from Roel\'s TPF chemotherapy on January 28th, 2013', 'Condition', 'Complications from Roel\'s TPF chemotherapy on January 28th, 2013', 'id1');

INSERT INTO `re_reference` (`id`, `re_reference`, `re_type`, `re_display`, `re_id_id`) VALUES ('re_ref2', 'The patient is treated for a tumor', 'Condition', 'The patient is treated for a tumor', 'id2');

-- Insert für die Tabelle cc_codeableconcept
-- Dies wird benötigt, um auf die CodeableConcept-Daten in der di_diagnosis Tabelle zu verweisen

INSERT INTO `cc_codeableconcept` (`id`, `cc_text`) VALUES ('cc1', 'Admission diagnosis'), ('cc2', 'Chief complaint');

-- Insert für die Tabelle di_diagnosis
-- Hier werden die Diagnosen basierend auf den Referenzen und CodeableConcepts eingefügt

INSERT INTO `di_diagnosis` (`id`, `di_condition_re_id`, `cc_di_id`, `di_rank`) VALUES ('diag1', 're_ref1', 'cc1', 2),('diag2', 're_ref2', 'cc2', 1);

-- Aktivieren der Fremdschlüsselprüfung nach dem Import
SET FOREIGN_KEY_CHECKS = 1;

