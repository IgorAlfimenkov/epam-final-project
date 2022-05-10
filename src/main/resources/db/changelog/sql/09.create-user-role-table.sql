CREATE TABLE user_role (
                               cred_id integer ,
                               role_id integer,
                               PRIMARY KEY (cred_id, role_id),
                               foreign key (cred_id) references credentials(id),
                               foreign key (role_id) references roles(id)
);