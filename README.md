# Bookstore Inventory System Documentation

The Bookstore API is a RESTful web service designed to manage books, authors, publishers, categories, customers, orders, and order items for an online bookstore platform. This API provides endpoints for various CRUD (Create, Read, Update, Delete) operations to handle the bookstore's functionalities.

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
