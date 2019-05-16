DROP LOGIN springuser;
CREATE LOGIN springuser WITH PASSWORD = 'ThePassword1'

DROP DATABASE IF EXISTS springuser;
CREATE DATABASE springuser;

USE springuser;
DROP USER IF EXISTS springuser;
CREATE USER springuser FOR LOGIN springuser;

ALTER ROLE db_ddladmin ADD MEMBER springuser
ALTER ROLE db_datareader ADD MEMBER springuser
ALTER ROLE db_datawriter ADD MEMBER springuser