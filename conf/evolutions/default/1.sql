# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table diretor (
  id                            bigserial not null,
  nome                          varchar(255),
  constraint pk_diretor primary key (id)
);


# --- !Downs

drop table if exists diretor cascade;

