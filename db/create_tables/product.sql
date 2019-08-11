CREATE TABLE product
(
    id               BIGSERIAL,
    name             VARCHAR(64),
    description      VARCHAR(256),
    price            INTEGER,
    brand            VARCHAR(64),
    version          DOUBLE PRECISION,
    category_id     BIGINT,

    CONSTRAINT pk_product PRIMARY KEY (id)
);
