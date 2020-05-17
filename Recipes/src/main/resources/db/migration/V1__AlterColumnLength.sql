ALTER TABLE public.recipe ALTER COLUMN image TYPE varchar(2100);
ALTER TABLE public.recipe ALTER COLUMN description TYPE varchar(2100);
ALTER TABLE public.recipe ALTER COLUMN ingredients TYPE varchar(2100);
ALTER TABLE public.recipe ALTER COLUMN steps TYPE varchar(2100);
commit;