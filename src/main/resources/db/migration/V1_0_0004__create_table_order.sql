CREATE TABLE public.order (
    id            UUID            NOT NULL,
    id_coin       UUID            NOT NULL,
    amount        NUMERIC(18, 10) NOT NULL,
    date          TIMESTAMP       NOT NULL,
    value         NUMERIC(18, 10) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_order_coin FOREIGN KEY (id_coin) REFERENCES coin(id)
);
