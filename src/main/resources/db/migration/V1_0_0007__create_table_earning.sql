CREATE TABLE earning (
    id            UUID           NOT NULL,
    id_stock      UUID           NOT NULL,
    current_value NUMERIC(18, 2) NOT NULL,
    description   VARCHAR(255)   NOT NULL,
    created_at    TIMESTAMP      NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_earning_stock FOREIGN KEY (id_stock) REFERENCES stock(id)
);
