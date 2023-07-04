ALTER TABLE stock RENAME TO active;
ALTER TABLE active RENAME COLUMN active TO name;
ALTER TABLE active RENAME COLUMN stock_type TO active_type;
ALTER TABLE active RENAME COLUMN cash_return TO result_cache_value;
ALTER TABLE active RENAME COLUMN profitability TO result_percentage_value;
ALTER TABLE active RENAME COLUMN average_purchase TO average_value;
ALTER TABLE active RENAME COLUMN show TO enabled;
