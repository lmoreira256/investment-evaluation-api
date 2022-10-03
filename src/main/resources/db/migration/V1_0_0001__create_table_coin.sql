CREATE TABLE coin (
    id            UUID            NOT NULL,
    name          VARCHAR(200)    NOT NULL,
    amount        NUMERIC(18, 10) NOT NULL,
    current_value NUMERIC(18, 2)  NOT NULL,

    PRIMARY KEY (id)
);
