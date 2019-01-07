# Java Quiz

Simple Java Quiz web application. Created with [Spring Framework][spr].
For learning purposes.

## Features:
* shows corresponding pages `localhost:8080/course/show?page=int`
* currently reacts to:
```
localhost:8080/course/all
localhost:8080/course/test
localhost:8080/course/add?title=String&text=String
localhost:8080/course/delete?id=Long
localhost:8080/course/update?id=Long&title=String&text=String
```

## Requirements:
* JDK 1.8 or later
* Maven 3.2 or later

## TODO:
- fix show?page=, currently shows empty page, when out of bounds
- comments and add/delete/update pages/buttons
- other POST/GET stuff
- add check yourself (aka quiz)
- get rid of helloworld and other leftovers
- finish/fix pagination (?)
- unit tests (?)
- css (?)

[spr]: https://spring.io/ "Spring"
