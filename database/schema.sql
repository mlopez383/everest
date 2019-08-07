CREATE TABLE ra_user(
 user_id SERIAL PRIMARY KEY,
 fullname varchar(100) NOT NULL,
 email varchar(100) DEFAULT NULL,
 pass_word varchar(100) DEFAULT NULL
);