DROP TABLE BOOK;
CREATE TABLE BOOK
(
    NO NUMBER PRIMARY KEY,
    TITLE VARCHAR2(100),
    PREVIEW VARCHAR2(1000),
    AUTHOR VARCHAR2(100),
    PRICE NUMBER
);

DROP SEQUENCE BOOK_SEQ;
CREATE SEQUENCE BOOK_SEQ NOCACHE;