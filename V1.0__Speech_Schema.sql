drop table if exists users_work;
drop table if exists comments;
drop table if exists posts;
drop table if exists work_settings;
drop table if exists users;

CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  email varchar(40) NOT NULL,
  state varchar(20),
  PRIMARY KEY (id)
);


CREATE TABLE work_settings (
  id int NOT NULL AUTO_INCREMENT,
  work_description varchar(500) NOT NULL,  
  PRIMARY KEY (id)
 
);


create table posts (
  id int not null auto_increment,
  user_id int not null,
  post_description varchar(500) not null,
  primary key(id),
  foreign key(user_id) references users(id) on delete cascade
);

create table comments (
  id int not null auto_increment,
  post_id int not null,
  user_id int not null,
  comment_description varchar (500) not null,
  primary key(id),
  foreign key(post_id) references posts(id) on delete cascade,
  foreign key(user_id) references users(id) on delete cascade
);


create table users_work (
   work_id int not null,
   user_id int not null,
   FOREIGN KEY (work_id) references work_settings (id) on delete cascade,
   FOREIGN KEY (user_id) references users (id) on delete cascade
   
);   

      
