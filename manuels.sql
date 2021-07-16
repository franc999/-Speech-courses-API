CREATE DATABASE manuels_DB;
USE manuels_DB;

CREATE TABLE lesson (id_lesson INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
					 title VARCHAR(30) NOT NULL,
                     description VARCHAR(400) NOT NULL,
                     quota SMALLINT NOT NULL,
                     requeriments VARCHAR(200) NOT NULL,
                     forWho VARCHAR(100) NOT NULL,
                     teacher VARCHAR(60) NOT NULL,
                     duration VARCHAR(30) NOT NULL);
	
CREATE TABLE date(id_date INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				  date DATE);
                  
CREATE TABLE lesson_dates(fk_lesson INT NOT NULL,
						  fk_date INT NOT NULL,
                          FOREIGN KEY (fk_lesson) REFERENCES lesson (id_lesson) ON DELETE CASCADE,
                          FOREIGN KEY (fk_date) REFERENCES date (id_date) ON DELETE CASCADE);
                          
CREATE TABLE review(id_review INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				    name VARCHAR(20) NOT NULL,
                    commentary VARCHAR(400) NOT NULL);

CREATE TABLE image(id_image INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				   name VARCHAR(150),
				   type VARCHAR(30),
                   bytes MEDIUMBLOB); 

CREATE TABLE publication(id_publication INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
						 title VARCHAR(30) NOT NULL,
                         description VARCHAR(1000) NOT NULL,
                         id_img INT,
                         FOREIGN KEY (id_img) REFERENCES image (id_image) ON DELETE CASCADE);

CREATE TABLE user(id_user INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				  username VARCHAR(40) NOT NULL,
                  password VARCHAR(164) NOT NULL);
select *from user;
INSERT INTO publication (title, description, id_img) values ("hola","lala",1);