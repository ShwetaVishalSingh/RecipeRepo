ALTER TABLE public.recipe ALTER COLUMN image TYPE varchar(1100);
ALTER TABLE public.recipe ALTER COLUMN description TYPE varchar(1100);
ALTER TABLE public.recipe ALTER COLUMN ingredients TYPE varchar(1100);
ALTER TABLE public.recipe ALTER COLUMN steps TYPE varchar(1100);
commit;