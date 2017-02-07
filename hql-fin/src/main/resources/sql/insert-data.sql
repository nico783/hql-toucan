insert into ACTOR values (1, 'Jack Nicholson', 1);
insert into ACTOR values (2, 'Leonardo DiCaprio', 1);
insert into ACTOR values (3, 'Matt Damon', 1);
insert into ACTOR values (4, 'Tom Hanks', 1);
insert into ACTOR values (5, 'Ellen Page', 1);
insert into ACTOR values (6, 'Christopher Walken', 1);
insert into ACTOR values (7, 'Morgan Freeman', 1);
insert into ACTOR values (8, 'Al Pacino', 1);
insert into ACTOR values (9, 'Harrison Ford', 1);
insert into ACTOR values (10, 'Carrie Fisher', 1);
--
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (1, 'Les infiltres', 1, CURRENT_TIMESTAMP);
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (2, 'Inception', 1, CURRENT_TIMESTAMP);
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (3, 'Arrete-moi si tu peux', 1, CURRENT_TIMESTAMP);
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (4, 'Il faut sauver le soldat Ryan', 1, CURRENT_TIMESTAMP);
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (5, 'Les evades', 1, CURRENT_TIMESTAMP);
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (6, 'Le parrain', 1, CURRENT_TIMESTAMP);
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (7, 'L''empire contre-attaque', 1, CURRENT_TIMESTAMP);
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (8, 'Forrest Gump', 1, CURRENT_TIMESTAMP);
insert into MOVIE (ID, NAME, VERSION, REALEASE_DATE) values (9, 'Expendables 3', 1, CURRENT_TIMESTAMP);
--
insert into MOVIE_ACTOR values (1, 1);
insert into MOVIE_ACTOR values (1, 2);
insert into MOVIE_ACTOR values (1, 3);
insert into MOVIE_ACTOR values (2, 2);
insert into MOVIE_ACTOR values (2, 5);
insert into MOVIE_ACTOR values (3, 2);
insert into MOVIE_ACTOR values (3, 4);
insert into MOVIE_ACTOR values (3, 6);
insert into MOVIE_ACTOR values (4, 3);
insert into MOVIE_ACTOR values (4, 4);
insert into MOVIE_ACTOR values (5, 7);
insert into MOVIE_ACTOR values (6, 8);
insert into MOVIE_ACTOR values (7, 9);
insert into MOVIE_ACTOR values (7, 10);
insert into MOVIE_ACTOR values (8, 4);
insert into MOVIE_ACTOR values (9, 9);
