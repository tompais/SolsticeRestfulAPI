# SolsticeRestfulAPI

This project has all the elements to do the following requests:

- Get (can be filtered by email, workNumber, personalNumber, city and/or state)
- GetById (get a record by its Id)
- GetByEmail (get a record by its email)
- Post (it doesn't allow you to insert a contact with an email that already exists)
- Put (you can modify whatever you want from the contact, except the id itself. It won't let you make a modification of the contact email if it already exists)
- Delete (By default, the deletetion is done by ID. It throws an exception if the record doesn't exist)
- DeleteByEmail (The same concept as the previous one, but with an email)

I used IntelliJ IDEA IDE and Eclipse to develop.
I used JBoss 9 / Wildfly 17 to mount the services and use them with Postman.
I used JAX-RS (Java API for RESTful Web Services) to make this project.
The tests were made using Jersey.

You'll find a "postman" folder with samples that will show you how to run the services.

Here is an example of an HttpGet Request URI: http://localhost:8080/SolsticeRestfulAPI-0.0.1-SNAPSHOT/api/contact?email=test@gmail.com