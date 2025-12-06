<h1 align="center">📦 Inventory Management System</h1>

<p align="center">
A complete web-based inventory tracking system built using <strong>Spring Boot, Thymeleaf and MySQL</strong>.
</p>

---

## 🚀 Overview

The **Inventory Management System** helps users manage and track product stock.  
Users can add, view, update, and delete products using a clean and simple UI.

This project demonstrates:

- Spring Boot MVC architecture  
- Thymeleaf UI rendering  
- CRUD operations using Spring Data JPA  
- Layered clean code structure (Controller → Service → Repository → DB)  

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Java 17+, Spring Boot |
| View Layer | Thymeleaf, HTML, Bootstrap |
| Database | MySQL |
| ORM | Spring Data JPA & Hibernate |
| Tooling | Maven, IntelliJ IDEA |

---
## 📂 Project Structure

src/main/java/com/example/inventorymanagement
│
├── controller
│ └── ProductController.java
│
├── model
│ └── Product.java
│
├── repository
│ └── ProductRepository.java
│
├── services
│ ├── ProductService.java
│ └── impl/ProductServiceImpl.java
│
└── InventoryManagementApplication.java

src/main/resources
│
├── static
│ └── styles, JS files (future use)
│
└── templates
├── index.html
├── dashboard.html
├── products.html
├── new_product.html
└── update_product.html


---

## ✨ Features

✔ Add new product  
✔ Edit existing product  
✔ Delete product  
✔ View all products  
✔ Stock count and management  
✔ User-friendly UI  

---

## ⚙️ Setup & Run

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Maheshgedela/Inventory-Management.git
cd Inventory-Management

2️⃣ Configure Database

Update your credentials inside:

📍 src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/inventory_management
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Run the application

Using Maven:

mvn spring-boot:run


or Run via IDE ▶

🌍 Access the Application

➡ Open in browser:

http://localhost:8082/



