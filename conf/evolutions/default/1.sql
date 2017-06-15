# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table diretor (
  id                            bigserial not null,
  nome                          varchar(255),
  constraint pk_diretor primary key (id)
);

create table filmes_cult (
  id                            bigserial not null,
  nome                          varchar(255),
  tipo                          varchar(255),
  nota                          float,
  duracao                       integer,
  ano                           integer,
  genero                        varchar(255),
  votos                         integer,
  url                           varchar(255),
  diretor_id                    bigint,
  constraint pk_filmes_cult primary key (id)
);

alter table filmes_cult add constraint fk_filmes_cult_diretor_id foreign key (diretor_id) references diretor (id) on delete restrict on update restrict;
create index ix_filmes_cult_diretor_id on filmes_cult (diretor_id);


# --- !Downs

alter table if exists filmes_cult drop constraint if exists fk_filmes_cult_diretor_id;
drop index if exists ix_filmes_cult_diretor_id;

drop table if exists diretor cascade;

drop table if exists filmes_cult cascade;

