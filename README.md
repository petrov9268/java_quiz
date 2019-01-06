# Java Quiz

Simple Java Quiz web application. Created with [Spring Framework][spr].
For learning purposes.

## Features:
* currently reacts to:
```
localhost:8080/course/all
localhost:8080/course/add?name=String
localhost:8080/course/delete?id=Long
```
* if id exists, shows corresponding pages `localhost:8080/course/show?id=Long`

## Requirements:
* JDK 1.8 or later
* Maven 3.2 or later

## TODO:
- model view is working, but unexpectedly
- recreate index page
- add shutdown feature (?)
- create templates for db
- add social interactions (aka comments)
- add quiz itself
- get rid of helloworld
- add js (?)
- add css (?)
- unit tests (?)

[spr]: https://spring.io/ "Spring"