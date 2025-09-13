👤 User Management System (Spring Boot + JWT Security)

A simple user management backend built with Spring Boot, demonstrating JWT authentication, role-based access, and secure API endpoints.

📂 Project Structure
java/com/example/jetexpert
│
├── api/                # REST controllers (user endpoints)
├── dto/                # Data Transfer Objects (request/response payloads)
├── persistence/        # Entities, repositories (JPA/Hibernate)
├── security/           # Security configuration & JWT logic
│   ├── CurrentUser.java
│   ├── JWTAuthenticationTokenFilter.java
│   ├── JwtAuthenticationEntryPoint.java
│   ├── JwtTokenUtil.java
│   ├── UserDetailsService.java
│   ├── WebSecurityConfig.java
│
└── DemoApplication.java # Spring Boot entry point

✨ Features

🔑 Authentication & Authorization

Login with username/password

Issue and validate JWT tokens

Stateless session management

👥 User Management

Register new users

Role-based access (e.g., ADMIN / USER)

Fetch current logged-in user via CurrentUser

🔐 Security

Configured with WebSecurityConfig

Unauthorized access handled by JwtAuthenticationEntryPoint

Custom JWTAuthenticationTokenFilter to secure endpoints

🛠️ Tech Stack

Backend: Spring Boot (REST + Security)

Security: Spring Security + JWT

Database: JPA / Hibernate (H2, MySQL, or PostgreSQL)

Build Tool: Maven or Gradle

🚀 Getting Started
1. Clone the repository
git clone https://github.com/<your-username>/user-management-jwt.git
cd user-management-jwt

2. Configure database

Update application.properties (or application.yml) with your DB credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3. Run the application
mvn spring-boot:run


App will start on: http://localhost:8080

📊 API Endpoints (Example)
Method	Endpoint	Description	Auth Required
POST	/api/auth/login	Authenticate & return JWT	❌
POST	/api/auth/register	Register a new user	❌
GET	/api/users/me	Get current user details	✅ JWT
GET	/api/users/all	List all users (admin only)	✅ JWT (ADMIN)
🔒 JWT Workflow
sequenceDiagram
    User ->> API: POST /login (username, password)
    API ->> JwtTokenUtil: Validate credentials
    JwtTokenUtil ->> User: Return JWT token
    User ->> API: GET /users/me (Authorization: Bearer <token>)
    API ->> JWTAuthenticationTokenFilter: Validate token
    API ->> User: Return user info

📜 License

This project is licensed under the MIT License – see LICENSE
 for details.
