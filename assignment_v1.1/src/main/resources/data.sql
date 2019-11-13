INSERT INTO dentist ( first_name, last_name ) VALUES
                                                     ( 'Mart', 'Tamm' ),
                                                     ( 'Kati', 'Kuusk'),
                                                     ( 'Sam', 'Ree');
INSERT INTO person ( first_name, last_name, personal_code) VALUES
                                                                  ( 'Eerik', 'Juhuslik', '222222222' ),
                                                                  ( 'Riina', 'Kask', '222222222' ),
                                                                  ( 'Indra', 'Tuulik', '222222222' );
INSERT INTO dentist_visit ( visit_date, visit_time, dentist_id, person_id ) VALUES
                                                                                   ( '2019-11-21 00:00:00.0',
                                                                                    '2019-11-21 12:30:00.0',
                                                                                    1, 2),
                                                                                   ( '2020-03-14 00:00:00.0',
                                                                                     '2019-11-21 14:00:00.0',
                                                                                     2, 2),
                                                                                   ( '2020-12-01 00:00:00.0',
                                                                                     '2019-11-21 08:10:00.0',
                                                                                     3, 3);