CREATE TABLE tour (
                       id bigserial unique,
                       name varchar,
                       description text,
                       ticket_quantity integer,
                       is_hot boolean,
                       price_id integer,
                       PRIMARY KEY (id),
                       foreign key (price_id) references price(id)
);