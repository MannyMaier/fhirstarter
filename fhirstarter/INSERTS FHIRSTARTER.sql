SET FOREIGN_KEY_CHECKS = 0;

-- Inserts für pr_practitioner
INSERT INTO `pr_practitioner` (`id`, `pr_gender`, `pr_birthdate`) 
VALUES ('f005', 'female', '1959-03-11');

-- Inserts für id_identifier
INSERT INTO `id_identifier` (`id`, `id_pr_id`, `id_use`, `id_system`, `id_value`)
VALUES ('i01', 'f005', 'official', 'urn:oid:2.16.528.1.1007.3.1', '118265112'), ('i02', 'f005', 'usual', 'urn:oid:2.16.840.1.113883.2.4.6.3', '191REW8WE916');

-- Inserts für hn_human_name
INSERT INTO `hn_human_name` (`id`, `hn_pr_id`, `hn_statuscode`, `hn_family`) 
VALUES ('h005', 'f005', 'official', 'Anne');

-- Inserts für human_name_given
INSERT INTO `human_name_given` (`given`, `human_name_id`) 
VALUES ('Langeveld', 'h005');

-- Inserts für human_name_suffix
INSERT INTO `human_name_suffix` (`human_name_id`, `suffix`) 
VALUES ('h005', 'MD');

-- Inserts für cp_contatactpoint
INSERT INTO `cp_contactpoint` (`id`, `cp_pr_id`, `cp_systemcode`, `cp_value`, `cp_contactkind`) 
VALUES ('cp01', 'f005', 'phone', '0205563847', 'work'), ('cp02', 'f005', 'email', 'a.langeveld@bmc.nl', 'work'), ('cp03', 'f005', 'fax', '0205668916', 'work');

-- Inserts für ad_address
INSERT INTO `ad_address` (`ad_pr_id`, `id`, `ad_usecode`, `ad_city`, `ad_postal_code`, `ad_country`) 
VALUES ('f005', 'a005', 'work', 'Amsterdam', '1105 AZ', 'NLD');


-- Füge eine Zeile in die `ad_line` Tabelle ein und verknüpfe sie mit der Adresse
INSERT INTO `ad_line` (`address_id`, `line`)
VALUES ('a005', 'Galapagosweg 9');



INSERT INTO `at_attachment` (`at_pr_id`, `at_content_type`, `at_data`)
VALUES ('f005', 'jpeg', "MEIN FOTO");


INSERT INTO `cc_codeableconcept` (`id`)
VALUES ('PRHCC'), ('PRHCC2');


INSERT INTO `com_communication` (`com_pr_id`, `com_language`)
VALUES ('f005', 'PRHCC');


INSERT INTO `co_coding` (`id`, `co_cc_id`, `co_system`, `co_code`, `co_display`)
VALUES ('co1', 'PRHCC', 'urn:ietf:bcp:47', 'fr', 'France');

INSERT INTO `qu_qualification` (`id`, `qu_pr_id`, `qu_cc_id`, `qu_pe_id`)
VALUES ('qu1', 'f005', 'PRHCC', 'pe1'), ('qu2', 'f005', 'PRHCC2', 'pe2');

INSERT INTO `co_coding` (`id`, `co_cc_id`, `co_system`, `co_code`, `co_display`, `co_user_selected`)
VALUES ('co2', 'PRHCC', 'https://fhir.cerner.com/ec2458f2-1e24-41c8-b71b-0e701af7583d/codeSet/29600', '677091', 'MD', 1), ('co3', 'PRHCC', 'https://fhir.cerner.com/ec2458f2-1e24-41c8-b71b-0e701af7583d/codeSet/29600', '677079', 'PhD', 1);


INSERT INTO `pe_period` (`pe_start`, `id`) VALUES ('2014-07-09 06:00:00','pe1'), ('2014-07-09 06:00:00','pe2');

SET FOREIGN_KEY_CHECKS = 1;

