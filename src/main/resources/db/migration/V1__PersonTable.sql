--DROP TABLE flyway_schema_history;DROP TABLE score; DROP TABLE person;
create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
	enabled boolean not null
);
create table authorities (
	username varchar(50) not null,
	authority varchar(50) DEFAULT 'EMPLOYEE',
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

create table persistent_logins(
	username varchar(50) not null,
	series varchar(64) primary key,
	token varchar(64) not null,
	last_used timestamp not null
);

CREATE TABLE scores(
username varchar(50) not null REFERENCES users(username),
total_time_worked INTEGER,
indle_time INTEGER,
date DATE DEFAULT now(),
slimtip_repairs INTEGER,
c_shell_repairs INTEGER,
itc_remakes INTEGER,
ite_repairs INTEGER,
bte_ric_repairs INTEGER,
ite_devices_in INTEGER,
bte_devices_in INTEGER,
ite_orders_in INTEGER,
accessories INTEGER,
bte_creating_repairs_raports INTEGER,
ite_creating_repairs_raports INTEGER,
orders_scan INTEGER,
devices_out INTEGER,
"reset" INTEGER,
housing_replacement INTEGER,
constraint username_date_constraint unique (username,date)
);

CREATE TABLE times(
total_time_worked INTEGER NOT NULL,
indle_time INTEGER NOT NULL,
date DATE NOT NULL,
constraint date_constraint unique (date)
--slimtip_repairs INTEGER,
--c_shell_repairs INTEGER,
--itc_remakes INTEGER,
--ite_repairs INTEGER,
--bte_ric_repairs INTEGER,
--ite_devices_in INTEGER,
--bte_devices_in INTEGER,
--ite_orders_in INTEGER,
--accessories INTEGER,
--bte_creating_repairs_raports INTEGER,
--ite_creating_repairs_raports INTEGER,
--orders_scan INTEGER,
--devices_out INTEGER,
--"reset" INTEGER,
--housing_replacement INTEGER,
);

insert into users (username,password,first_name, last_name, enabled)
	values ('admin','$2a$10$ZcJuUiAU2wnzzMLGfos9UuoxB.n9B2QnT5p285OALbRPoGJW3fbhu', 'Tomek', 'Politowski', true);
insert into authorities (username,authority)
	values ('admin','ROLE_ADMIN');
	insert into users (username,password,first_name, last_name, enabled)
	values ('tom','$2a$10$ZcJuUiAU2wnzzMLGfos9UuoxB.n9B2QnT5p285OALbRPoGJW3fbhu', 'Maciej', 'Dziu', true);
insert into authorities (username,authority)
	values ('tom','ROLE_EMPLOYEE');
	INSERT INTO scores (username, total_time_worked, indle_time, date) VALUES ('admin',0,0,'2015-12-11');
	INSERT INTO scores (username, total_time_worked, indle_time, date) VALUES ('tom',0,0,'2015-12-11');


