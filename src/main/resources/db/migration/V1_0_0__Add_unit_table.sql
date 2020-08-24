CREATE TABLE unit (
    id uuid NOT NULL,
    size numeric(5) NOT NULL,
    number int4 NOT NULL,
    owner text NULL,
    CONSTRAINT pk_unit PRIMARY KEY (id)
);
