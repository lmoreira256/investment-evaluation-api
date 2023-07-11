CREATE TABLE real_estate_fund_checkpoint (
    id                      UUID            NOT NULL,
    amount                  INTEGER         NOT NULL,
    current_value           NUMERIC(18, 2)  NOT NULL,
    purchase_value          NUMERIC(18, 2)  NOT NULL,
    result_value            NUMERIC(18, 2)  NOT NULL,
    result_percentage_value NUMERIC(5, 2)   NOT NULL,
    created_at              TIMESTAMP       NOT NULL,

    PRIMARY KEY (id)
);

INSERT INTO real_estate_fund_checkpoint(id, amount, current_value, purchase_value, result_value, result_percentage_value, created_at)
SELECT
    gen_random_uuid(),
    amount,
    actual_value,
    purchase_value,
    cash_return,
    profitability,
    created_at
FROM stock_historic
WHERE historic_type = 'REAL_ESTATE_FUND';
