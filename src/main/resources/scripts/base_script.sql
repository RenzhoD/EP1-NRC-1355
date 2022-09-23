create table users (
	id int,
	name varchar(255),
	username varchar(20),
	tipDoc  char(5),
	nroDoc  varchar(20)
)

alter table users add primary key (id);

alter table users MODIFY column id int auto_increment not null;

INSERT INTO USERS (name,username,tipDoc,nroDoc)
VALUES ('Jorge','DNI73267572','DNI','73267572');

INSERT INTO USERS (name,username,tipDoc,nroDoc)
VALUES ('Maria','DNI46299021','DNI','46299021');

INSERT INTO USERS (name,username,tipDoc,nroDoc)
VALUES ('Oliver','DNI10054725','DNI','10054725');

INSERT INTO USERS (name,username,tipDoc,nroDoc)
VALUES ('Bruno','DNI72584671','DNI','72584671');

update users set name='Matt' where username ='DNI72584671'

select * from users