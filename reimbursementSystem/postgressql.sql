CREATE TABLE IF NOT EXISTS public.account
(
    account_id integer NOT NULL,
    username "char"[] NOT NULL,
    password "char"[] NOT NULL,
    accounttype_id integer NOT NULL,
    CONSTRAINT account_pkey PRIMARY KEY (account_id),
    CONSTRAINT fk1 FOREIGN KEY (accounttype_id)
        REFERENCES public.accounttype (accounttype_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.account
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.accounttype
(
    accounttype_id integer NOT NULL,
    accounttype_name "char"[] NOT NULL,
    CONSTRAINT accounttype_pkey PRIMARY KEY (accounttype_id)
)

TABLESPACE pg_default;

ALTER TABLE public.accounttype
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.conditiontype
(
    conditiontype_id integer NOT NULL,
    conditiontype_name "char"[] NOT NULL,
    CONSTRAINT conditiontype_pkey PRIMARY KEY (conditiontype_id)
)

TABLESPACE pg_default;

ALTER TABLE public.conditiontype
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.request
(
    request_id integer NOT NULL,
    account_id integer NOT NULL,
    conditiontype_id integer NOT NULL,
    CONSTRAINT request_pkey PRIMARY KEY (request_id),
    CONSTRAINT fk2 FOREIGN KEY (account_id)
        REFERENCES public.account (account_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk3 FOREIGN KEY (conditiontype_id)
        REFERENCES public.conditiontype (conditiontype_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.request
    OWNER to postgres;

