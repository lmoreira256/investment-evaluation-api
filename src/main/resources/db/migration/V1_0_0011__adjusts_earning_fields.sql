ALTER TABLE earning RENAME COLUMN current_value TO amount_paid;
ALTER TABLE earning ADD COLUMN payday DATE;
