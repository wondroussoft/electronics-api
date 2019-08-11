DO
$body$
BEGIN
    IF NOT EXISTS(
            SELECT *
            FROM pg_catalog.pg_user
            WHERE usename = 'hmsit')
    THEN
        CREATE ROLE hmsit WITH PASSWORD 'hmsit@123';
    END IF;
END
$body$;

ALTER ROLE hmsit NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION LOGIN;
