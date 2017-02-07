create table Actor (id bigint not null, name varchar(50) not null, version integer not null, primary key (id));
create table Movie (id bigint not null, name varchar(50) not null, version integer not null, REALEASE_DATE timestamp, primary key (id));
create table Movie_Actor (movies_id bigint not null, actors_id bigint not null);
alter table Movie_Actor add constraint FK_91kgmiydp0q9x6januhgh0ink foreign key (actors_id) references Actor;
alter table Movie_Actor add constraint FK_i0j8icr9c7w48ecapkr3qu3q0 foreign key (movies_id) references Movie;
create table ID_GENERATOR ( GEN_ID varchar(255) not null , GEN_VALUE bigint, primary key ( GEN_ID ) );