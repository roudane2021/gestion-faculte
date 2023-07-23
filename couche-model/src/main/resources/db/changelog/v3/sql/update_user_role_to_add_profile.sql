-- table profile_app
CREATE TABLE profile_app (
code VARCHAR2(50),
CONSTRAINT pk_profile PRIMARY KEY (code)
);

-- table profile_role
CREATE TABLE profile_role (
profile_code VARCHAR2(50),
role_code VARCHAR2(50),
CONSTRAINT pk_profile_role PRIMARY KEY (profile_code,role_code),
CONSTRAINT fk_profile_role_profile FOREIGN KEY (profile_code) REFERENCES profile_app(code),
CONSTRAINT fk_profile_role_role FOREIGN KEY (role_code) REFERENCES role_app(code)
);

-- delete table user_role
DROP TABLE USER_ROLE;
--- ajouter le champ profile_code dans la table user_app
ALTER TABLE user_app
ADD (profile_code VARCHAR2(50) REFERENCES profile_app  (code));