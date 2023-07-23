-- table user_app
CREATE TABLE user_app (
code VARCHAR2(50),
username VARCHAR2(50),
email VARCHAR2(50),
password VARCHAR2(50),
CONSTRAINT pk_user_app PRIMARY KEY (code)
);

-- table role_app
CREATE TABLE role_app (
code VARCHAR2(50),
role_name VARCHAR2(50),
CONSTRAINT pk_role_app PRIMARY KEY (code)
);

-- table user_role
CREATE TABLE user_role (
user_code VARCHAR2(50),
role_code VARCHAR2(50),
CONSTRAINT pk_user_role PRIMARY KEY (user_code,role_code),
CONSTRAINT fk_user_role_user FOREIGN KEY (user_code) REFERENCES user_app(code),
CONSTRAINT fk_user_role_role FOREIGN KEY (role_code) REFERENCES role_app(code)
);
