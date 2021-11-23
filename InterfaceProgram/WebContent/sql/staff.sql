DROP TABLE STAFF;

CREATE TABLE STAFF

(

    SNO VARCHAR2(5) PRIMARY KEY,  -- 사원번호

    NAME VARCHAR2(32),  -- 사원명

    DEPT VARCHAR2(20),  -- 부서명

    REGDATE DATE  -- 입사일자

);

INSERT INTO STAFF VALUES ('11111', '김사장', '기획부', SYSDATE);

COMMIT