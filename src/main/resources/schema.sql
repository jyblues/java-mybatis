drop table if exists mybatis2.users;

create table mybatis2.users
(
    id           bigint auto_increment,
    name         varchar(50)                          null,
    password     varchar(200)                         null,
    access_token varchar(200)                         null,
    email        varchar(50)                          not null
        primary key,
    phone        varchar(30)                          null,
    create_at    datetime default current_timestamp() null,
    updated_at   datetime default current_timestamp() null,
    deleted_at   datetime default current_timestamp() null,
    constraint users_id_email_name_uindex
        unique (id, email, name)
);

