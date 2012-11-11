CREATE TABLE drivers (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(50) NOT NULL ,
  gender BIT NOT NULL DEFAULT 1 ,
  birthday DATE NOT NULL ,
  PRIMARY KEY (id)
);

INSERT INTO drivers (name, gender, birthday) VALUES ('Li Ming', 1, '1985-02-22');
INSERT INTO drivers (name, gender, birthday) VALUES ('Du Juan', 0, '1986-11-11');
INSERT INTO drivers (name, gender, birthday) VALUES ('Zhang San', 1, '1991-07-15');
INSERT INTO drivers (name, gender, birthday) VALUES ('Li Si', 1, '1974-09-20');
INSERT INTO drivers (name, gender, birthday) VALUES ('Wang Erxiao', 1, '1977-05-08');
