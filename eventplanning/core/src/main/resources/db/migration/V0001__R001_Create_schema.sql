-- This is the SQL script for setting up the DDL for the h2 database
-- In a typical project you would only distinguish between main and test for flyway SQLs
-- However, in this sample application we provde support for multiple databases in parallel
-- You can simply choose the DB of your choice by setting spring.profiles.active=XXX in config/application.properties
-- Assuming that the preconfigured user exists with according credentials using the included SQLs

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1000000;

-- *** Talk ***
CREATE TABLE TALK(
    id NUMBER(19, 0) NOT NULL,
    modificationCounter INTEGER NOT NULL,
    title VARCHAR(255),
    speakerfirstname VARCHAR(255),
    speakerlastname VARCHAR(255)
);
ALTER TABLE TALK ADD CONSTRAINT PK_TALK PRIMARY KEY(id);
ALTER TABLE TALK ADD CONSTRAINT UC_TITLE UNIQUE(title);

-- *** TimeSlot ***
CREATE TABLE TIMESLOT(
    id NUMBER(19, 0) NOT NULL,
    modificationCounter INTEGER NOT NULL,
    FOO TIMESTAMP,
    BAR TIMESTAMP
);
ALTER TABLE TIMESLOT ADD CONSTRAINT PK_TIMESLOT PRIMARY KEY(id);


-- *** BinaryObject (BLOBs) ***
CREATE TABLE BINARYOBJECT (
  ID                    NUMBER(19, 0) NOT NULL,
  MODIFICATIONCOUNTER   NUMBER(19, 0) NOT NULL,
  DATA                  BLOB,
  "SIZE"                NUMBER(19, 0) NOT NULL,
  MIMETYPE              VARCHAR(255)
);

ALTER TABLE BINARYOBJECT ADD CONSTRAINT PK_BOBJ PRIMARY KEY (ID);

-- *** RevInfo (Commit log for envers audit trail) ***
CREATE TABLE REVINFO (
    ID                  NUMBER(19, 0)  NOT NULL,
    TIMESTAMP           NUMBER(19, 0)  NOT NULL,
    "USER"              VARCHAR(255)
);


