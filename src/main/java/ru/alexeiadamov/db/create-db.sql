CREATE DATABASE cinema
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA cinema
    AUTHORIZATION postgres;

-- Длительности сеансов
CREATE TABLE cinema.durations
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    duration integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT durations_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE cinema.durations
    OWNER to postgres;

-- Фильмы
CREATE TABLE cinema.movies
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    title text COLLATE pg_catalog."default" NOT NULL,
    year integer NOT NULL,
    duration integer NOT NULL,
    CONSTRAINT movies_pkey PRIMARY KEY (id),
    CONSTRAINT duration_fkey FOREIGN KEY (duration)
        REFERENCES cinema.durations (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE cinema.movies
    OWNER to postgres;

-- Сеансы
CREATE TABLE cinema.sessions
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    schedule timestamp without time zone NOT NULL,
    movie integer NOT NULL,
    CONSTRAINT sessions_pkey PRIMARY KEY (id),
    CONSTRAINT movies_fkey FOREIGN KEY (movie)
        REFERENCES cinema.movies (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE cinema.sessions
    OWNER to postgres;

-- Цены
CREATE TABLE cinema.prices
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    weekday integer NOT NULL,
    time_from time without time zone NOT NULL,
    time_till time without time zone NOT NULL,
    price numeric(15,2) NOT NULL,
    CONSTRAINT prices_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE cinema.prices
    OWNER to postgres;

-- Билеты
CREATE TABLE cinema.tickets
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    session integer NOT NULL,
    CONSTRAINT tickets_pkey PRIMARY KEY (id),
    CONSTRAINT sessions_fkey FOREIGN KEY (session)
        REFERENCES cinema.sessions (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE cinema.tickets
    OWNER to postgres;
