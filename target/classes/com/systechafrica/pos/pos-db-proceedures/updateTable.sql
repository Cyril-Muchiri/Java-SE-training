use pos_db;

SELECT * FROM postable;

DROP PROCEDURE IF EXISTS updateposTable;

CREATE PROCEDURE UPDATEPOSTABLE(IN TRANSACTIONID VARCHAR
(100), IN TRANSACTIONCOST DOUBLE) 
BEGIN 
	INSERT INTO
	    postable(
	        userName,
	        pass,
	        transactionId,
	        transactionCost
	    )
	VALUES (
	        "Muchiri",
	        "Admin123",
	        transactionId,
	        transactionCost
	    );
	END
