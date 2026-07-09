create table products
(
    id          bigint         not null auto_increment
        primary key,
    name        varchar(255)   not null,
    price       decimal(10, 2) null,
    category_id tinyint        not null,
    constraint fk_category_id
        foreign key (category_id) references categories (id)
);