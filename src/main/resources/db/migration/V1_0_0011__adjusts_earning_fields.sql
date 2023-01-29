ALTER TABLE earning RENAME COLUMN current_value TO amount_paid;
ALTER TABLE earning ADD COLUMN payday DATE;
UPDATE earning SET payday = created_at;
