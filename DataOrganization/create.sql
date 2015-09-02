CREATE TABLE ATTRIBUTE (ID BIGINT NOT NULL, attr_key VARCHAR(255), attr_value VARCHAR(255), VIEWNAME VARCHAR(255) NOT NULL, DIGIT_OBJ_ID VARCHAR(255) NOT NULL, STEPNOARRIVED BIGINT NOT NULL, PRIMARY KEY (ID, VIEWNAME, DIGIT_OBJ_ID, STEPNOARRIVED))
CREATE TABLE DATAORGANIZATIONNODE (VIEWNAME VARCHAR(255) NOT NULL, DIGIT_OBJ_ID VARCHAR(255) NOT NULL, STEPNOARRIVED BIGINT NOT NULL, type VARCHAR(31), DESCRIPTION VARCHAR(255), IDVERSION INTEGER, NAME VARCHAR(255), NODEDEPTH INTEGER, STEPNOLEAVED BIGINT, FULLYQUALIFIEDTYPENAME VARCHAR(255), VALUE VARCHAR(255), PRIMARY KEY (VIEWNAME, DIGIT_OBJ_ID, STEPNOARRIVED))
ALTER TABLE ATTRIBUTE ADD CONSTRAINT FK_ATTRIBUTE_VIEWNAME FOREIGN KEY (VIEWNAME, DIGIT_OBJ_ID, STEPNOARRIVED) REFERENCES DATAORGANIZATIONNODE (VIEWNAME, DIGIT_OBJ_ID, STEPNOARRIVED)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)