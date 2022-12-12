CREATE TABLE stock_historic (
    id             UUID           NOT NULL,
    actual_value   NUMERIC(18, 2) NOT NULL,
    purchase_value NUMERIC(18, 2) NOT NULL,
    amount         INTEGER        NOT NULL,
    cash_return    NUMERIC(18, 2) NOT NULL,
    profitability  NUMERIC(3, 2)  NOT NULL,
    historic_type  VARCHAR(50)    NOT NULL,
    created_at     TIMESTAMP      NOT NULL,

    PRIMARY KEY (id)
);
