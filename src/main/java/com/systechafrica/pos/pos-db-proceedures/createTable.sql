USE pos_db;
DROP TABLE posTable;
CREATE TABLE
    posTable(
        userName VARCHAR(50) PRIMARY KEY,
        pass VARCHAR(50),
        transactionId VARCHAR(50),
        transactedItems VARCHAR(100),
        transactionCost DOUBLE,
        transactionTime TIMESTAMP
    );

    