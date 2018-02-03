--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: game; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE game (
    game_id integer NOT NULL,
    first_player_id integer,
    second_player_id integer,
    created timestamp without time zone,
    game_status character varying(15),
    game_type character varying(15)
);


ALTER TABLE public.game OWNER TO postgres;

--
-- Name: game_game_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE game_game_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.game_game_id_seq OWNER TO postgres;

--
-- Name: game_game_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE game_game_id_seq OWNED BY game.game_id;


--
-- Name: moves_record; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE moves_record (
    moves_id integer NOT NULL,
    player_id integer,
    game_id integer,
    "row" integer,
    col integer
);


ALTER TABLE public.moves_record OWNER TO postgres;

--
-- Name: moves_record_moves_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE moves_record_moves_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.moves_record_moves_id_seq OWNER TO postgres;

--
-- Name: moves_record_moves_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE moves_record_moves_id_seq OWNED BY moves_record.moves_id;


--
-- Name: players; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE players (
    id integer NOT NULL,
    name character varying(20),
    passwd character varying(15)
);


ALTER TABLE public.players OWNER TO postgres;

--
-- Name: players_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE players_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.players_id_seq OWNER TO postgres;

--
-- Name: players_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE players_id_seq OWNED BY players.id;


--
-- Name: game_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY game ALTER COLUMN game_id SET DEFAULT nextval('game_game_id_seq'::regclass);


--
-- Name: moves_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY moves_record ALTER COLUMN moves_id SET DEFAULT nextval('moves_record_moves_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY players ALTER COLUMN id SET DEFAULT nextval('players_id_seq'::regclass);


--
-- Data for Name: game; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY game (game_id, first_player_id, second_player_id, created, game_status, game_type) FROM stdin;
1	1	2	2018-02-03 05:17:34.122364	finished	offline
\.


--
-- Name: game_game_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('game_game_id_seq', 2, true);


--
-- Data for Name: moves_record; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY moves_record (moves_id, player_id, game_id, "row", col) FROM stdin;
\.


--
-- Name: moves_record_moves_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('moves_record_moves_id_seq', 1, false);


--
-- Data for Name: players; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY players (id, name, passwd) FROM stdin;
1	computer	0000
2	maryam	1234
\.


--
-- Name: players_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('players_id_seq', 2, true);


--
-- Name: game_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY game
    ADD CONSTRAINT game_pkey PRIMARY KEY (game_id);


--
-- Name: moves_record_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY moves_record
    ADD CONSTRAINT moves_record_pkey PRIMARY KEY (moves_id);


--
-- Name: players_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY players
    ADD CONSTRAINT players_pkey PRIMARY KEY (id);


--
-- Name: game_first_player_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY game
    ADD CONSTRAINT game_first_player_id_fkey FOREIGN KEY (first_player_id) REFERENCES players(id);


--
-- Name: game_second_player_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY game
    ADD CONSTRAINT game_second_player_id_fkey FOREIGN KEY (second_player_id) REFERENCES players(id);


--
-- Name: moves_record_game_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY moves_record
    ADD CONSTRAINT moves_record_game_id_fkey FOREIGN KEY (game_id) REFERENCES game(game_id);


--
-- Name: moves_record_player_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY moves_record
    ADD CONSTRAINT moves_record_player_id_fkey FOREIGN KEY (player_id) REFERENCES players(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

