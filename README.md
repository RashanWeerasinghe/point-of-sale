# Point of Sale (POS) System

## Project Description
The Point of Sale (POS) System is a robust software application designed to manage customer data and transactions efficiently. It provides a set of RESTful APIs to perform various customer-related operations.

### Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL Database

### Project Architecture
This project follows a monolithic architecture with a layered structure consisting of the following components:
- Controllers
- DTOs (Data Transfer Objects)
- Entities
- Exceptions
- Repositories
- Services
- Service Implementations

### API Design
The following RESTful APIs are available for customer management:

#### Customer API (Version 1: `api/v1/customer`)
- `POST /save`: Add a new customer
- `PUT /update`: Update customer details
- `GET /get-all-customer`: Get a list of all customers
- `GET /get-by-id?id={id}`: Get a customer by ID
- `GET /get-by-active-state`: Get all customers by active state
- `GET /get-by-active-state-only-name`: Get all customers by active state, only including their names
- `PUT /update-query/{id}`: Update a customer using a query
- `GET /get-by-nic?nic={nic}`: Get a customer by NIC (National Identity Card) number
- `GET /get-by-filter?id={id}`: Get a customer using filter criteria
- `PUT /update-by-request/{id}`: Update a customer using a request body
- `GET /get-by-id-is-active?id={id}`: Get all customers by their active state based on ID

### Folder Structure
The project's folder structure is organized as follows:
- `src/`: Main source code directory
  - `main/`: Main application code
    - `java/com/example/pos/`: Java source files
      - `controller/`: Controllers for handling API requests
      - `dto/`: Data Transfer Objects for request and response payloads
      - `entity/`: Entity classes representing database tables
      - `exception/`: Custom exception classes
      - `repository/`: Data repositories for database operations
      - `service/`: Service interfaces
      - `serviceImpl/`: Implementations of service interfaces
    - `resources/`: Application configuration files and resources
      - `application.properties`: Configuration properties
- `pom.xml`: Maven project configuration

### Highlights
- Spring Boot and Spring Data JPA are used to build the backend of this POS system.
- MySQL is used as the database for storing customer data.
- The project follows a monolithic architecture with well-defined layers for separation of concerns.
- The RESTful APIs are designed to handle various customer-related operations with different endpoints.

Feel free to explore the code and contribute to the project!

## Getting Started
To get started with the Point of Sale System, follow these steps:

1. Clone the project repository from [GitHub](https://github.com/RashanWeerasinghe/point-of-sale.git).
2. Set up a MySQL database and configure the database connection in `application.properties`.
3. Build and run the project using Maven or your preferred IDE.
4. Access the APIs as described in the API section.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
