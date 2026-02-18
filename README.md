# E-Commerce RESTful API with PostgreSQL CRUD Operations

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue.svg)](https://www.postgresql.org/)

A RESTful API for managing e-commerce products with full CRUD operations, built with Spring Boot and PostgreSQL.

## 🚀 Features

- ✅ Full CRUD operations (Create, Read, Update, Delete)
- ✅ PostgreSQL database integration with JPA/Hibernate
- ✅ RESTful API endpoints
- ✅ Pagination support
- ✅ Search and filter functionality
- ✅ Category and brand filtering
- ✅ Price range queries
- ✅ Stock management

## 🛠️ Technologies

- **Java 21**
- **Spring Boot 4.0.2**
- **Spring Data JPA**
- **PostgreSQL**
- **Hibernate**
- **Maven**

## 📋 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products (pagination: ?page=1&limit=5) |
| GET | `/api/products/{productId}` | Get product by ID |
| GET | `/api/products/category/{category}` | Get products by category |
| GET | `/api/products/brand/{brand}` | Get products by brand |
| GET | `/api/products/search?keyword=` | Search products by name/description |
| GET | `/api/products/price-range?min=&max=` | Get products by price range |
| GET | `/api/products/in-stock` | Get in-stock products |
| POST | `/api/products` | Add new product |
| PUT | `/api/products/{productId}` | Update product |
| PATCH | `/api/products/{productId}/stock?quantity=` | Update stock quantity |
| DELETE | `/api/products/{productId}` | Delete product |

## 🎯 Sample Requests

### Get All Products
```bash
GET http://localhost:8083/api/products?page=1&limit=5
```
**Response (200 OK):**
```json
[
  {
    "productId": 1,
    "name": "iPhone 15",
    "description": "Latest Apple smartphone",
    "price": 999.99,
    "category": "Electronics",
    "stockQuantity": 50,
    "brand": "Apple"
  }
]
```

### Create Product
```bash
POST http://localhost:8083/api/products
Content-Type: application/json

{
  "name": "Product Name",
  "description": "Product Description",
  "price": 99.99,
  "category": "Electronics",
  "stockQuantity": 10,
  "brand": "Brand Name"
}
```
**Response (201 Created)**

### Update Product
```bash
PUT http://localhost:8083/api/products/1
Content-Type: application/json

{
  "name": "Updated Product",
  "description": "Updated Description",
  "price": 149.99,
  "category": "Electronics",
  "stockQuantity": 100,
  "brand": "Updated Brand"
}
```

### Delete Product
```bash
DELETE http://localhost:8083/api/products/1
```
**Response (204 No Content)**

## 🗄️ Database Setup

### 1. Install PostgreSQL
Download and install from [postgresql.org](https://www.postgresql.org/download/)

### 2. Create Database
```bash
psql -U postgres
```
Then run:
```sql
CREATE DATABASE question4_ecommerce_db;
```

### 3. Configure Application
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/question4_ecommerce_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

### 4. Database Schema
The application auto-creates the `products` table:
```sql
CREATE TABLE products (
    product_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price DOUBLE PRECISION,
    category VARCHAR(255),
    stock_quantity INTEGER,
    brand VARCHAR(255)
);
```

## 🚀 Running the Application

### Prerequisites
- Java 21 or higher
- Maven 3.6+
- PostgreSQL 13+

### Steps

1. **Clone the repository**
```bash
git clone https://github.com/angemireille/RestfulAPI_ecommerce_CRUD_25487.git
cd RestfulAPI_ecommerce_CRUD_25487
```

2. **Configure database**
Update `application.properties` with your PostgreSQL credentials

3. **Build the project**
```bash
mvn clean install
```

4. **Run the application**
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8083`

## 📁 Project Structure

```
src/main/java/auca/ac/rw/question4_library_api/
├── Controller/
│   └── ecommerce/
│       └── ProductController.java
├── Model/
│   └── ecommerce/
│       └── Product.java
├── Repository/
│   └── ecommerce/
│       └── ProductRepository.java
├── Service/
│   └── ecommerce/
│       └── ProductService.java
└── Question4LibraryApiApplication.java
```

## 🧪 Testing

Use tools like:
- **Postman** - Import the endpoints and test
- **cURL** - Command-line testing
- **Thunder Client** (VS Code extension)

## 👤 Author

**Ange Mireille**
- GitHub: [@angemireille](https://github.com/angemireille)

## 📝 License

This project is open source and available for educational purposes.

---

⭐ Star this repository if you find it helpful!