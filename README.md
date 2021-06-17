### Hibernate Tutorials

Hibernate is a Java framework that simplifies the development of Java application to interact with the database. It is an open source, lightweight, ORM (Object Relational Mapping) tool. Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.

`ORM Tool`
An ORM tool simplifies the data creation, data manipulation and data access. It is a programming technique that maps the object to the data stored in the database.

[https://www.javatpoint.com/hibernate-tutorial]

hi shah. if you are revisiting this since your last use was some time ago, i hope this helps to guide u so u can recap in the
fastest way possible. also how to use hibernate from scratch.

a. make sure you have installed mysql, and the db is running!
b. after mysql installation, when configure server, make sure port number is same as the one in config.
c. password defined in mysql server is same as in config.
d. create db using mysql
e. create db in mysql. run this query in mysql:

create database Hibernate:
use Hibernate;
select \* from alien;

f. hibernate core orm & mysql connector in pom.xml. make sure mysql conn is same version as mysql server version (the first 2 digits ie 8.0.xx)
g. create hibernate.config from hibernate config settings
h. create entity by creating ALien class with POJO. indicate @Entity, @id 4. in main.class, use 5 lines for initiating hibernate
i. in main, create obj of Alien, insert data, then save & commit object.
j. then run java. check in mysql if the data is updated

visitng each package by order:
DemoHib
Embeddable
NoRelationship
OneToOne
OneToMany
ManyToOne
ManyToMany
Lazy (and eager inside)
Caching
Caching with Query
HQL1
objectStates
getVSload
