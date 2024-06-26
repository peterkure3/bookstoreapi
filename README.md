# Bookstore Inventory System Documentation

The Bookstore API is a RESTful web service designed to manage books, authors, publishers, categories, customers, orders, and order items for an online bookstore platform. This API provides endpoints for various CRUD (Create, Read, Update, Delete) operations to handle the bookstore's functionalities.

## Project Overview

The project is divided into multiple milestones, each focusing on specific aspects of development. Here's a brief overview of the project milestones:

1. **Setup and Configuration:** Set up the Spring Boot project, configure dependencies, database integration, and implement basic CRUD operations for managing books, authors, and categories.

2. **Authentication and Authorization:** Implement user authentication and authorization using Spring Security and JWT authentication, along with role-based access control (RBAC) for secure API endpoints.

3. **Order Management:** Develop features for managing orders, including creation, retrieval, update, and cancellation, ensuring secure operations for authenticated users.

4. **Advanced Features and Enhancements:** Implement additional features such as search functionality, pagination, filtering, error handling, validation, and API versioning to enhance the system's functionality and usability.

5. **Testing, Documentation, and CI/CD:** Write comprehensive unit tests, generate detailed API documentation, document the project setup, architecture, design decisions, and implement CI/CD pipelines for automated build, test, and deployment processes.

## Features

- **Books:** Create, read, update, and delete books. Each book contains information such as title, ISBN, price, published date, cover image, associated author, publisher, and categories.
- **Authors:** Manage authors, including creating, reading, updating, and deleting author details. Author information includes name, biography, and associated books.
- **Publishers:** Perform CRUD operations on publishers, including their name, address, and associated books.
- **Categories:** Create, read, update, and delete book categories with name and description attributes.
- **Customers:** Manage customer information, including creating new customers and retrieving customer details.
- **Orders:** Handle orders placed by customers, including order creation, retrieval, and details such as order date, status, customer information, and order items containing the books purchased.
- **Order Items:** Manage order items, which represent individual books purchased within an order.

## Endpoints

- **Books:** `/books`
- **Authors:** `/authors`
- **Publishers:** `/publishers`
- **Categories:** `/categories`
- **Customers:** `/customers`
- **Orders:** `/orders`
- **Order Items:** `/orderItems`

## Api Documentation Using Postman

### Url

<https://documenter.getpostman.com/view/26016318/2sA3Bn7D3N>
