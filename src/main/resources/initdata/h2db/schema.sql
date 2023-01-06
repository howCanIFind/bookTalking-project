drop table if exists Book CASCADE ;
drop table if exists Member CASCADE ;
drop table if exists Memo CASCADE ;

create table Book (
       id bigint not null,
        author varchar(255),
        companyName varchar(255),
        name varchar(255),
        summary varchar(255),
        primary key (id)
    );

create table Member (
       id bigint not null,
        email varchar(255),
        password varchar(255),
        provider varchar(255),
        providerId varchar(255),
        role varchar(255),
        username varchar(255),
        primary key (id)
    );

create table Memo (
       id bigint not null,
        content varchar(255),
        book_id bigint,
        primary key (id)
    );

alter table Memo 
       add constraint FKbhxxicxwwufko2xnf9lh7niy5 
       foreign key (book_id) 
       references Book
