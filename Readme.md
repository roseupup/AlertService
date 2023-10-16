# Alert Service API Documentation

The Alert Service provides two main endpoints to interact with the alert system. This document outlines the details and usage of these endpoints.

## Project Details
- **Group ID**: `com.alert-service`
- **Artifact ID**: `demo`
- **Version**: `0.0.1-SNAPSHOT`
- **Name**: `demo`
- **Description**: `Alert project for Spring Boot`
- **Java Version**: `Java 17`

## Parent Dependency
- **Group ID**: `org.springframework.boot`
- **Artifact ID**: `spring-boot-starter-parent`
- **Version**: `2.7.16`

## Table of Contents

- [API Endpoints](#api-endpoints)
  - [Add Alert](#add-alert)
  - [Get Alerts](#get-alerts)
- [Running the Service Locally](#running-the-service-locally)

## API Endpoints

### Add Alert

- **Endpoint**: `/alerts`
- **HTTP Method**: `POST`
- **Description**: This endpoint allows you to add a new alert to the system.

#### Request Payload

```json
{
    "alertId": "string",
    "serviceId": "string",
    "serviceName": "string",
    "model": "string",
    "alertType": "string",
    "severity": "string",
    "teamSlack": "string",
    "alertTs": "string"
}
```

#### Response

On successful insertion:

```json
{
    "alert_id": "string",
    "error": ""
}
```

### Get Alerts

- **Endpoint**: `/alerts`
- **HTTP Method**: `GET`
- **Description**: Retrieve alerts based on service ID and a timestamp range.

#### Query Parameters

- `service_id`: ID of the service.
- `start_ts`: Start timestamp (UNIX format).
- `end_ts`: End timestamp (UNIX format).

#### Response

On successful retrieval:

```json
{
    "service_id": "string",
    "alerts": [
        {
            "alert_id": "string",
            ... (other alert fields)
        },
        ... (other alerts)
    ]
}
```

On no alerts found:

```json
{
    "success": false,
    "error": "No alerts found"
}
```

## Running the Service Locally

### 1. Ensure you have all dependencies installed.
### 2. Run the main application class to start the service.
1. Application Properties
```json
spring.jpa.show-sql=true
spring.datasource.url=jdbc:mysql://localhost:3306/alert-service-database
spring.datasource.username=alert-service
spring.datasource.password=dummypassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialec=org.hibernate.dialect.MySQLDialect
```
2. This Project deployed MySql on local Docker Eviroment, command line to create the database:
```bash
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=alert-service --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=alert-service-database --name mysql --publish 3306:3306 mysql:8-oracle
```
Hibernate and JPA would create 
### 3. Once running, the service will be available at `http://localhost:8080`.


