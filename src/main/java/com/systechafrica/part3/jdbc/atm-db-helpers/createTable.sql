USE atm_db;
DROP TABLE membersTable;
CREATE TABLE
    membersTable(
         memberNumber INT PRIMARY KEY ,
        pass VARCHAR(100),
        userName VARCHAR(100),
        funds INT
    );