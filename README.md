# Java Microservice CRUD Operation using H2 Database
## Spring Boot,  Spring Data JPA,  H2 Database,  Postman,  Lombok,  Microservice Architecture

Developed a microservice-based REST API using Spring Boot, performing CRUD operations on a book database. Implemented data persistence with an H2 in-memory database and demonstrated API functionality using Postman. Structured the project following best practices with clear separation of concerns (model, controller, repository). Enabled comprehensive configuration and monitoring through Spring Boot annotations and properties.

#### Understanding MVC Architecture
_______________________________________________________________________________________________________________
<img width="1440" alt="Screenshot 2024-06-06 at 10 04 49 PM" src="https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/9f7b2212-f116-438c-9c4b-37b4421cf5b2">

#### Model-View-Controller (MVC) is a design pattern that separates an application into three components:
_________________________________________________________________________________________________________________
- Model: Manages data and business logic (e.g., Book class).
- View: Handles the presentation layer (e.g., Postman for testing API responses).
- Controller: Processes user input, updates the model, and returns data to the view (e.g., BookController).
  
This separation improves organization, maintainability, and scalability.

---------------------------------------------------------------------------------------------------

#### The Dependencies added for creating the Spring project
__________________________________________________________________________________________________________________

![Screenshot 2024-06-07 103241](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/ae5e1fa6-016a-432e-8f8f-c2238edc7fd2)

------------------------------------------------------------------------------------------------------------------

![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) - This code defines a Book entity class that will be mapped to a "Books" table in a database. The class is annotated with JPA and Lombok annotations to handle database interactions and reduce boilerplate code, respectively. The id field is auto-generated and serves as the primary key, while title and author are standard fields representing attributes of the book. 

#### Create Package named "model" -> Create a class named "Book" inside it

![Screenshot 2024-06-06 210723](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/36973db5-a589-4a48-bf50-e533c654be78)

____________________________________________________________________________________________________


![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) - This code defines a repository interface for managing Book entities. By extending JpaRepository, the BookRepo interface inherits several methods for performing CRUD operations, such as saving, deleting, and finding Book entities. The @Repository annotation marks it as a Spring Data repository, which allows Spring to detect it during component scanning and enables exception translation. This setup significantly reduces the amount of boilerplate code needed to interact with the database.

#### Create Package named "repository" -> Create a class named "BookRepo" inside it

![Screenshot 2024-06-06 210538](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/428f0ed5-86f3-404d-b0b3-ddf2594431d0)

_____________________________________________________________________________________________________


![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) - This code defines a RESTful controller for managing Book entities in a microservice. It includes methods for retrieving all books, retrieving a book by its ID, adding a new book, updating an existing book, and deleting a book by its ID. Each method maps to an HTTP request and returns an appropriate response with HTTP status codes. The controller uses BookRepo to interact with the database, leveraging Spring's dependency injection and response entity handling to manage the CRUD operations efficiently.

#### Create Package named "controller" -> Create a class named "BookController" inside it

![Screenshot 2024-06-06 210853](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/db05ca28-14b6-45e8-9d48-119b0c30f1ce)

![Screenshot 2024-06-06 210931](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/e743d454-022a-48ab-af22-93d85d647263)

![Screenshot 2024-06-06 210950](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/177f474d-28e7-4f60-b1fe-7efda257ff13)

______________________________________________________________________________________________________

![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png) - The MicroserviceDemoGetApplication class serves as the entry point for the Spring Boot application. The @SpringBootApplication annotation enables auto-configuration, component scanning, and configuration of the application context. The main method calls SpringApplication.run, which initializes and runs the application, setting up the necessary components and starting the embedded server.

### Main Method
_______________________________________________________________________________________________________

![Screenshot 2024-06-06 211716](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/d2c73c90-1cea-4e85-9032-aa5ded41beb4)

This configuration file sets up the basic settings for a Spring Boot application using an H2 in-memory database. Key points include:

--------------------------------------------------------------------------------------------------------


![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png) - Naming the application and setting the server port.
Configuring the datasource with JDBC URL, driver, username, and password.
Enabling SQL logging and specifying the Hibernate dialect for H2.
Enabling and configuring the H2 console for web access.
These settings are particularly useful for development and testing environments, providing a quick and easy way to work with an in-memory database and view its contents through the H2 console.

### application.properties


![Screenshot 2024-06-06 211334](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/e5312bae-d18d-49fd-8377-1b4336d5e74b)


________________________________________________________________________________________________________

#### Now run the main file

![Screenshot 2024-06-06 212016](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/31106158-bbf8-48c6-b32d-f4e7716b5451)


#### The program is running in Tomcat server port 9090

![Screenshot 2024-06-06 212122](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/655675b5-c4c4-4779-b8ae-b79a1807e703)


#### Check in the 9090 Tomcat server

![Screenshot 2024-06-06 212403](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/6949832a-5078-420d-a435-9cdb23bcf6af)

#### Test the connection

![Screenshot 2024-06-06 212539](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/678ecc21-3ef1-4592-a528-fbdbd137553e)

#### And then click on Connect
#### H2 Database will open

![Screenshot 2024-06-06 212641](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/233b3b82-6e7f-4037-8515-1f70d190eb1e)

______________________________________________________________________________________________________


### Now we will use PostMan

The Table which we have named Books is empty, so we need to add a few entries

#### Using "/addBook" using Post Mapping for adding new entries

![Screenshot 2024-06-06 213022](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/2be008a2-6266-402b-b99a-71de89efa0f1)

#### Add a few more entries
#### Now, see all the entries by using "getAllBooks"

![Screenshot 2024-06-06 213419](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/e9a99feb-183d-49a2-8c8f-2b792ea0b850)

#### Now get an Entry based on "Id"

![Screenshot 2024-06-06 213537](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/97e56d94-6583-4d4b-b13e-c7c938d5d507)

#### Now let's update entry 3 and rename the title "Chokher Bali" to "Gora"

![Screenshot 2024-06-06 213849](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/5bc3e266-2b18-4b21-a919-8a3da507bb18)

### And let's delete the last entry numbered 5

![Screenshot 2024-06-06 214020](https://github.com/SohamJana11/Java-Microservice---CRUD-Operation/assets/162604344/498b4d7b-1d72-41b4-8385-c00dfee68c16)

__________________________________________________________________________________________________

Hurrahhh, finally made it. Here's the scoop:

Model: The data and business logic hero (e.g., Book class).
View: The fancy presentation layer (think Postman showing off the API responses).
Controller: The middleman juggling user input, updating the model, and sending info back to the view (our pal, BookController).
Because who doesn't love organized, maintainable, and scalable code, right?










