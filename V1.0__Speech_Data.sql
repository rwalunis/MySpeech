INSERT INTO users (first_name, last_name, email, state) VALUES ('Rachael', 'Remington', 'redwest422@aol.com', 'Ohio');
INSERT INTO users (first_name, last_name, email, state) VALUES ('Jenifer', 'Witt', 'jwitty@aol.com', 'Utah');
INSERT INTO users (first_name, last_name, email, state) VALUES ('Kyle', 'Blade', 'kb123@utoledo.edu', 'Ohio');
INSERT INTO users (first_name, last_name, email, state) VALUES ('Courtney', 'Googala', 'cgoggle@aol.com', 'New York');
INSERT INTO users (first_name, last_name, email, state) VALUES ('Tiffany', 'Redbottom', 'redtiff24522@aol.com', 'Colorado');

insert into work_settings (work_description) values ('hospital');
insert into work_settings (work_description) values ('acute care');
insert into work_settings (work_description) values ('school');
insert into work_settings (work_description) values ('critical illness hospital');
insert into work_settings (work_description) values ('skilled nursing facility');

insert into posts (user_id, post_description) values (2, 'Are oral motor exercises still a thing???');
insert into posts (user_id, post_description) values (4, 'Has anyone switched from the school setting into a skilled nursing facility? If so, how was the transition?');
insert into posts (user_id, post_description) values (4, 'Looking forward to my summer vacation.  The best perk to being a school slp!!');
insert into posts (user_id, post_description) values (1, 'Does anyone have their doctorate?');
insert into posts (user_id, post_description) values (3, 'Does anyone have any good recommendations for ENTs?');
insert into posts (user_id, post_description) values (3, 'Finally got my studentloans payed off! Twenty years later lol');

insert into comments (post_id, user_id, comment_description) values (1, 3, 'Yeah.  Honestly, the pay change isn\'t worth it though.');
insert into comments (post_id, user_id, comment_description) values (2, 1, 'If you are working with patients post radiation, yes. Other than that, the current evidence does not support oral motor exercises.');
insert into comments (post_id, user_id, comment_description) values (1, 2, 'I wish I hadn\'t made the switch because of the pay.');
insert into comments (post_id, user_id, comment_description) values (6, 5, 'Congrats!!!');
insert into comments (post_id, user_id, comment_description) values (6, 4, 'Nice! I only have 2 years to go!');
insert into comments (post_id, user_id, comment_description) values (4, 3, 'No, but I\'ve heard it\'s a lot of money.');
insert into comments (post_id, user_id, comment_description) values (2, 1, 'I have not, but it\s a complete 180.');


insert into users_work (work_id, user_id) values (1, 1);
insert into users_work (work_id, user_id) values (2, 2);
insert into users_work (work_id, user_id) values (3, 3);
insert into users_work (work_id, user_id) values (4, 4);
insert into users_work (work_id, user_id) values (5, 5);


	


