
-- ON POSTMAN:*/


/*---  CREATE  ---*/
POST-> Body -> raw(JSON): http://localhost:8080/tasks
{
"title": Criando CRUD",
"date": "25/02/2021"
}


/*---  RETRIEVE  ---*/
GET -> http://localhost:8080/users


/*---  UPDATE  ---*/
PUT -> Body -> raw(JSON): http://localhost:8080/tasks/1
{
"title": "Testando CRUD",
"date": "09/03/2021"
}


/*---  DELETE  ---*/
DELETE -> http://localhost:8080/tasks/1


/*---  EXTRA UPDATES and READ  ---*/
GET -> http://localhost:8080/users/addDay
GET -> http://localhost:8080/users/addWeek
GET -> http://localhost:8080/users/addMonth