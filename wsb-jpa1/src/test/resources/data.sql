-- Clear existing data
DELETE
FROM DOCTOR_ADDRESS_MAPPING;
DELETE
FROM PATIENT_ADDRESS_MAPPING;
DELETE
FROM MEDICAL_TREATMENT;
DELETE
FROM VISIT;
DELETE
FROM PATIENT;
DELETE
FROM DOCTOR;
DELETE
FROM ADDRESS;

-- Reset auto-increment (if necessary)
ALTER TABLE ADDRESS
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE DOCTOR
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE PATIENT
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE VISIT
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE MEDICAL_TREATMENT
    ALTER COLUMN id RESTART WITH 1;

-- Insert new data
INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES (1, 'ul. Zielona 10', 'apt. 8', 'Warszawa', '00-123'),
       (2, 'ul. Czarnoleska 5', NULL, 'Kraków', '31-002'),
       (3, 'ul. Łąkowa 12', NULL, 'Gdańsk', '80-987'),
       (4, 'ul. Wodna 8', NULL, 'Gdynia', '81-456'),
       (5, 'ul. Szeroka 15', NULL, 'Poznań', '61-789'),
       (6, 'ul. Biała 18', 'apt. 4', 'Wrocław', '50-234'),
       (7, 'ul. Słoneczna 3', NULL, 'Katowice', '40-654'),
       (8, 'ul. Jesienna 22', NULL, 'Łódź', '90-111'),
       (9, 'ul. Wiosenna 17', NULL, 'Szczecin', '70-222'),
       (10, 'ul. Parkowa 19', NULL, 'Gdynia', '81-321'),
       (11, 'ul. Jesionowa 6', 'apt. 1', 'Poznań', '61-654'),
       (12, 'ul. Morska 13', NULL, 'Warszawa', '01-456'),
       (13, 'ul. Lipowa 4', NULL, 'Kraków', '30-555'),
       (14, 'ul. Leśna 9', NULL, 'Gdańsk', '80-444'),
       (15, 'ul. Plażowa 20', NULL, 'Szczecin', '70-789'),
       (16, 'ul. Żeglarska 23', 'apt. 7', 'Katowice', '40-987'),
       (17, 'ul. Piaskowa 14', NULL, 'Łódź', '90-432'),
       (18, 'ul. Tęczowa 11', NULL, 'Wrocław', '50-789'),
       (19, 'ul. Górnicza 16', NULL, 'Poznań', '61-222'),
       (20, 'ul. Polna 7', NULL, 'Gdynia', '81-876'),
       (21, 'ul. Tatrzańska 45', 'apt. 2', 'Zakopane', '34-500'),
       (22, 'ul. Zielona Dolina 4', NULL, 'Kielce', '25-500'),
       (23, 'ul. Górska 8', NULL, 'Rzeszów', '35-001'),
       (24, 'ul. Widokowa 6', NULL, 'Lublin', '20-123'),
       (25, 'ul. Spacerowa 12', 'apt. 5', 'Białystok', '15-666'),
       (26, 'ul. Miodowa 7', 'apt. 3', 'Warszawa', '00-789'),
       (27, 'ul. Poziomkowa 1', NULL, 'Katowice', '40-222'),
       (28, 'ul. Bałtycka 10', NULL, 'Gdańsk', '80-321'),
       (29, 'ul. Nadmorska 2', NULL, 'Gdynia', '81-222'),
       (30, 'ul. Łąkowa 11', NULL, 'Poznań', '61-999');

-- Insert doctors
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (1, 'Tomasz', 'Nowak', '123456123', 'tomasz.nowak@example.com', 'D321', 'GP'),
       (2, 'Ewelina', 'Kowalska', '555666777', 'ewelina.kowalska@example.com', 'D322', 'DERMATOLOGIST'),
       (3, 'Andrzej', 'Nowak', '888999000', 'andrzej.nowak@example.com', 'D323', 'OCULIST'),
       (4, 'Katarzyna', 'Zielinska', '999888777', 'katarzyna.zielinska@example.com', 'D324', 'SURGEON'),
       (5, 'Michał', 'Kowalski', '222333444', 'michal.kowalski@example.com', 'D325', 'GP'),
       (6, 'Anna', 'Nowakowska', '333444555', 'anna.nowakowska@example.com', 'D326', 'DERMATOLOGIST'),
       (7, 'Maria', 'Kaminska', '444555666', 'maria.kaminska@example.com', 'D327', 'OCULIST'),
       (8, 'Krzysztof', 'Wojcik', '555666777', 'krzysztof.wojcik@example.com', 'D328', 'SURGEON'),
       (9, 'Magdalena', 'Zajac', '666777888', 'magdalena.zajac@example.com', 'D329', 'GP'),
       (10, 'Piotr', 'Wojciechowski', '777888999', 'piotr.wojciechowski@example.com', 'D330', 'DERMATOLOGIST'),
       (11, 'Joanna', 'Krawczyk', '888999000', 'joanna.krawczyk@example.com', 'D331', 'OCULIST'),
       (12, 'Tomasz', 'Kowal', '999000111', 'tomasz.kowal@example.com', 'D332', 'SURGEON'),
       (13, 'Marcin', 'Piotrowski', '000111222', 'marcin.piotrowski@example.com', 'D333', 'GP'),
       (14, 'Barbara', 'Dabrowska', '111222333', 'barbara.dabrowska@example.com', 'D334', 'DERMATOLOGIST'),
       (15, 'Pawel', 'Kowalczyk', '222333444', 'pawel.kowalczyk@example.com', 'D335', 'OCULIST'),
       (16, 'Marta', 'Wroblewska', '333444555', 'marta.wroblewska@example.com', 'D336', 'SURGEON'),
       (17, 'Sylwia', 'Wojcik', '444555666', 'sylwia.wojcik@example.com', 'D337', 'GP'),
       (18, 'Jacek', 'Zielinski', '555666777', 'jacek.zielinski@example.com', 'D338', 'DERMATOLOGIST'),
       (19, 'Agnieszka', 'Maj', '666777888', 'agnieszka.maj@example.com', 'D339', 'OCULIST'),
       (20, 'Karolina', 'Sikora', '777888999', 'karolina.sikora@example.com', 'D340', 'SURGEON'),
       (21, 'Ewa', 'Pawlowska', '888999000', 'ewa.pawlowska@example.com', 'D341', 'GP'),
       (22, 'Marek', 'Michalski', '999000111', 'marek.michalski@example.com', 'D342', 'DERMATOLOGIST'),
       (23, 'Tomasz', 'Krawczyk', '000111222', 'tomasz.krawczyk@example.com', 'D343', 'OCULIST'),
       (24, 'Jan', 'Król', '111222333', 'jan.krol@example.com', 'D344', 'SURGEON'),
       (25, 'Dorota', 'Stankiewicz', '222333444', 'dorota.stankiewicz@example.com', 'D345', 'GP'),
       (26, 'Rafal', 'Nowicki', '333444555', 'rafal.nowicki@example.com', 'D346', 'DERMATOLOGIST'),
       (27, 'Michal', 'Gorski', '444555666', 'michal.gorski@example.com', 'D347', 'OCULIST'),
       (28, 'Radoslaw', 'Maj', '654321987', 'radoslaw.maj@example.com', 'D348', 'DERMATOLOGIST'),
       (29, 'Anna', 'Ostrowska', '852456123', 'anna.ostrowska@example.com', 'D349', 'OCULIST'),
       (30, 'Katarzyna', 'Lewandowska', '852852852', 'katarzyna.lewandowska@example.com', 'D350', 'OCULIST');

-- Insert patients
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance)
VALUES (1, 'Piotr', 'Nowak', '111222444', 'piotr.nowak@example.com', 'P321', '1985-05-15', true),
       (2, 'Anna', 'Kowalska', '333444555', 'anna.kowalska@example.com', 'P322', '1990-08-20', false),
       (3, 'Jan', 'Wójcik', '444555666', 'jan.wojcik@example.com', 'P323', '1975-03-12', true),
       (4, 'Katarzyna', 'Zielińska', '555666777', 'katarzyna.zielinska@example.com', 'P324', '1982-07-25', true),
       (5, 'Michał', 'Kowalski', '666777888', 'michal.kowalski@example.com', 'P325', '1995-12-05', false),
       (6, 'Maria', 'Kamińska', '777888999', 'maria.kaminska@example.com', 'P326', '1987-11-23', true),
       (7, 'Krzysztof', 'Wójcik', '888999000', 'krzysztof.wojcik@example.com', 'P327', '1993-04-15', false),
       (8, 'Magdalena', 'Zając', '999000111', 'magdalena.zajac@example.com', 'P328', '1989-02-19', true),
       (9, 'Piotr', 'Wojciechowski', '000111222', 'piotr.wojciechowski@example.com', 'P329', '1992-06-30', false),
       (10, 'Joanna', 'Krawczyk', '111222333', 'joanna.krawczyk@example.com', 'P330', '1988-01-17', true),
       (11, 'Tomasz', 'Kowal', '222333444', 'tomasz.kowal@example.com', 'P331', '1991-05-22', true),
       (12, 'Marcin', 'Piotrowski', '333444555', 'marcin.piotrowski@example.com', 'P332', '1994-09-10', false),
       (13, 'Barbara', 'Dąbrowska', '444555666', 'barbara.dabrowska@example.com', 'P333', '1980-12-15', true),
       (14, 'Paweł', 'Kowalczyk', '555666777', 'pawel.kowalczyk@example.com', 'P334', '1996-07-28', false),
       (15, 'Marta', 'Wróblewska', '666777888', 'marta.wroblewska@example.com', 'P335', '1983-03-03', true),
       (16, 'Sylwia', 'Wójcik', '777888999', 'sylwia.wojcik@example.com', 'P336', '1997-10-20', false),
       (17, 'Jacek', 'Zieliński', '888999000', 'jacek.zielinski@example.com', 'P337', '1986-09-14', true),
       (18, 'Agnieszka', 'Maj', '999000111', 'agnieszka.maj@example.com', 'P338', '1990-06-24', false),
       (19, 'Karolina', 'Sikora', '000111222', 'karolina.sikora@example.com', 'P339', '1981-02-18', true),
       (20, 'Ewa', 'Pawłowska', '111222333', 'ewa.pawlowska@example.com', 'P340', '1993-11-11', false),
       (21, 'Marek', 'Michalski', '222333444', 'marek.michalski@example.com', 'P341', '1987-01-08', true),
       (22, 'Tomasz', 'Krawczyk', '333444555', 'tomasz.krawczyk@example.com', 'P342', '1998-08-06', false),
       (23, 'Jan', 'Król', '444555666', 'jan.krol@example.com', 'P343', '1982-12-31', true),
       (24, 'Dorota', 'Stankiewicz', '555666777', 'dorota.stankiewicz@example.com', 'P344', '1984-03-29', true),
       (25, 'Rafał', 'Nowicki', '666777888', 'rafal.nowicki@example.com', 'P345', '1995-10-02', false),
       (26, 'Michał', 'Górski', '777888999', 'michal.gorski@example.com', 'P346', '1986-04-12', true),
       (27, 'Radosław', 'Maj', '888999000', 'radoslaw.maj@example.com', 'P347', '1999-09-23', false),
       (28, 'Anna', 'Ostrowska', '999000111', 'anna.ostrowska@example.com', 'P348', '1981-11-30', true),
       (29, 'Ewelina', 'Kowalska', '000111222', 'ewelina.kowalska@example.com', 'P349', '1984-07-09', false),
       (30, 'Karolina', 'Wiśniewska', '111222333', 'karolina.wisniewska@example.com', 'P350', '1988-10-25', true);

-- Insert visits
INSERT INTO VISIT (id, description, time, PATIENT_ID, DOCTOR_ID)
VALUES (1, 'Badanie kontrolne', '2024-03-14 10:00:00', 1, 1),
       (2, 'EKG serca', '2024-03-14 11:00:00', 2, 2),
       (3, 'USG jamy brzusznej', '2024-03-15 09:00:00', 3, 3),
       (4, 'RTG klatki piersiowej', '2024-03-16 10:30:00', 4, 4),
       (5, 'USG nerek', '2024-03-17 08:00:00', 5, 5),
       (6, 'EKG wysiłkowe', '2024-03-18 12:00:00', 6, 6),
       (7, 'RTG głowy', '2024-03-19 14:00:00', 7, 7),
       (8, 'USG serca', '2024-03-20 09:30:00', 8, 8),
       (9, 'RTG nóg', '2024-03-21 13:00:00', 9, 9),
       (10, 'USG tarczycy', '2024-03-22 10:15:00', 10, 10),
       (11, 'EKG', '2024-03-23 11:45:00', 11, 11),
       (12, 'USG stawów', '2024-03-24 12:30:00', 12, 12),
       (13, 'RTG kręgosłupa', '2024-03-25 08:15:00', 13, 13),
       (14, 'USG jamy brzusznej', '2024-03-26 15:30:00', 14, 14),
       (15, 'EKG', '2024-03-27 11:00:00', 15, 15),
       (16, 'USG szyi', '2024-03-28 16:00:00', 16, 16),
       (17, 'RTG rąk', '2024-03-29 09:45:00', 17, 17),
       (18, 'USG jamy brzusznej', '2024-03-30 08:00:00', 18, 18),
       (19, 'EKG serca', '2024-03-31 10:30:00', 19, 19),
       (20, 'RTG klatki piersiowej', '2024-04-01 09:00:00', 20, 20),
       (21, 'USG tarczycy', '2024-04-02 12:00:00', 21, 21),
       (22, 'EKG', '2024-04-03 11:00:00', 22, 22),
       (23, 'USG serca', '2024-04-04 14:00:00', 23, 23),
       (24, 'RTG nóg', '2024-04-05 09:30:00', 24, 24),
       (25, 'USG szyi', '2024-04-06 10:15:00', 25, 25),
       (26, 'EKG wysiłkowe', '2024-04-07 13:00:00', 26, 26),
       (27, 'RTG głowy', '2024-04-08 12:30:00', 27, 27),
       (28, 'USG stawów', '2024-04-09 08:15:00', 28, 28),
       (29, 'EKG', '2024-04-10 15:30:00', 29, 29),
       (30, 'RTG klatki piersiowej', '2024-04-11 10:30:00', 30, 30);

-- Insert medical treatments
INSERT INTO MEDICAL_TREATMENT (id, description, type, VISIT_ID)
VALUES (1, 'USG serca', 'USG', 1),
       (2, 'EKG wysiłkowe', 'EKG', 2),
       (3, 'RTG klatki piersiowej', 'RTG', 3),
       (4, 'USG jamy brzusznej', 'USG', 4),
       (5, 'EKG serca', 'EKG', 5),
       (6, 'RTG głowy', 'RTG', 6),
       (7, 'USG tarczycy', 'USG', 7),
       (8, 'EKG wysiłkowe', 'EKG', 8),
       (9, 'RTG nóg', 'RTG', 9),
       (10, 'USG szyi', 'USG', 10),
       (11, 'EKG serca', 'EKG', 11),
       (12, 'RTG rąk', 'RTG', 12),
       (13, 'USG serca', 'USG', 13),
       (14, 'EKG serca', 'EKG', 14),
       (15, 'RTG kręgosłupa', 'RTG', 15),
       (16, 'USG jamy brzusznej', 'USG', 16),
       (17, 'EKG wysiłkowe', 'EKG', 17),
       (18, 'RTG klatki piersiowej', 'RTG', 18),
       (19, 'USG tarczycy', 'USG', 19),
       (20, 'EKG serca', 'EKG', 20),
       (21, 'RTG nóg', 'RTG', 21),
       (22, 'USG szyi', 'USG', 22),
       (23, 'EKG serca', 'EKG', 23),
       (24, 'RTG głowy', 'RTG', 24),
       (25, 'USG jamy brzusznej', 'USG', 25),
       (26, 'EKG serca', 'EKG', 26),
       (27, 'RTG klatki piersiowej', 'RTG', 27),
       (28, 'USG stawów', 'USG', 28),
       (29, 'EKG serca', 'EKG', 29),
       (30, 'RTG kręgosłupa', 'RTG', 30);

-- Map doctors to addresses
INSERT INTO DOCTOR_ADDRESS_MAPPING (doctor_id, address_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 8),
       (9, 9),
       (10, 10),
       (11, 11),
       (12, 12),
       (13, 13),
       (14, 14),
       (15, 15),
       (16, 16),
       (17, 17),
       (18, 18),
       (19, 19),
       (20, 20),
       (21, 21),
       (22, 22),
       (23, 23),
       (24, 24),
       (25, 25),
       (26, 26),
       (27, 27),
       (28, 28),
       (29, 29),
       (30, 30);

-- Map patients to addresses
INSERT INTO PATIENT_ADDRESS_MAPPING (patient_id, address_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 8),
       (9, 9),
       (10, 10),
       (11, 11),
       (12, 12),
       (13, 13),
       (14, 14),
       (15, 15),
       (16, 16),
       (17, 17),
       (18, 18),
       (19, 19),
       (20, 20),
       (21, 21),
       (22, 22),
       (23, 23),
       (24, 24),
       (25, 25),
       (26, 26),
       (27, 27),
       (28, 28),
       (29, 29),
       (30, 30);
