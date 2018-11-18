-- AUTORES
--	Ignacio Palacios Gracia		NIP:739359
--	David Ubide Alaiz		NIP:736520
--	José Manuel Romero		NIP:740914


CREATE TABLE profesor(
	nombre        VARCHAR(45) NOT NULL,
	apellido1   VARCHAR(40) NOT NULL,
	apellido2   VARCHAR(40),
	email       VARCHAR(70),
	contrasena  VARCHAR(400),
	emailprofe  VARCHAR(70),
	CONSTRAINT profesorpk PRIMARY KEY(email),
	CONSTRAINT emailProfFK 	FOREIGN KEY (emailprofe) REFERENCES profesor(email)
);

CREATE TABLE alumno(
	nombre      VARCHAR(45) NOT NULL,
	apellido1   VARCHAR(40) NOT NULL,
	apellido2   VARCHAR(40),
	email       VARCHAR(70),
	contrasena  VARCHAR(400),
	emailprofe  VARCHAR(70),
	CONSTRAINT alumnopk PRIMARY KEY(email),
	CONSTRAINT emailProfeFK FOREIGN KEY (emailprofe) REFERENCES profesor(email) ON DELETE CASCADE
);


CREATE TABLE cartel (
	id          INT(20),
	emailA      VARCHAR(70),
	ganador     CHAR(1),
	agno        INT(4) NOT NULL,
	tema        VARCHAR(20) NOT NULL,
	titulo      VARCHAR(50) NOT NULL,
	link        VARCHAR(200) NOT NULL,
	CONSTRAINT cartelpk PRIMARY KEY (id),
	CONSTRAINT emailFK FOREIGN KEY (emailA) REFERENCES alumno(email) ON DELETE CASCADE
);

CREATE TABLE comentario(
	id          INT(7),
	idCartel    INT(20),
	nombre      VARCHAR(45),
	cuerpo      VARCHAR(600),
	pendiente   CHAR(1),
	CONSTRAINT comentariopk PRIMARY KEY(id),
	CONSTRAINT cartelfkcoment FOREIGN KEY (idCartel) REFERENCES cartel(id) ON DELETE CASCADE
);

CREATE TABLE pregunta(
	id          INT(5),
	titulo      VARCHAR(600) NOT NULL,
	idCartel    INT(20),
	CONSTRAINT preguntapk 	PRIMARY KEY(id,idCartel),
	CONSTRAINT cartelfk FOREIGN KEY (idCartel) REFERENCES cartel(id) ON DELETE CASCADE
);



CREATE TABLE reto(
	id          INT(5),
	descripcion      VARCHAR(600) NOT NULL,
	idCartel    INT(20),
	CONSTRAINT retoapk 	PRIMARY KEY(id,idCartel),
	CONSTRAINT cartelfkreto FOREIGN KEY (idCartel) REFERENCES cartel(id) ON DELETE CASCADE
);
CREATE TABLE noticia(
	titulo      VARCHAR(10000) NOT NULL,
	idCartel    INT(20),
	CONSTRAINT noticia_pk 	PRIMARY KEY(idCartel),
	CONSTRAINT notiicia_fk FOREIGN KEY (idCartel) REFERENCES cartel(id) ON DELETE CASCADE
);
CREATE TABLE reto(
	id          INT(5),
	descripcion      VARCHAR(600) NOT NULL,
	idCartel    INT(20),
	CONSTRAINT retoapk 	PRIMARY KEY(id,idCartel),
	CONSTRAINT cartelfkreto FOREIGN KEY (idCartel) REFERENCES cartel(id) ON DELETE CASCADE
);


CREATE TABLE respuesta(
	id         INT(7),
	idC	    INT(20),
	idP         INT(5),
	cuerpo      VARCHAR(600) NOT NULL,
	veces       INT(10),
	ganador     CHAR(1),
	CONSTRAINT respuestapk  PRIMARY KEY(id,idC,idP),
	CONSTRAINT preguntafkrespuesta FOREIGN KEY (idP, idC) REFERENCES pregunta(id, idCartel) ON DELETE CASCADE
);
