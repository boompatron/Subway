create table sandwich
(
    sandwich_id         bigint      primary key     auto_increment,
    sandwich_name       varchar(50),
    price               bigint,
    bread               varchar(15),
    cheese              varchar(15),
    meat                varchar(15),
    sauce               varchar(15),
    vegetable           varchar(15),
    order_status        varchar(10),
    created_at          datetime default current_timestamp(),
)