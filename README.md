|  Github Actions | SonarCloud | Hits | License |
|  :-------------: | :------: | :------------: | :------: |
| [![Java Service with Maven](https://github.com/govindarajanv/java-maven-quickstart-actions/actions/workflows/java-maven-api-develop.yml/badge.svg)](https://github.com/govindarajanv/java-maven-quickstart-actions/actions/workflows/java-maven-api-develop.yml) | [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=govindarajanv_java-maven-quickstart-actions&metric=alert_status)](https://sonarcloud.io/dashboard?id=govindarajanv_java-maven-quickstart-actions) | [![HitCount](http://hits.dwyl.com/govindarajanv/java-maven-quickstart-actions.svg)](http://hits.dwyl.com/govindarajanv/java-maven-quickstart-actions) | [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) |

# Java Maven Quickstart Boilerplate

A production-ready Spring Boot 3.x calculator web service with CI/CD, containerized deployment, and comprehensive testing.

## Overview

This repository provides a boilerplate for a simple calculator web service that caches computation results. It includes:

- **REST API** with HATEOAS support
- **Spring Boot** 3.x with Java 17+
- **CI/CD** with GitHub Actions (build, test, scan, deploy)
- **Docker** multi-stage builds
- **Code quality** gates (SpotBugs, PMD, Checkstyle, OWASP)
- **Security scanning** (CodeQL, Trivy, GitLeaks, OWASP Dependency Check)

## API Endpoints

The calculator supports addition, subtraction, multiplication, and division:

| Endpoint | Description |
| --- | --- |
| `/addition/{a}/{b}` | Add two numbers |
| `/addition/{a}/{b}/{c}` | Add three numbers |
| `/subtraction/{a}/{b}` | Subtract two numbers |
| `/subtraction/{a}/{b}/{c}` | Subtract three numbers |
| `/multiplication/{a}/{b}` | Multiply two numbers |
| `/multiplication/{a}/{b}/{c}` | Multiply three numbers |
| `/division/{a}/{b}` | Divide two numbers |
| `/actuator/health` | Health check endpoint |

All endpoints support `GET` and return JSON. Results are cached for identical operation+argument combinations.

### Error Handling

| Status Code | Description |
| --- | --- |
| `400` | Bad Request - invalid input or division by zero |
| `404` | Not Found - endpoint does not exist |
| `500` | Internal Server Error - unexpected server error |

## Quick Start

### Prerequisites

- Java 17 or higher
- Maven 3.8.1 or higher
- Docker (for containerized builds)

### Build and Run

```bash
# Build
mvn clean package

# Run
java -jar target/java-maven-quickstart-actions-1.0.1-SNAPSHOT.jar

# Or with Docker
docker compose up --build
```

### Run Tests

```bash
mvn test
```

### Run Code Quality Checks

```bash
mvn verify -Pcode-quality
mvn dependency-check:check
```

## Project Structure

```
src/
├── main/
│   ├── java/com/work/
│   │   ├── Application.java          # Spring Boot entry point
│   │   ├── controller/
│   │   │   ├── CalculatorController.java
│   │   │   ├── GlobalErrorController.java
│   │   │   ├── ResultResource.java
│   │   │   └── ErrorResponse.java
│   │   └── service/
│   │       ├── CalculatorService.java
│   │       └── exception/
│   │           ├── DivisionByZeroException.java
│   │           └── WrongNumberOfArgumentsException.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/work/
        ├── controller/CalculatorControllerIntegrationTest.java
        └── service/CalculatorServiceTest.java
```

## CI/CD Pipeline

The repository uses multiple GitHub Actions workflows:

| Workflow | Trigger | Purpose |
| --- | --- | --- |
| `java-maven-api-develop.yml` | `develop`, `master`, `test` | Full CI: build, test, coverage, security scans, deploy |
| `java-maven-api-feature.yml` | `feature-*` branches | Feature branch validation |
| `java-maven-api-quick-poc.yml` | Non-protected branches | Quick Docker image build and push |
| `codeql-analysis.yml` | `develop`, `master` | CodeQL static analysis |

### Maven Build Optimization

The CI pipeline uses a **build-once, share-artifacts** pattern:
1. A single `build` job compiles and packages the application, uploading the artifact
2. Downstream jobs (`unit-test`, `coverage`, `contract-test`, `sonar`) download the artifact instead of recompiling
3. Jobs that only need source code (`secret-scan`, `dependency-scan`) skip Maven entirely

## Links

- [SonarCloud Dashboard](https://sonarcloud.io/dashboard?id=govindarajanv_java-maven-quickstart-actions)
- [DockerHub](https://hub.docker.com/repository/docker/govindarajanv/java-maven-quickstart-service)
- [CodeCov](https://app.codecov.io/gh/govindarajanv/java-maven-quickstart-actions)
- [Dependabot](https://github.com/govindarajanv/java-maven-quickstart-actions/network/dependencies)
