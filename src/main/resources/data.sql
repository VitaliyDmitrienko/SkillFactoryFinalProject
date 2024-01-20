create table depositor (
  id serial PRIMARY KEY,
  balance money)

create table operation (
	id serial primary key,
	depositor_donor_id integer not null,
	depositor_acceptor_id integer not null,
	operation_type integer not null,
	change_balance money,
	operation_date timestamp,
	FOREIGN KEY (depositor_donor_id) REFERENCES depositor (id) ON DELETE CASCADE,
	FOREIGN KEY (depositor_acceptor_id) REFERENCES depositor (id) ON DELETE CASCADE);