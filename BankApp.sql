--Banking Assignment sql

--create user
CREATE USER bankdb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO bankdb;
GRANT DBA TO bankdb WITH ADMIN OPTION;

--create necessary tables
CREATE TABLE userb(
    userid NUMBER NOT NULL
    , firstname VARCHAR2(20) NOT NULL
    , lastname VARCHAR2(20) NOT NULL
    , username VARCHAR2(30) NOT NULL
    , pword VARCHAR2(40) NOT NULL
    , CONSTRAINT PK_User PRIMARY KEY(userid)
);

CREATE TABLE adminb(
    adminid NUMBER NOT NULL
    , a_firstname VARCHAR2(20) NOT NULL
    , a_lastname VARCHAR2(20) NOT NULL
    , a_username VARCHAR2(30) NOT NULL
    , a_pword VARCHAR2(40) NOT NULL
    , CONSTRAINT PK_Admin PRIMARY KEY(adminid)
);

CREATE TABLE bankaccount(
    accountid NUMBER NOT NULL
    , username VARCHAR2(30) NOT NULL
    , balance NUMBER(15)
    , CONSTRAINT PK_Account PRIMARY KEY(accountid)
);
DROP TABLE bankaccount;
    
INSERT INTO userb VALUES(1, 'Ray', 'Williams', 'raywill8', '12345' );
INSERT INTO userb VALUES(2, 'Bri', 'Thornton', 'bthorn', '67890' );

INSERT INTO adminb VALUES(1, 'Lauren', 'Langford', 'laurenlangford', 'usf2001' );

INSERT INTO bankaccount VALUES(1, 'raywill8', 5000);
INSERT INTO bankaccount VALUES(2, 'bthorn', 2000);


CREATE SEQUENCE user_seq
    START WITH 6
    INCREMENT BY 2;
--DROP SEQUENCE user_seq
    
CREATE SEQUENCE account_seq
    START WITH 6
    INCREMENT BY 2;
--DROP SEQUENCE account_seq

CREATE OR REPLACE PROCEDURE insert_user_null_id(f_name IN VARCHAR2,
    l_name IN VARCHAR2, u_name IN VARCHAR2, p_word IN VARCHAR2)
IS
BEGIN
    INSERT INTO userb VALUES(user_seq.NEXTVAL, f_name, l_name, u_name, p_word);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE insert_acct_null_id(u_name IN VARCHAR2,
    amount IN NUMBER)
IS
BEGIN
    INSERT INTO bankaccount VALUES(account_seq.NEXTVAL, u_name, amount);
    COMMIT;
END;
/

    
CREATE OR REPLACE TRIGGER user_insertb
BEFORE INSERT ON userb
FOR EACH ROW
BEGIN
    IF :new.userid IS NULL THEN
        SELECT user_seq.NEXTVAL INTO :new.userid FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER account_insertb
BEFORE INSERT ON bankaccount
FOR EACH ROW
BEGIN
    IF :new.accountid IS NULL THEN
        SELECT account_seq.NEXTVAL INTO :new.accountid FROM dual;
    END IF;
END;
/

SELECT * FROM userb;
SELECT * FROM bankaccount;
SELECT * FROM adminb;







