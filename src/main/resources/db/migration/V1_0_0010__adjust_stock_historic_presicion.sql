ALTER TABLE public.stock_historic ALTER COLUMN profitability TYPE numeric(5, 2) USING profitability::numeric;
