/*--
------------------------------------------------------
--  Create Table CAR
--------------------------------------------------------
*/
CREATE TABLE car (
  id_car                VARCHAR(36) NOT NULL,
  nm_assembler          VARCHAR(64) NOT NULL,
  nm_model              VARCHAR(64) NOT NULL,
  nr_manufacturing_year INT         NOT NULL,
  nr_model_year         INT         NOT NULL,
  CONSTRAINT PK_CAR PRIMARY KEY (id_car)
);