CREATE TABLE stock (
    id               UUID           NOT NULL,
    active           VARCHAR(6)     NOT NULL,
    description      VARCHAR(255)   NOT NULL,
    amount           INTEGER        NOT NULL,
    current_value    NUMERIC(18, 2) NOT NULL,
    cash_return      NUMERIC(18, 2) NOT NULL,
    profitability    NUMERIC(5, 2)  NOT NULL,
    purchase_value   NUMERIC(18, 2) NOT NULL,
    average_purchase NUMERIC(18, 2) NOT NULL,
    stock_type       VARCHAR(50)    NOT NULL,
    created_at       TIMESTAMP      NOT NULL,
    updated_at       TIMESTAMP      NOT NULL,

    PRIMARY KEY (id)
);
