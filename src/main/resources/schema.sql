create table if not exists t_user(
  id int auto_increment,
  username varchar(50) not null,
  password varchar(100) not null,
  name varchar(50) not null,
  primary key(id)
);

create table if not exists t_authority(
  id int auto_increment,
  authority varchar(50),
  primary key(id)
);

create table if not exists t_user_authorities(
  id int auto_increment,
  user_id int,
  authority_id int,
  primary key(id),
  foreign key (user_id) references t_user(id),
  foreign key (authority_id) references t_authority(id)
);

create table if not exists t_product (
  id int auto_increment,
  name varchar(100) not null,
  price decimal(10, 2) not null default 0,
  expire_date date,
  primary key(id)
);