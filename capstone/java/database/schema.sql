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

CREATE TABLE collections (
	collection_id SERIAL,
	collection_name varchar(50) NOT NULL,
	is_public boolean DEFAULT false,
	user_id int NOT NULL,
	CONSTRAINT PK_collections PRIMARY KEY (collection_id),
	CONSTRAINT FK_collections_users FOREIGN KEY (user_id) REFERENCES users (user_id) 
);

CREATE TABLE comics(
	comic_id SERIAL,
	collection_id int NOT NULL,
	title varchar(200) NOT NULL,
	volume varchar(200) NOT NULL,
	issue_number int NOT NULL,
	release_date varchar(50),
	image varchar(100),
	icon_URL varchar,
	api_ID int,
	description varchar,
	publisher varchar,
	quantity int,
	CONSTRAINT PK_comic PRIMARY KEY (comic_id),
	CONSTRAINT FK_comics_collections FOREIGN KEY (collection_id) REFERENCES collections(collection_id) 
	
);

COMMIT TRANSACTION;
