# Order Management System

## Project Overview

This project implements an **Order Management System** with basic CRUD operations for managing orders and products. It consists of controllers, services, and repositories to interact with a database using **Spring Boot** and **JPA**.

## Methodology

### Test-Driven Development (TDD)

The project follows the **Test-Driven Development (TDD)** methodology. TDD emphasizes writing unit tests before writing the actual code. This approach ensures that the code is testable and meets the specified requirements. Each feature was implemented step-by-step, with tests written first to define the expected behavior and guide the development process.

### Testing Frameworks Used:
- **JUnit 5**: Used for writing unit tests for the service classes.
- **Mockito**: Used for mocking repository dependencies to isolate the service layer during testing.

## Features

- **Order Management**: Create, update, delete, and retrieve orders.
- **Product Management**: Create, update, delete, and retrieve products.

## Test Cases

Here are the key test cases written to validate the service layer functionality:

### OrderServiceTest
- **testCreateOrder**: Verifies that a new order is correctly created and saved in the repository.
- **testGetOrderById**: Ensures that an order can be retrieved by its ID.
- **testUpdateOrder**: Checks that an order can be updated with new details.
- **testDeleteOrder**: Ensures that an order is correctly deleted by ID.

### ProductServiceTest
- **testCreateProduct**: Verifies that a new product is created and saved in the repository.
- **testGetProductById**: Ensures that a product can be retrieved by its ID.
- **testUpdateProduct**: Checks that a product can be updated with new details.
- **testDeleteProduct**: Ensures that a product is correctly deleted by ID.

## Test Results

All test cases were run successfully. The assertions in the tests (e.g., `assertEquals`, `assertNotNull`) validated that the CRUD operations performed as expected, and the mock interactions with the repository were correct.

Sample test result output:

```
OrderServiceTest:
    ✓ testCreateOrder: PASSED
    ✓ testGetOrderById: PASSED
    ✓ testUpdateOrder: PASSED
    ✓ testDeleteOrder: PASSED

ProductServiceTest:
    ✓ testCreateProduct: PASSED
    ✓ testGetProductById: PASSED
    ✓ testUpdateProduct: PASSED
    ✓ testDeleteProduct: PASSED
```

## Prerequisites

- **Java 17** or higher
- **Maven 3.6** or higher
- **Spring Boot** (version specified in `pom.xml`)
- **H2 Database** or your configured database in `application.properties`

## Instructions to Build and Run the Project

### Step 1: Clone the Repository

```bash
git clone <repository_url>
cd order-management-system
```

### Step 2: Build the Project

You can build the project using **Maven**. This will download all dependencies and compile the code.

```bash
mvn clean install
```

### Step 3: Run the Application

You can run the Spring Boot application by executing the following command:

```bash
mvn spring-boot:run
```

The application will start on the default port (8080). You can access the REST endpoints using tools like Postman or Curl.

### Step 4: Running Tests

To run the tests, use the following Maven command:

```bash
mvn test
```

This command will execute all the test cases (unit tests) in the project. The results will be displayed in the console, and you can also check detailed results in the generated report in the `target` folder.

### Step 5: Accessing the API

Once the application is running, you can access the endpoints:

- **Orders**: `http://localhost:8080/orders`
- **Products**: `http://localhost:8080/products`

#### Example API Endpoints

1. **Create a new order**:
   ```bash
   POST /orders
   Content-Type: application/json
   Body: 
   {
       "customerName": "John Doe",
       "total": 150.00,
       "orderDescription": "Order for electronics"
   }
   ```

2. **Get an order by ID**:
   ```bash
   GET /orders/{id}
   ```

3. **Update an order**:
   ```bash
   PUT /orders/{id}
   Content-Type: application/json
   Body:
   {
       "customerName": "John Doe",
       "total": 175.00,
       "orderDescription": "Updated order"
   }
   ```

4. **Delete an order**:
   ```bash
   DELETE /orders/{id}
   ```

## Database Configuration

The project is configured to use an in-memory **H2** database by default. If you want to use another database, modify the `application.properties` file with the appropriate database URL, username, and password.

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

For a different database like MySQL, you can configure it as follows:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Future Improvements

- Implement comprehensive integration tests for the controller layer.
- Add pagination and sorting for order and product listings.
- Improve error handling and exception messages.

## Conclusion

This project demonstrates the use of **Spring Boot** for building a RESTful API, following the **TDD** methodology to ensure service functionality. The system is capable of managing orders and products with basic CRUD operations.
