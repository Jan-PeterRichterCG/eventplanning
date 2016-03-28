-- This is the SQL script for setting up the DDL for the h2 database
-- In a typical project you would only distinguish between main and test for flyway SQLs
-- However, in this sample application we provde support for multiple databases in parallel
-- You can simply choose the DB of your choice by setting spring.profiles.active=XXX in config/application.properties
-- Assuming that the preconfigured user exists with according credentials using the included SQLs

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1000000;

-- *** Staffmemeber ***
CREATE TABLE TALK(
    id BIGINT NOT NULL,
    modificationCounter INTEGER NOT NULL,
    title VARCHAR(255),
    speakerfirstname VARCHAR(255),
    speakerlastname VARCHAR(255),
);
ALTER TABLE TALK ADD CONSTRAINT PK_TALK PRIMARY KEY(id);
ALTER TABLE TALK ADD CONSTRAINT UC_TITLE UNIQUE(title);


-- *** BinaryObject (BLOBs) ***
CREATE TABLE BINARYOBJECT (
  id BIGINT NOT NULL,
  modificationCounter INTEGER NOT NULL,
  data BLOB(2147483647),
  size BIGINT NOT NULL,
  mimetype VARCHAR(255),
  PRIMARY KEY (ID)
);

-- *** RevInfo (Commit log for envers audit trail) ***
CREATE TABLE REVINFO(
    id BIGINT NOT NULL generated by default as identity (start with 1),
    timestamp BIGINT NOT NULL,
    user VARCHAR(255)
);
