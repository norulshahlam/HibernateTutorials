There are two types of objects in Hibernate

1. Value Object
2. Entities

Value Objects are the objects which can not stand alone. Take Address, for example. If you say address, people will ask whose address is this. So it can not stand alone.

Entity Objects are those who can stand alone like College and Student.

So in case of value objects preferred way is to Embed them into an entity object.

To answer why we are creating two different classes: first of all, it's a OOPS concept that you should have loose coupling and high cohesion among classes. That means you should create classes for specialized purpose only. For example, your Student class should only have the info related to Student.

Second point is that by creating different classes you promote re-usability.

When we define the value object for the entity class we use @Embeddable.
When we use value type object in entity class we use @Embedded
