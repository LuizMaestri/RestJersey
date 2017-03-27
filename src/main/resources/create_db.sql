CREATE TABLE USER(
  cod_entity BIGINT AUTO_INCREMENT PRIMARY KEY,
  dta_time_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  nme_user VARCHAR(20) UNIQUE NOT NULL,
  nme_password CHAR(64) NOT NULL,
  dsc_role INT,
  dsc_status INT
);

CREATE TABLE MACHINE(
  cod_entity BIGINT AUTO_INCREMENT PRIMARY KEY,
  dta_time_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  nme_machine VARCHAR(20) UNIQUE NOT NULL,
  vl_memory BIGINT NOT NULL,
  vl_hard_disc BIGINT NOT NULL
);

CREATE TABLE MACHINE_USER(
  cod_user BIGINT NOT NULL ,
  cod_machine BIGINT NOT NULL,
  nme_nickname VARCHAR(30) NOT NULL ,
  fl_active BOOLEAN DEFAULT FALSE
);

ALTER TABLE MACHINE_USER ADD CONSTRAINT fk_user FOREIGN KEY (cod_user) REFERENCES USER(cod_entity);
ALTER TABLE MACHINE_USER ADD CONSTRAINT fk_machine FOREIGN KEY (cod_machine) REFERENCES MACHINE(cod_entity);
