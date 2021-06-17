### Hibernate Tutorials

Hibernate is a Java framework that simplifies the development of Java application to interact with the database. It is an open source, lightweight, ORM (Object Relational Mapping) tool. Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.

`ORM Tool`
An ORM tool simplifies the data creation, data manipulation and data access. It is a programming technique that maps the object to the data stored in the database.

[https://www.javatpoint.com/hibernate-tutorial]

hi shah. if you are revisiting this since your last use was some time ago, i hope this helps to guide u so u can recap in the
fastest way possible. also how to use hibernate from scratch.

make sure you have installed mysql, and the db is running!

0. create db using mysql

create database Hibernate;
use Hibernate;
select \* from alien;

1. hibernate core orm & mysql connector in pom.xml. make sure mysql conn is same version as mysql server version
2. create hibernate.config fro hivernate config settings
3. create entity by creating ALien class with POJO. indicate @Entity, @id
4. in main.class, use 5 lines for initiating hibernate
5. in main, create obj of Alien, insert data, then save & commit object.

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
