
-- ON POSTMAN:*/


/*---  CREATE  ---*/
POST-> Body -> raw(JSON): http://localhost:8080/tasks
{
"title": "Programando CRUD",
"date": "1980-03-25T22:41:58.436+00:00"
}


/*---  RETRIEVE  ---*/
GET -> http://localhost:8080/users


/*---  UPDATE  ---*/
PUT -> Body -> raw(JSON): http://localhost:8080/tasks/1
{
"title": "Testando CRUD",
"date": "1992-10-03T20:41:58.436+00:00"
}


/*---  DELETE  ---*/
DELETE -> http://localhost:8080/tasks/1