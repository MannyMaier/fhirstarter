-- Encounter

-- Deaktivieren der Fremdschlüsselprüfung vor dem Import
SET FOREIGN_KEY_CHECKS = 0;

-- Narrative Beschreibung des Encounters
INSERT INTO `na_narrative` (`id`, `na_div`, `na_status`)
VALUES ('f201',
        '<div xmlns="http://www.w3.org/1999/xhtml"><p><b>Generated Narrative</b></p><div style="display: inline-block; background-color: #d9e0e7; padding: 6px; margin: 4px; border: 1px solid #8da1b4; border-radius: 5px; line-height: 60%"><p style="margin-bottom: 0px">Resource &quot;f201&quot; </p></div><p><b>identifier</b>: id: Encounter_Roel_20130404 (TEMP)</p><p><b>status</b>: finished</p><p><b>class</b>: ambulatory (Details: http://terminology.hl7.org/CodeSystem/v3-ActCode code AMB = \'ambulatory\', stated as \'ambulatory\')</p><p><b>type</b>: Consultation <span style="background: LightGoldenRodYellow; margin: 4px; border: 1px solid khaki"> (<a href="https://browser.ihtsdotools.org/">SNOMED CT</a>#11429006)</span></p><p><b>priority</b>: Normal <span style="background: LightGoldenRodYellow; margin: 4px; border: 1px solid khaki"> (<a href="https://browser.ihtsdotools.org/">SNOMED CT</a>#17621005)</span></p><p><b>subject</b>: <a href="patient-f201.html">Patient/f201: Roel</a> &quot;Roel&quot;</p><h3>Participants</h3><table class="grid"><tr><td>-</td><td><b>Actor</b></td></tr><tr><td>*</td><td><a href="practitioner-f201.html">Practitioner/f201</a> &quot;Dokter Bronsig&quot;</td></tr></table><p><b>serviceProvider</b>: <a href="organization-f201.html">Organization/f201</a> &quot;Artis University Medical Center (AUMC)&quot;</p></div>',
        'generated');

-- Identifier für den Encounter
INSERT INTO `id_identifier` (`id`, `id_use`, `id_value`)
VALUES ('f201', 'temp', 'Encounter_Roel_20130404');

-- Das ist der Encounter
INSERT INTO `en_encounter` (`id`, `dr_na_id`, `en_appointment_re_id`, `en_episodeofcare_re_id`, `en_partof_re_id`,
                            `en_pe_id`, `en_reasonreference_re_id`, `en_subject_re_id`, `en_status`)
VALUES ('f201', 'f201', NULL, NULL, 'f203', NULL, NULL, 'f201', 'finished');

-- Statusverlauf des Encounters
INSERT INTO `sh_statushistory` (`id`, `sh_en_id`, `sh_pe_id`, `sh_status`)
VALUES ('f201', 'f201', 'f201', 'in_progress');

-- Teilnehmer am Encounter
INSERT INTO `pp_participant` (`id`, `pp_individual_re_id`, `pp_pe_id`)
VALUES ('f201', 'f201', NULL);

-- Insert für die Tabelle re_reference
-- Dies wird benötigt, um auf die Referenz in der di_diagnosis Tabelle zu verweisen

INSERT INTO `re_reference` (`id`, `re_reference`, `re_type`, `re_display`, `re_id_id`)
VALUES ('re_ref1', "Complications from Roel's TPF chemotherapy on January 28th, 2013", 'Condition', "Complications from Roel's TPF chemotherapy on January 28th, 2013", 'id1');

INSERT INTO `re_reference` (`id`, `re_reference`, `re_type`, `re_display`, `re_id_id`)
VALUES ('re_ref2', 'The patient is treated for a tumor', 'Condition', 'The patient is treated for a tumor', 'id2');

-- Insert für die Tabelle cc_codeableconcept
-- Dies wird benötigt, um auf die CodeableConcept-Daten in der di_diagnosis Tabelle zu verweisen

INSERT INTO `cc_codeableconcept` (`id`, `cc_text`)
VALUES ('cc1', 'Admission diagnosis'),
       ('cc2', 'Chief complaint');

-- Insert für die Tabelle di_diagnosis
-- Hier werden die Diagnosen basierend auf den Referenzen und CodeableConcepts eingefügt

INSERT INTO `di_diagnosis` (`id`, `di_condition_re_id`, `cc_di_id`, `di_rank`)
VALUES ('diag1', 're_ref1', 'cc1', 2),
       ('diag2', 're_ref2', 'cc2', 1);

-- Aktivieren der Fremdschlüsselprüfung nach dem Import
SET FOREIGN_KEY_CHECKS = 1;