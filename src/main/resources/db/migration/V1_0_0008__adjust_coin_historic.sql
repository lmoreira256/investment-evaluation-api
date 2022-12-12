ALTER TABLE historic RENAME TO coin_historic;

ALTER TABLE coin_historic RENAME COLUMN value TO actual_value;

ALTER TABLE coin_historic RENAME COLUMN date TO created_at;
