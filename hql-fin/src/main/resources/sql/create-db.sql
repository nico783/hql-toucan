create table Actor (id bigint not null, name varchar(50) not null, version integer not null, primary key (id));
create table Movie (id bigint not null, name varchar(50) not null, version integer not null, REALEASE_DATE timestamp, primary key (id));
create table Movie_Actor (movies_id bigint not null, actors_id bigint not null);
