DROP TABLE IF EXISTS AUTHORITIES;
DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS(ID INT PRIMARY KEY, USERNAME VARCHAR(100) NOT NULL UNIQUE, PASSWORD VARCHAR(100) NOT NULL, FIRSTNAME VARCHAR(100), 
LASTNAME VARCHAR(100), ENABLED BOOLEAN, ACCOUNTLOCKED BOOLEAN, FAILEDATTEMPT INT, LOCKTIME DATE);

CREATE TABLE AUTHORITIES(
	USERNAME VARCHAR(100) NOT NULL,
	AUTHORITY VARCHAR(100) NOT NULL
);

ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_UNIQUE UNIQUE(USERNAME, AUTHORITY);
ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_FK1 FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME);