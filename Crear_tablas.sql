drop table respuesta;
drop table pregunta;
drop table comentario;
drop table cartel;
drop table alumno;
drop table profesor;


CREATE TABLE profesor(
	nombre        VARCHAR(45) NOT NULL,
	apellido1   VARCHAR(40) NOT NULL,
	apellido2   VARCHAR(40),
	email       VARCHAR(70),
	contrasena  VARCHAR(20),
	emailprofe  VARCHAR(70),
	CONSTRAINT profesorpk PRIMARY KEY(email),
	CONSTRAINT emailProfFK 	FOREIGN KEY (emailprofe) REFERENCES profesor(email)
);

CREATE TABLE alumno(
	nombre      VARCHAR(45) NOT NULL,
	apellido1   VARCHAR(40) NOT NULL,
	apellido2   VARCHAR(40),
	email       VARCHAR(70),
	contrasena  VARCHAR(20),
	emailprofe  VARCHAR(70),
	CONSTRAINT alumnopk PRIMARY KEY(email),
	CONSTRAINT emailProfeFK FOREIGN KEY (emailprofe) REFERENCES profesor(email)
);


CREATE TABLE cartel (
	id          INT(20),
	emailA      VARCHAR(70),
	ganador     CHAR(1),
	agno        INT(4) NOT NULL,
	tema        VARCHAR(20) NOT NULL,
	link        VARCHAR(200) NOT NULL,
	CONSTRAINT cartelpk PRIMARY KEY (id),
	CONSTRAINT emailFK FOREIGN KEY (emailA) REFERENCES alumno(email)
);

CREATE TABLE comentario(
	idC         INT(7),
	idCartel    INT(20),
	nombre      VARCHAR(45),
	cuerpo      VARCHAR(600),
	pendiente   CHAR(1),
	CONSTRAINT comentariopk PRIMARY KEY(idC),
	CONSTRAINT cartelfkcoment FOREIGN KEY (idCartel) REFERENCES cartel(id)
);

CREATE TABLE pregunta(
	id          INT(5),
	titulo      VARCHAR(600) NOT NULL,
	idCartel    INT(20),
	CONSTRAINT preguntapk 	PRIMARY KEY(id,idCartel),
	CONSTRAINT cartelfk FOREIGN KEY (idCartel) REFERENCES cartel(id)
);



CREATE TABLE reto(
	id          INT(5),
	descripcion      VARCHAR(600) NOT NULL,
	idCartel    INT(20),
	CONSTRAINT retoapk 	PRIMARY KEY(id,idCartel),
	CONSTRAINT cartelfkreto FOREIGN KEY (idCartel) REFERENCES cartel(id)
);


CREATE TABLE respuesta(
	idR         INT(7),
	idC	    INT(20),
	idP         INT(5),
	cuerpo      VARCHAR(600) NOT NULL,
	veces       INT(10),
	ganador     CHAR(1),
	CONSTRAINT respuestapk  PRIMARY KEY(idR,idC,idP),
	CONSTRAINT preguntafkrespuesta FOREIGN KEY (idP, idC) REFERENCES pregunta(id, idCartel)
);


INSERT INTO profesor(nombre,apellido1,apellido2,email,contrasena,emailprofe) VALUES('uno','dos','tres','uno@unizar.es','tablahash',null);
INSERT INTO alumno(nombre,apellido1,apellido2,email,contrasena,emailprofe) VALUES('alum','ape','ape2','alum@unizar.es','hashtable','uno@unizar.es');
INSERT INTO cartel(id,emailA,ganador,agno,tema,link) VALUES(567,'alum@unizar.es','F',2010,'Agua','link');
INSERT INTO comentario(idC,idCartel,nombre,cuerpo,pendiente) VALUES(22,567,'coment','buenos dias andalucia','F');
INSERT INTO pregunta(id,titulo,idCartel) VALUES(10,'pregunting',567);
INSERT INTO respuesta(idR,idC,idP,cuerpo,veces,ganador) VALUES(100,567,10,'U mad?', 73, 'T');
INSERT INTO reto(id,descripcion,idCartel) VALUES(69,'Te reto a que te mueras', 567);
