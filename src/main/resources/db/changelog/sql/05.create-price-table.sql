CREATE TABLE price (
                          id bigserial unique,
                          basic_price real,
                          vip_price real,
                          hot_price real,
                          PRIMARY KEY (id)
);