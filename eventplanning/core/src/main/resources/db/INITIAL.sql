-- Create the initial table space
CREATE TABLESPACE EVENTPLANNING DATAFILE 'eventplanning.dbf'  SIZE 10m AUTOEXTEND ON NEXT 10m MAXSIZE 1000m;

-- Create the user: eventplanning
--DROP USER "EVENTPLANNING" CASCADE;
CREATE USER EVENTPLANNING IDENTIFIED BY EVENTPLANNING DEFAULT TABLESPACE EVENTPLANNING TEMPORARY TABLESPACE temp;
GRANT UNLIMITED TABLESPACE TO EVENTPLANNING;

GRANT CONNECT TO EVENTPLANNING;


-- Create the user: dbmig
--DROP USER "DBMIG_EP" CASCADE;
CREATE USER DBMIG_EP IDENTIFIED BY DBMIG_EP DEFAULT TABLESPACE EVENTPLANNING TEMPORARY TABLESPACE temp;

GRANT "DBA" TO DBMIG_EP;
