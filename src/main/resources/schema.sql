create table movies (
  id            bigserial      not null,
  name          varchar(255),
  category      varchar(255),
  rating        int             not null,
  description   varchar(255),
  primary key (id)
);

create table USERS_INFO (
  id            bigserial      not null,
  first_name    varchar(50),
  last_name     varchar(50),
  email         varchar(50),
  username      varchar(50),
  password      varchar(100),
  primary key (id)
);