-- auto-generated definition
create table users
(
    id        bigint       not null primary key,
    email     varchar(255) null,
    name      varchar(255) null,
    last_name varchar(255) null,
    unique (email)
)
    engine = InnoDB;