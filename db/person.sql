USE bankdb;

DROP TABLE IF EXISTS address;
CREATE TABLE IF NOT EXISTS address
(
 id INTEGER  PRIMARY KEY NOT NULL AUTO_INCREMENT,
 state CHAR(2) NOT NULL,
 city VARCHAR(35) NOT NULL,
 town VARCHAR(50) NOT NULL,
 street VARCHAR(95) NOT NULL,
 apartment_no VARCHAR(5),
 zipcode CHAR(5) NOT NULL,
);


DROP TABLE IF EXISTS person;
CREATE TABLE IF NOT EXISTS person
(
 id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
 first_name VARCHAR(50) NOT NULL,
 middle_name VARCHAR(50),
 last_name VARCHAR(50) NOT NULL,
 sex ENUM('male','female') NOT NULL,
 date_of_birth DATE NOT NULL,
 mobile_phone VARCHAR(15) NOT NULL,
 home_phone VARCHAR(15),
 work_phone VARCHAR(15),
 id_no VARCHAR(30) NOT NULL,
 id_type ENUM('passport','driver license','state id') NOT NULL,
 fk_primary_address INTEGER NOT NULL,
 FOREIGN KEY (fk_primary_address) REFERENCES address(id)
);

DROP TABLE IF EXISTS person_address;
CREATE TABLE IF NOT EXISTS person_address
( 
  fk_id_address INTEGER PRIMARY KEY NOT NULL,
  fk_id_person INTEGER NOT NULL,
  FOREIGN KEY (fk_id_address) REFERENCES address(id),
  FOREIGN KEY (fk_id_person) REFERENCES person(id)
);




