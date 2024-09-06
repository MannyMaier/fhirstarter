INSERT INTO `fhirstarter`.`g_greeting` (`l`, `format`, `id`) VALUES ('1', 'simon', 'e3ew');
INSERT INTO `fhirstarter`.`g_greeting` (`l`, `format`, `id`) VALUES ('1', 'xy', 'e31q');
INSERT INTO `fhirstarter`.`g_greeting` (`l`, `format`, `id`) VALUES ('1', 'xy', 'er');
INSERT INTO `fhirstarter`.`g_greeting` (`l`, `format`, `id`) VALUES ('1', 'xy', '34');

INSERT INTO `fhirstarter`.`na_narrative` (`id`, `na_div`, `na_status`) VALUES ('34wersdf', '<div>Text</div>', 'generated');
INSERT INTO `fhirstarter`.`pa_patient` (`pa_active`, `dr_narrative_id`, `id`) VALUES (true, '34wersdf', 'wadca21');
INSERT INTO `fhirstarter`.`pa_patient` (`pa_active`, `dr_narrative_id`, `id`) VALUES (true, NULL, 'wesd23');
INSERT INTO `fhirstarter`.`pa_patient` (`pa_active`, `dr_narrative_id`, `id`) VALUES (false, NULL, 'wasdwa3');
INSERT INTO `fhirstarter`.`pa_patient` (`pa_active`, `dr_narrative_id`, `id`) VALUES (true, NULL, 'awedad2');

INSERT INTO `fhirstarter`.`at_at1plf` (`at_size`, `at_creation`, `at_id`, `at_title`) VALUES (1, "2005-01-01", 'as34tr23', 'Erster Titel');
INSERT INTO `fhirstarter`.`at_at1plf` (`at_size`, `at_creation`, `at_id`, `at_title`) VALUES (2, "2006-02-02", 'bh634e', 'Das ist ein zwieter Titel');
INSERT INTO `fhirstarter`.`at_at1plf` (`at_size`, `at_creation`, `at_id`, `at_title`) VALUES (3, "2005-03-03", 'zf25f2', 'Letzer Titel');

-- Inserts for table `ad_address`
INSERT INTO `ad_address` (`ad_period`, `ad_typecode`, `ad_usecode`, `city`, `country`, `district`, `id`, `pa_address`, `postal_code`, `state`, `text`) VALUES
                                                                                                                                                           ('1', 'both', 'home', 'Vienna', 'Austria', 'District 1', '1', '1', '1010', 'Vienna', 'Address 1'),
                                                                                                                                                           ('2', 'physical', 'work', 'Salzburg', 'Austria', 'District 2', '2', '2', '5020', 'Salzburg', 'Address 2');
-- Add more rows as needed

-- Inserts for table `address_line`
INSERT INTO `address_line` (`address_id`, `line`) VALUES
                                                      ('1', 'Line 1'),
                                                      ('2', 'Line 2');
-- Add more rows as needed

-- Inserts for table `at_at1plf`
INSERT INTO `at_at1plf` (`at_size`, `at_creation`, `at_id`, `at_title`) VALUES
                                                                            (100, '2023-12-23 18:56:31', '1', 'Title 1'),
                                                                            (200, '2023-12-23 18:56:31', '2', 'Title 2');
-- Add more rows as needed

-- Inserts for table `cc_codeableconcept`
INSERT INTO `cc_codeableconcept` (`cc_text`, `id`) VALUES
                                                       ('Text 1', '1'),
                                                       ('Text 2', '2');
-- Add more rows as needed

-- Inserts for table `co_coding`
INSERT INTO `co_coding` (`co_user_selected`, `cc_coding`, `co_code`, `co_display`, `co_system`, `co_version`, `id`) VALUES
                                                                                                                        (1, '1', 'Code 1', 'Display 1', 'System 1', 'Version 1', '1'),
                                                                                                                        (0, '2', 'Code 2', 'Display 2', 'System 2', 'Version 2', '2');
-- Add more rows as needed

-- Inserts for table `cp_contatactpoint`
INSERT INTO `cp_contatactpoint` (`rank`, `cp_contactkind`, `cp_period`, `cp_systemcode`, `id`, `pa_telecom`, `value`) VALUES
                                                                                                                          (1, 'home', '1', 'email', '1', '1', 'Value 1'),
                                                                                                                          (2, 'work', '2', 'phone', '2', '2', 'Value 2');
-- Add more rows as needed

-- Inserts for table `g_greeting`
INSERT INTO `g_greeting` (`l`, `format`, `id`) VALUES
                                                   (1, 'Format 1', '1'),
                                                   (2, 'Format 2', '2');
-- Add more rows as needed

-- Inserts for table `hn_human_name`
INSERT INTO `hn_human_name` (`hn_family`, `hn_period`, `hn_statuscode`, `id`, `pa_name`, `hn_text`) VALUES
                                                                                                        ('Müller', '1', 'official', '1', '1', 'Herr Müller'),
                                                                                                        ('Schmidt', '2', 'usual', '2', '2', 'Frau Schmidt');
-- Add more rows as needed

-- Inserts for table `human_name_given`
INSERT INTO `human_name_given` (`given`, `human_name_id`) VALUES
                                                              ('Max', '1'),
                                                              ('Anna', '2');
-- Add more rows as needed

-- Inserts for table `human_name_prefix`
INSERT INTO `human_name_prefix` (`human_name_id`, `prefix`) VALUES
                                                                ('1', 'Herr'),
                                                                ('2', 'Frau');
-- Add more rows as needed

-- Inserts for table `human_name_suffix`
INSERT INTO `human_name_suffix` (`human_name_id`, `suffix`) VALUES
                                                                ('1', 'Jr.'),
                                                                ('2', 'Sr.');
-- Add more rows as needed

-- Inserts for table `id_identifier`
INSERT INTO `id_identifier` (`i_cc_id`, `i_pe_id`, `i_re_id`, `i_system`, `i_value`, `id`, `id_patient_id`, `id_use`) VALUES
                                                                                                                          ('1', '1', '1', 'System 1', 'Value 1', '1', '1', 'official'),
                                                                                                                          ('2', '2', '2', 'System 2', 'Value 2', '2', '2', 'usual');
-- Add more rows as needed

-- Inserts for table `na_narrative`
INSERT INTO `na_narrative` (`id`, `na_div`, `na_status`) VALUES
                                                             ('1', 'Div 1', 'additional'),
                                                             ('2', 'Div 2', 'generated');
-- Add more rows as needed

-- Inserts for table `pa_patient`
INSERT INTO `pa_patient` (`pa_active`, `pa_deceasedboolean`, `birth_date`, `pa_deceaseddatetime`, `dr_narrative_id`, `id`, `pa_gender`) VALUES
                                                                                                                                            (1, 0, '2023-12-23 18:56:31', NULL, '1', '1', 'male'),
                                                                                                                                            (0, 1, '2023-12-23 18:56:31', '2023-12-23 18:56:31', '2', '2', 'female');
-- Add more rows as needed

-- Inserts for table `pe_period`
INSERT INTO `pe_period` (`end`, `start`, `id`) VALUES
                                                   ('2023-12-23 18:56:31', '2023-12-23 18:56:31', '1'),
                                                   ('2023-12-24 18:56:31', '2023-12-24 18:56:31', '2');
-- Add more rows as needed

-- Inserts for table `re_reference`
INSERT INTO `re_reference` (`id`, `re_display`, `re_id_identifier`, `re_reference`, `re_type`) VALUES
                                                                                                   ('1', 'Display 1', '1', 'Reference 1', 'Type 1'),


                                                                                                   ('2', 'Display 2', '2', 'Reference 2', 'Type 2');