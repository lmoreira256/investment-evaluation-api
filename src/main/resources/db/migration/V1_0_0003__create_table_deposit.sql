CREATE TABLE deposit (
    id            UUID            NOT NULL,
    value         NUMERIC(18, 2)  NOT NULL,
    date          DATE            NOT NULL,

    PRIMARY KEY (id)
);
