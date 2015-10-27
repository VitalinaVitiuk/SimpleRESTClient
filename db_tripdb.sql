
CREATE TABLE country
(
  id bigserial NOT NULL,
  countryisocode character varying(255),
  countryname character varying(255),
  CONSTRAINT country_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE country
  OWNER TO test;


  CREATE TABLE city
(
  id bigserial NOT NULL,
  cityname character varying(255),
  country_id bigint,
  CONSTRAINT city_pkey PRIMARY KEY (id),
  CONSTRAINT fk_m503bcpirmab9y40lg2ia9d54 FOREIGN KEY (country_id)
      REFERENCES country (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE city
  OWNER TO test;