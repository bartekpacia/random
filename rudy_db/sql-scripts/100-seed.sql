\c rudy;

SET search_path TO rudy_schema, public;

INSERT INTO rudy_schema.users (email, name)
VALUES ('barpac02@gmail.com', 'Bartek Pacia'),
       ('olusiaOP05@gmail.com', 'Ola Pacia'),
       ('ogorka@gmail.com', 'Oskar Górka'),
       ('charlie.root@gmail.com', 'Charlie Root');


INSERT INTO rudy_schema.places (id, name)
VALUES ('opactwo', 'Opactwo'),
       ('dab_cysters', 'Dąb Cysters'),
       ('wyspa_zapachow', 'Wyspa Zapachów'),
       ('lesna_kapliczka', 'Leśna Kapliczka');

INSERT INTO rudy_schema.visits (user_id, place_id)
VALUES (1, 'opactwo'),
       (1, 'dab_cysters'),
       (1, 'wyspa_zapachow'),
       (2, 'opactwo'),
       (2, 'dab_cysters'),
       (3, 'opactwo'),
       (3, 'wyspa_zapachow'),
       (4, 'lesna_kapliczka');
