================================================================================
                               DigiElect - Secure Online Voting System
================================================================================

                      Developed by Phoenix Coders Team

- JAGAN SUNKAVALLI             [2420030714]
- REDDAM SRIJITHA              [2420030741]
- CHEYATI HEMAVATHI           [2420030745]
- KISTAMMAGARI PRANATHI REDDY [2420030751]

--------------------------------------------------------------------------------
                             PROJECT OVERVIEW

DigiElect is a secure and scalable online voting platform developed using Java 17+ and Spring Boot 3.x.
This project showcases Object-Oriented Programming principles:
encapsulation, inheritance, polymorphism, abstraction, plus SOLID design principles and common
design patterns like Factory and Strategy.

Key highlights:
- Secure one-person-one-vote mechanism
- Role-based access: VOTER, ADMIN
- Concurrency-safe vote submission
- Real-time vote tallying and analytics using Java Streams
- Serialization utilities for election state persistence
- Robust JUnit 5 test coverage for core logic

----------------------------------------------------------------------------------
                            TECHNOLOGY STACK

Backend:
- Java 17+
- Spring Boot 3.x (Spring MVC, Spring Security, Spring Data JPA)
- Hibernate ORM
- H2 in-memory DB or MySQL (optional)
- Maven for build and dependencies
- Lombok for boilerplate reduction

Frontend (Basic):
- Thymeleaf templates + Bootstrap 5 (Minimal focus on frontend)

-----------------------------------------------------------------------------------
                         PROJECT STRUCTURE (BACKEND FOCUS)

com.digielect/
├── config/               : Security & application configs
├── controller/           : MVC Controllers - User, Vote, Admin
├── entity/               : JPA Entities - User, Candidate, Vote, Constituency
├── repository/           : Spring Data JPA Repositories
├── service/              : Business logic interfaces and implementations
├── strategy/             : Vote counting strategy pattern implementations
├── factory/              : Factories for constituency and election creation
├── utils/                : Serialization and utilities
└── DigiElectApplication.java : Main Spring Boot entry point

-----------------------------------------------------------------------------------
                                UML CLASS DIAGRAM

+----------------------+          +----------------------+
|        User          |          |      Candidate        |
+----------------------+          +----------------------+
| - id: Long           |          | - id: Long            |
| - name: String       |          | - name: String        |
| - email: String      |          | - party: String       |
| - password: String   |          | - votes: List<Vote>   |
| - role: String       |          +----------------------+
| - hasVoted: boolean  |                  ^
+----------------------+                  |
          |                              *|
          |                               |
          |                               |
          v                               v
+----------------------+          +----------------------+
|        Vote          |----------|     Constituency      |
+----------------------+          +----------------------+
| - id: Long           |          | - id: Long            |
| - user: User         |          | - name: String        |
| - candidate: Candidate|         | - candidates: List    |
| - timestamp: Date    |          +----------------------+
+----------------------+

-----------------------------------------------------------------------------------
                              SECURITY ARCHITECTURE

- Role-based Authentication & Authorization using Spring Security
- Password hashing with BCryptPasswordEncoder
- Session-based authentication with CSRF protection and role guards
- Atomic, transactional vote submission prevents double voting

-----------------------------------------------------------------------------------
                                FEATURES

Voter:
- Register and login (unique phone/email identifier)
- View list of candidates by constituency
- Securely cast a single vote per election

Admin:
- Manage election lifecycle & constituencies
- View real-time vote counts and detailed breakdowns
- Monitor election status and security health

-----------------------------------------------------------------------------------
                              HOW TO RUN

Prerequisites:
- Java 17+
- Maven 3.x
- Optional: MySQL (or use default embedded H2 DB)

Commands:
  git clone https://github.com/Jagan-Dev-9/OOPA_Project.git
  cd OOPA_Project/VotingApp
  ./mvnw clean install
  ./mvnw spring-boot:run

Visit: http://localhost:8080

-----------------------------------------------------------------------------------
                                TESTING

- JUnit 5 test cases cover:
    - User registration and login
    - Vote submission and concurrency
    - Vote tallying strategies
- Targeted test coverage: >80% for backend logic

-----------------------------------------------------------------------------------
                          FUTURE ENHANCEMENTS

- Support multi-election scheduling
- Two-factor authentication (MFA) for higher security
- Real-time WebSocket updates on results
- Exportable reports (PDF, CSV)
- Distributed database and caching for scalability

-----------------------------------------------------------------------------------
                           CONTACT & REPOSITORY

Phoenix Coders  
GitHub: https://github.com/Jagan-Dev-9/OOPA_Project

-----------------------------------------------------------------------------------
                                   NOTES

- This project prioritizes backend Java OOP principles and clean architecture.
- Frontend is minimal but functional for demonstrations.
- Designed for academic and hackathon showcases focusing on secure digital democracy.

================================================================================
