CREATE SCHEMA IF NOT EXISTS PUBLIC;

CREATE TABLE IF NOT EXISTS PUBLIC.DEPOSITOR (
  id SERIAL PRIMARY KEY,
  balance money
  );

--create table public.operation (
--	id serial primary key,
--	depositor_donor_id integer not null,
--	depositor_acceptor_id integer not null,
--	operation_type integer not null,
--	change_balance money,
--	operation_date timestamp,
--	FOREIGN KEY (depositor_donor_id) REFERENCES depositor (id) ON DELETE CASCADE,
--	FOREIGN KEY (depositor_acceptor_id) REFERENCES depositor (id) ON DELETE CASCADE);