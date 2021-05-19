CREATE TABLE RESTAURANT_ORDER (
  ID                  BIGINT NOT NULL AUTO_INCREMENT,
  MODIFICATIONCOUNTER INTEGER NOT NULL,
  PRICE               DECIMAL(5, 2) NOT NULL,
  CREATION_DATE       TIMESTAMP WITH TIME ZONE NOT NULL,
  PAYMENT_DATE        TIMESTAMP WITH TIME ZONE,
  STATUS              VARCHAR(10) NOT NULL,
  PRIMARY KEY (ID)
);
