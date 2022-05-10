CREATE TABLE users (
                       id bigserial unique,
                       credentials_id integer,
                       email varchar(15) null,
                       name varchar null,
                       surname varchar null,
                       PRIMARY KEY (id),
                       foreign key (credentials_id) references credentials(id)
);