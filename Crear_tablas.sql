CREATE TABLE profesor(
	nombre 		VARCHAR(45) NOT NULL,
	apellido1	VARCHAR(40) NOT NULL,
	apellido2	VARCHAR(40),
	email		VARCHAR(70),
	contrasena	VARCHAR(20),
	CONSTRAINT profesorpk PRIMARY  KEY(email)
	
);

CREATE TABLE alumno(
	nombre 		VARCHAR(45) NOT NULL,
	apellido1	VARCHAR(40) NOT NULL,
	apellido2	VARCHAR(40),
	email		VARCHAR(70),
	contrasena	VARCHAR(20),
	CONSTRAINT alumnopk PRIMARY  KEY(email)
	
);
CREATE TABLE cartel (
	id			NUMBER(100),
	emailA		VARCHAR(70),
	ganador		BIT,
	agno		NUMBER(4) NOT NULL,
	tema		VARCHAR(20) NOT NULL,
	link 		VARCHAR(200) NOT NULL,
	CONSTRAINT cartelpk PRIMARY KEY (id),
	CONSTRAINT emailFK 	FOREIGN KEY (emailA) REFERENCES alumno(email)
);

CREATE TABLE comentario(
	idC 		NUMBER(7),
	idCartel	NUMBER(100),
	nombre		VARCHAR(45),
	cuerpo		VARCHAR(600),
	pendiente	BIT,
	CONSTRAINT comentariopk PRIMARY KEY(idC),
	CONSTRAINT cartelfk		FOREIGN KEY (idCartel) REFERENCES cartel(id)
	
);

CREATE TABLE pregunta(
	id			NUMBER(5),
	titulo		VARCHAR(600) NOT NULL,
	idCartel	NUMBER(100),
	CONSTRAINT preguntapk 	PRIMARY KEY(id,idCartel),
	CONSTRAINT cartelfk		FOREIGN KEY (idCartel) REFERENCES cartel(id)
	
);

CREATE TABLE respuesta(
	idR			NUMBER(7),
	idC			NUMBER(100),
	idP			NUMBER(5),
	cuerpo		VARCHAR(600) NOT NULL,
	veces		NUMBER(10),
	ganador		BIT,
	CONSTRAINT respuestapk 	PRIMARY KEY(idR,idC,idP),
	CONSTRAINT cartelfk		FOREIGN KEY (idC) REFERENCES cartel(id),
	CONSTRAINT preguntafk	FOREIGN KEY (idP) REFERENCES pregunta(id)
);