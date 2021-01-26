CREATE SCHEMA hotel;
CREATE TABLE hotel.hotel (
	id int8 NOT NULL,
	created_date timestamp NULL,
	updated_date timestamp NULL,
	address varchar(255) NULL,
	code varchar(255) NULL,
	description varchar(1000) NULL,
	email varchar(255) NULL,
	hotline varchar(255) NULL,
	latitude float8 NULL,
	longtitude float8 NULL,
	"name" varchar(255) NULL,
	short_description varchar(255) NULL,
	star int4 NULL,
	website varchar(255) NULL,
	CONSTRAINT hotel_pkey PRIMARY KEY (id)
);