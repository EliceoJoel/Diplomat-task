-- Create rol table
CREATE TABLE IF NOT EXISTS rol
(
    id integer NOT NULL,
    name character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT rol_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS rol_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- Create users table
CREATE TABLE IF NOT EXISTS users
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    email character varying(150) COLLATE pg_catalog."default",
    password character varying(150) COLLATE pg_catalog."default",
    username character varying(150) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
    );

CREATE SEQUENCE IF NOT EXISTS user_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- create user_rol table
CREATE TABLE IF NOT EXISTS user_rol
(
    id integer NOT NULL,
    active boolean,
    created_at timestamp without time zone,
    rol_id integer,
    user_id bigint,
    CONSTRAINT user_rol_pkey PRIMARY KEY (id),
    CONSTRAINT fk3xg2nuaohq3m1jidxctddln2j FOREIGN KEY (user_id)
    REFERENCES users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkpfraq7jod5w5xd3sxm3m6y1o FOREIGN KEY (rol_id)
    REFERENCES rol (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS user_rol_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- Create user_detail table
CREATE TABLE IF NOT EXISTS user_detail
(
    id bigint NOT NULL,
    age integer,
    birthday date,
    first_name character varying(100) COLLATE pg_catalog."default",
    last_name character varying(100) COLLATE pg_catalog."default",
    user_id bigint,
    CONSTRAINT user_detail_pkey PRIMARY KEY (id),
    CONSTRAINT uk_dm7hrxg9mvrb92v1p3o6wg97u UNIQUE (user_id),
    CONSTRAINT fkr6i0t96qgu9l8l5nn2vqo8rcl FOREIGN KEY (user_id)
    REFERENCES users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS user_detail_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

