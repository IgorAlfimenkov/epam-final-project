CREATE TABLE ticket (
                      id bigserial unique,
                      customer_name varchar,
                      customer_surname varchar,
                      date timestamp,
                      tour_id integer,
                      user_id integer,
                      PRIMARY KEY (id),
                      foreign key (tour_id) references tour(id),
                      foreign key (user_id) references users(id)
);