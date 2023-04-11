-- table departement
CREATE TABLE departement (
code VARCHAR2(255),
nom VARCHAR2(255),
libelle VARCHAR2(255),
CONSTRAINT pk_departement PRIMARY KEY (code)
);
-- table enseignant
CREATE TABLE enseignant (
matrucle VARCHAR2(255),
nom VARCHAR2(255),
prenom VARCHAR2(255),
email VARCHAR2(255) UNIQUE NOT NULL,
telephone VARCHAR2(255) UNIQUE,
date_naissance DATE,
departement_code VARCHAR2(255),
CONSTRAINT pk_ensignant PRIMARY KEY (matrucle),
CONSTRAINT fk_enseignant_departement FOREIGN KEY (departement_code) REFERENCES departement(code)
);
-- table semistre
CREATE TABLE semistre (
code VARCHAR2(255),
nom VARCHAR2(255),
libelle VARCHAR2(255),
annee_univirsite NUMBER(4),
departement_code VARCHAR2(255),
CONSTRAINT pk_semistre PRIMARY KEY (code),
CONSTRAINT fk_semistre_departement FOREIGN KEY (departement_code) REFERENCES departement(code)
);
-- table cours
CREATE TABLE COURS (
code VARCHAR2(255),
nom VARCHAR2(255),
libelle VARCHAR2(255),
semistre_code VARCHAR2(255),
CONSTRAINT pk_COURS PRIMARY KEY (code),
CONSTRAINT fk_cours_semistre FOREIGN KEY (semistre_code) REFERENCES semistre(code)
);

-- table etudiant
CREATE TABLE etudiant (
code_apoge VARCHAR2(255),
nom VARCHAR2(255),
prenom VARCHAR2(255),
email VARCHAR2(255) UNIQUE NOT NULL,
telephone VARCHAR2(255) UNIQUE,
date_naissance DATE,
departement_code VARCHAR2(255),
CONSTRAINT pk_etudiant PRIMARY KEY (code_apoge),
CONSTRAINT fk_etudiant_departement FOREIGN KEY (departement_code) REFERENCES departement(code)
);

-- table enseignant_cours
CREATE TABLE enseignant_cours (
cours_code VARCHAR2(255),
enseignant_matrucle VARCHAR2(255),
annee_univirsite  NUMBER(4),
CONSTRAINT pk_enseignant_cours PRIMARY KEY (cours_code,enseignant_matrucle),
CONSTRAINT fk_enseignant_cours_cours FOREIGN KEY (cours_code) REFERENCES cours(code),
CONSTRAINT fk_enseignant_cours_enseignant FOREIGN KEY (enseignant_matrucle) REFERENCES enseignant(matrucle)
);

-- table etudiant_cours
CREATE TABLE etudiant_cours (
etudiant_code_apoge VARCHAR2(255),
cours_code VARCHAR2(255),
annee_univirsite  NUMBER(4),
note NUMBER(2, 3),
CONSTRAINT pk_etudiant_cours  PRIMARY KEY (etudiant_code_apoge,cours_code),
CONSTRAINT fk_etudiant_cours_cours FOREIGN KEY (cours_code) REFERENCES cours(code),
CONSTRAINT fk_etudiant_cours_etudiant FOREIGN KEY (etudiant_code_apoge) REFERENCES etudiant(code_apoge)
);








