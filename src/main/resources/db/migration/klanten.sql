CREATE TABLE klant (
                         id                  BIGSERIAL                   NOT NULL,
                         voornaam          VARCHAR(50)                 NOT NULL,
                         achternaam           VARCHAR(50)                 NOT NULL,
                         klantnummer      VARCHAR(50) NOT NULL UNIQUE ,
                         gsm_nummer       VARCHAR(50),
                         email               VARCHAR(254),
                         bedrijf            VARCHAR(254),
                             CONSTRAINT klant_pk PRIMARY KEY (id)
                )
