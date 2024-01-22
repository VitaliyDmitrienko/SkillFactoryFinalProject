CREATE SCHEMA IF NOT EXISTS PUBLIC;

CREATE TABLE IF NOT EXISTS PUBLIC.DEPOSITOR (ID INT AUTO_INCREMENT PRIMARY KEY, BALANCE NUMERIC);

create table public.operation (
	id INT AUTO_INCREMENT primary key,
	depositor_donor_id INT not null,
	depositor_acceptor_id INT not null,
	operation_type INT not null,
	change_balance NUMERIC,
	operation_date timestamp
--	FOREIGN KEY (depositor_donor_id) REFERENCES depositor (id) ON DELETE CASCADE,
--	FOREIGN KEY (depositor_acceptor_id) REFERENCES depositor (id) ON DELETE CASCADE
    );