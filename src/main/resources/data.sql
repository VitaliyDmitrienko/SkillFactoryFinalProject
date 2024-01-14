create table depositor (
  id serial PRIMARY KEY,
  balance money)

create table operation (
	id serial primary key,
	depositor_id integer not null,
	operation_type integer not null,
	changebalance money,
	operation_date timestamp,
	FOREIGN KEY (depositor_id) REFERENCES depositor (id) ON DELETE CASCADE);