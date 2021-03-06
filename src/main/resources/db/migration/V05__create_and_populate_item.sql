CREATE TABLE ITEM(
ID BIGINT PRIMARY KEY,
ITEM_NAME VARCHAR(50) not null,
BASKET_ID BIGINT not null,
DONE BOOLEAN not null,
DESCRIPTION VARCHAR(255),
COUNT INT
);

ALTER TABLE ITEM ADD CONSTRAINT FK_ITEM_ITEM_LIST FOREIGN KEY (BASKET_ID) REFERENCES BASKET(ID) ON DELETE CASCADE;

INSERT INTO ITEM (ID, ITEM_NAME, BASKET_ID, DONE, DESCRIPTION, COUNT) VALUES (90000000000000000, 'Jajo', 90000000000000000, false, 'Smaczne jajeczka na jajecznice', 10);
INSERT INTO ITEM (ID, ITEM_NAME, BASKET_ID, DONE) VALUES (90000000000000001, 'Schoki', 90000000000000000, false);
INSERT INTO ITEM (ID, ITEM_NAME, BASKET_ID, DONE) VALUES (90000000000000002, 'Skarpetka', 90000000000000000, true);