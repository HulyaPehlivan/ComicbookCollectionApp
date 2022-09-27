BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	-- user status
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

--Collections 
--id
--name
--status (private or public)
--user_id (foreign key)

--Collections_issue
--id
--collection_id
--issue_id

__________

--Character
--id
--character_id
--name
--publisher_id

--Publisher
--id
--publisher_id
--publisher




COMMIT TRANSACTION;
