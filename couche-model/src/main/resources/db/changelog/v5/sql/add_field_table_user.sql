-- modifier la table use_app
ALTER TABLE user_app
MODIFY (email VARCHAR2(50) NOT NULL UNIQUE)
ADD (nom VARCHAR2(50), prenom VARCHAR2(50), telephone VARCHAR2(50) UNIQUE, date_naissance DATE )