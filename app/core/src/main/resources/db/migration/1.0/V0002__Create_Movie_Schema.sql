--------------------------------------------------------
-- Description: create movie table
--------------------------------------------------------

CREATE TABLE MOVIE (
  ID      BIGINT NOT NULL,
  MODIFICATIONCOUNTER INTEGER NOT NULL,
  TITLE   VARCHAR2(255 CHAR) NOT NULL,
  GENRES  VARCHAR2(255 CHAR),
  YEAR    INTEGER,
  CONSTRAINT PK_MOVIE PRIMARY KEY(ID),
  CONSTRAINT UC_MOVIE_DUBLETTE UNIQUE (TITLE, YEAR)
);

