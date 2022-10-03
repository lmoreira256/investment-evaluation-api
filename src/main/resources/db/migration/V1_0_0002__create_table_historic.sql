CREATE TABLE historic (
    id            UUID            NOT NULL,
    value         NUMERIC(18, 2)  NOT NULL,
    date          TIMESTAMP       NOT NULL,
    amount        NUMERIC(18, 10) NOT NULL,
    cash_return   NUMERIC(18, 2)  NOT NULL,
    profitability NUMERIC(3, 2)   NOT NULL,

    PRIMARY KEY (id)
);
