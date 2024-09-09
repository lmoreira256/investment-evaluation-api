ALTER TABLE active RENAME COLUMN amount TO quantity;
ALTER TABLE active RENAME COLUMN result_value TO net_result;
ALTER TABLE active RENAME COLUMN result_percentage_value TO percentage_result;
ALTER TABLE active RENAME COLUMN purchase_value TO cost_value;
ALTER TABLE active RENAME COLUMN average_value TO average_cost;
ALTER TABLE active RENAME COLUMN actual_value TO current_price;
