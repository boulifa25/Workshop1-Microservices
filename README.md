# Workshop 1 – Microservices

## Microservices

### 1️ Candidat Microservice
- Port: 8082
- Database: H2
- CRUD operations

### 2️ Job Microservice
- Port: 8083 
- Database: MySQL
- Endpoints:
  - GET /jobs
  - GET /jobs/{id}
  - GET /jobs/search?service=...
  - PUT /jobs/{id}/etat

## How to run

### Candidat
mvn spring-boot:run

### Job
cd job
mvn spring-boot:run
