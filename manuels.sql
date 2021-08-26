CREATE DATABASE manuels_DB;
USE manuels_DB;

CREATE TABLE lesson (id_lesson INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
					 title VARCHAR(50) NOT NULL,
                     description VARCHAR(500) NOT NULL,
                     quota SMALLINT NOT NULL,
                     requeriments VARCHAR(250) NOT NULL,
                     forwho VARCHAR(200) NOT NULL,
                     teacher VARCHAR(60) NOT NULL,
                     duration VARCHAR(150) NOT NULL,
                     link VARCHAR(150),
                     link1 VARCHAR(150),
                     descountLink VARCHAR(150));
                     
CREATE TABLE date(id_date INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				  date DATE);
                  
CREATE TABLE lesson_dates(fk_lesson INT NOT NULL,
						  fk_date INT NOT NULL,
                          FOREIGN KEY (fk_lesson) REFERENCES lesson (id_lesson) ON DELETE CASCADE,
                          FOREIGN KEY (fk_date) REFERENCES date (id_date) ON DELETE CASCADE);
                          
CREATE TABLE review(id_review INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				    name VARCHAR(20) NOT NULL,
                    commentary VARCHAR(400) NOT NULL,
                    validate BOOLEAN);

CREATE TABLE image(id_image INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				   name VARCHAR(150),
				   type VARCHAR(30),
                   bytes MEDIUMBLOB); 

CREATE TABLE publication(id_publication INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
						 title VARCHAR(30) NOT NULL,
                         description VARCHAR(600) NOT NULL,
                         description1 VARCHAR(600),
                         description2 VARCHAR(600),
                         description3 VARCHAR(600),
                         subtitle VARCHAR(500),
                         subtitle2 VARCHAR(500),
                         date date,
                         id_img INT NULL,
                         FOREIGN KEY (id_img) REFERENCES image (id_image) ON DELETE CASCADE);

CREATE TABLE payment(id_payment INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
					  name VARCHAR(40),
                      lastname VARCHAR(40),
                      date date,
                      payment boolean,
                      phone VARCHAR(40),
                      voucher INT NOT NULL,
                      id_lesson INT NOT NULL,
                      date_lesson date,
                      FOREIGN KEY (id_lesson) REFERENCES lesson (id_lesson),
                      FOREIGN KEY (voucher) REFERENCES image (id_image));
                         
CREATE TABLE user(id_user INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				  username VARCHAR(40) NOT NULL,
                  password VARCHAR(164) NOT NULL,
                  enabled BOOLEAN,
                  roles VARCHAR(100) NOT NULL);

drop table discounts;
CREATE TABLE discounts(id_discount INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                       code VARCHAR(10) NOT NULL);

                  insert into user (username, password, enabled, roles) values ("manuels", "$2y$12$TnkCvHO5hoMI0lGo4E784e.tkNDXyV8j6sataWlvuMZGtLOl/xjeO", 1, "ROLE_ADMIN");
                   alter table payment add column date_lesson date;
                   alter table lesson add column discount_link VARCHAR(150);
                   alter table lesson add column code VARCHAR(10);
                  /*alter table publication add column date date;*/
				