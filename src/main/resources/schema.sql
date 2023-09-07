drop table if exists mybatis2.users;

create or replace table mybatis2.users
(
    id           varchar(20) not null primary key,
    user_id      varchar(20) not null,
    user_nm      varchar(50) null,
    password     varchar(200) null,
    access_token varchar(200) null,
    email        varchar(50) null,
    phone        varchar(30) null,
    create_at    datetime default current_timestamp() null,
    updated_at   datetime default current_timestamp() null,
    deleted_at   datetime default current_timestamp() null
);

create or replace index users_user_id_index
    on mybatis2.users (user_id);

