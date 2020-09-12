DROP TABLE T_PM_CANDIDATO;
DROP TABLE T_PM_FEEDBACK;
DROP TABLE T_PM_USUARIO;
DROP TABLE T_PM_VAGA;
DROP TABLE T_PM_CARREIRA;

CREATE TABLE T_PM_CARREIRA(
	cd_carreira NUMBER(6) NOT NULL,
	nm_carreira VARCHAR2(30) NOT NULL,
	ds_skills_basicas VARCHAR2(100) NOT NULL,
	CONSTRAINT pk_carreira PRIMARY KEY (cd_carreira)
);

CREATE TABLE T_PM_VAGA(
	cd_vaga NUMBER(6) NOT NULL,
	cd_carreira NUMBER(6) NOT NULL,
	nm_vaga VARCHAR2(50) NOT NULL,
	ds_skill VARCHAR2(100) NOT NULL,
	ds_soft_skill VARCHAR2(100) NOT NULL,
	vl_salario NUMBER(5),
	CONSTRAINT pk_vaga PRIMARY KEY (cd_vaga),
	CONSTRAINT fk_carreira FOREIGN KEY (cd_carreira)
    REFERENCES T_PM_CARREIRA(cd_carreira)	
);

CREATE TABLE T_PM_USUARIO(
	cd_login NUMBER(4) NOT NULL,
	cd_vaga NUMBER(6) NOT NULL,
	cd_senha NUMBER(4) NOT NULL,
	nm_usuario VARCHAR2(30) NOT NULL,
	ds_categoria VARCHAR2(11) NOT NULL,
	dt_admissao_vag DATE NOT NULL,
	CONSTRAINT pk_login PRIMARY KEY (cd_login),
	CONSTRAINT fk_vaga FOREIGN KEY (cd_vaga)
    REFERENCES T_PM_VAGA(cd_vaga)
);

CREATE TABLE T_PM_FEEDBACK(
	cd_feedback NUMBER(6) NOT NULL,
	cd_login NUMBER(4) NOT NULL,
	vl_feedback NUMBER NOT NULL,
	ds_feedback VARCHAR2(100) NOT NULL,
	dt_envio DATE NOT NULL,
	cd_login_receptor NUMBER(4) NOT NULL,
	CONSTRAINT pk_feedback PRIMARY KEY (cd_feedback),
	CONSTRAINT fk_login FOREIGN KEY (cd_login)
    REFERENCES T_PM_USUARIO(cd_login)
);

CREATE TABLE T_PM_CANDIDATO(
	cd_login NUMBER(4) NOT NULL,
	cd_vaga NUMBER(6) NOT NULL,
	CONSTRAINT pklogin PRIMARY KEY (cd_login, cd_vaga),
	CONSTRAINT fklogin
	FOREIGN KEY (cd_login)
    REFERENCES T_PM_USUARIO(cd_login)
);
