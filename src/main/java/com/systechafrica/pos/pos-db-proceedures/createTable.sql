USE pos_db;
DROP TABLE posTable;
CREATE TABLE
    posTable(
        userName VARCHAR(50)  NOT NULL,
        pass VARCHAR(50) NOT NULL,
        transactionId VARCHAR(50) DEFAULT NULL,
        transactionCost DOUBLE DEFAULT 0.0,
        transactionTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

    