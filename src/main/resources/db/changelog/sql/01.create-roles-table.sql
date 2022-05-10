CREATE TABLE roles (
                       id bigserial unique,
                       name varchar(20) NOT NULL unique,
                       PRIMARY KEY (id)
);