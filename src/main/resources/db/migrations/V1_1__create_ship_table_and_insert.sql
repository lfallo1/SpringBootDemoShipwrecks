CREATE TABLE public.shipwreck
(
   id bigserial NOT NULL, 
   name text, 
   description text, 
   condition text, 
   depth integer, 
   latitude double precision, 
   longitude double precision, 
   year_discovered integer, 
   CONSTRAINT shipwreck_pk PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)