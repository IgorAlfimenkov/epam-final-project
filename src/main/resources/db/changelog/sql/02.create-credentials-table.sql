CREATE TABLE credentials (
    id bigserial unique,
    username varchar(49) not null unique,
    password varchar(255) not null,
    primary key (id)
);