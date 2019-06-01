create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
create table copsboot_user (id uuid not null, email varchar(255), password varchar(255), primary key (id))
create table report (id uuid not null, date_time timestamp, description varchar(255), reporter_id uuid, primary key (id))
create table user_roles (user_id uuid not null, roles varchar(255))
alter table report add constraint FK4yqgwqrnl5y25qxhknq24fwbg foreign key (reporter_id) references copsboot_user
alter table user_roles add constraint FK7je59ku3x462eqxu4ss3das1s foreign key (user_id) references copsboot_user
