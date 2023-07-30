
-- supprime le CONSTRAINT fk_etudiant_cours_etudiant dans la table etudiant_cours
ALTER TABLE etudiant_cours
DROP CONSTRAINT fk_etudiant_cours_etudiant;
--ajouter un nouveau constraint lie a la table user_app
ALTER TABLE etudiant_cours
ADD CONSTRAINT fk_etudiant_cours_etudiant FOREIGN KEY (etudiant_code_apoge) REFERENCES user_app(code);

---upprime le CONSTRAINT fk_enseignant_cours_enseignant dans la table enseignant_cours
ALTER TABLE enseignant_cours
DROP CONSTRAINT fk_enseignant_cours_enseignant;
-- ajouter un nouveau constraint lie a la table user_app
ALTER TABLE enseignant_cours
ADD CONSTRAINT fk_enseignant_cours_enseignant FOREIGN KEY (enseignant_matrucle) REFERENCES user_app(code);

--ajouter le champ departement_code dans la table user_app
ALTER TABLE user_app
ADD (departement_code_etudiant VARCHAR2(50) REFERENCES departement(code));

--ajouter le champ departement_code dans la table user_app
ALTER TABLE user_app
ADD (departement_code_enseignant VARCHAR2(50) REFERENCES departement(code));

ALTER TABLE enseignant DROP CONSTRAINT fk_enseignant_departement;

ALTER TABLE etudiant DROP CONSTRAINT fk_etudiant_departement;

-- suprime la table enseignant  et etudiant
DROP TABLE enseignant;
DROP TABLE etudiant;