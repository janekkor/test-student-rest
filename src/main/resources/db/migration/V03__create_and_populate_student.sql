CREATE TABLE STUDENT(
ID BIGINT PRIMARY KEY,
FIRST_NAME VARCHAR(20) not null,
LAST_NAME VARCHAR(20) not null
);

INSERT INTO STUDENT (ID, FIRST_NAME, LAST_NAME) VALUES (90000000000000000, 'Andrea', 'Berger');
INSERT INTO STUDENT (ID, FIRST_NAME, LAST_NAME) VALUES (90000000000000001, 'Adam', 'Schmidt');
INSERT INTO STUDENT (ID, FIRST_NAME, LAST_NAME) VALUES (90000000000000002, 'Alex', 'Hinz');