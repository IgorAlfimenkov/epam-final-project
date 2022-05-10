CREATE TABLE tour_category (
                      tour_id integer ,
                      category_id integer,
                      PRIMARY KEY (tour_id, category_id),
                      foreign key (tour_id) references tour(id),
                      foreign key (category_id) references category(id)
);