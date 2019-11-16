Spring Security
================

Authentication

1.BASIC
2.DIGEST
3.FORM



Spring boot 1.5 : Default : Basic Authentication

Spring boot 2.x : Default : FORM Authentication

              Default username :user
              Default password :generated on console
              
              
             
             
             
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;


create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

insert into users(username, password, enabled)values('pradeep','$2a$10$LvLqGSYjOlTicENx.CTAkuCbRGGQeNieqVIQAxNTPFwXcEn3CuhiK',true);
insert into authorities(username,authority)values('pradeep','ROLE_ADMIN');
 
insert into users(username, password, enabled)values('ram','$2a$10$dn7KQBRgBeIGp7fXUj/K/e53B7cccjkRK56H0li8YhVcT6nBRuhDa',true);
insert into authorities(username,authority)values('ram','ROLE_USER');


insert into users(username, password, enabled)values('raj','$2a$10$0olmvmwaviJF.tQd5UPvKeobUxYTiz3.rCRYV42riysFNvO2pbY9a',true);
insert into authorities(username,authority)values('raj','ROLE_STUDENT');


insert into users(username, password, enabled)values('india','$2a$10$0olmvmwaviJF.tQd5UPvKeobUxYTiz3.rCRYV42riysFNvO2pbY9a',true);
insert into authorities(username,authority)values('india','TEACHER');

               







