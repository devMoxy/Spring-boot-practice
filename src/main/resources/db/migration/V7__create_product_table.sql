create table products
(
    id          bigint         not null
        primary key,
    name        varchar(255)   not null,
    price       decimal(10, 2) null,
    category_id tinyint        not null,
    constraint category_id
        foreign key (category_id) references categories (id)
);

