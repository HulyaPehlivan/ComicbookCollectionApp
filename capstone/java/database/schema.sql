BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	is_premium boolean DEFAULT false, 
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE collections (
	collection_id SERIAL,
	collection_name varchar(50) NOT NULL,
	is_public boolean DEFAULT false,
	user_id int NOT NULL,
	CONSTRAINT PK_collections PRIMARY KEY (collection_id),
	CONSTRAINT FK_collections_users FOREIGN KEY (user_id) REFERENCES users (user_id) 
);

CREATE TABLE collections_issues (
	issue_id SERIAL,
	issue_number int NOT NULL,
	title varchar(100) NOT NULL,
	genre varchar(50) NOT NULL,
	collection_id int NOT NULL,
	CONSTRAINT PK_collections_issues PRIMARY KEY (issue_id),
	CONSTRAINT FK_collections_issues_collections FOREIGN KEY (collection_id) REFERENCES collections (collection_id)
);

--potential additional tables--

--Character
--id
--character_id
--name
--publisher_id

--Publisher
--id
--publisher_id
--publisher

--ROLLBACK;
COMMIT TRANSACTION;
