BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS comics CASCADE;
DROP TABLE IF EXISTS collections CASCADE;
DROP TABLE IF EXISTS collections_issues CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	isPremium boolean, 
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE comics(
	comic_id SERIAL,
	title varchar(200) NOT NULL,
	volume varchar(200) NOT NULL,
	issue_number int NOT NULL,
	genre varchar,
	author varchar(50),
	release_date date,
	in_store_date date,
	image varchar(100),
	deck varchar,
	icon_URL varchar,
	api_ID int,
	description varchar,
	publisher varchar,
	CONSTRAINT PK_comic PRIMARY KEY (comic_id),
	CONSTRAINT FK_comics_collections FOREIGN KEY (collection_id) REFERENCES collection(collection_id) 
	
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
		--quantity
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
