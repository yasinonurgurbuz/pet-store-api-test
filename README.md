# Pet Store API Test Project

This project is a test automation framework for the Pet Store API, built using Java, Cucumber, and TestNG. It follows Behavior-Driven Development (BDD) practices and includes integration with Allure for test reporting.

## Project Overview

The project contains automated tests for the Pet Store API, focusing on store-related operations such as:
- Creating store orders
- Retrieving store orders
- Deleting store orders

## Technical Stack

- Java 17
- Maven
- Cucumber 7.14.0
- TestNG 7.8.0
- Rest Assured 5.3.2
- Allure 2.19.0
- Spring Kafka 3.0.11
- Lombok 1.18.30

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com.trendyol.petstore/
│           ├── api/
│           ├── config/
│           ├── dto/
│           ├── service/
│           └── utils/
└── test/
    └── resources/
        └── features/
            └── Store.feature
```

## Building and Running Tests

To build and run the tests, use the following command:

```bash
mvn clean install
```

### Important Notes

1. The build process might occasionally fail due to service-related issues:
   - The tests depend on the Pet Store API service being available and responsive
   - Network connectivity issues might affect test execution
   - Service timeouts or maintenance periods might cause test failures

2. If you encounter build failures:
   - Verify that the Pet Store API service is running and accessible
   - Check your network connection
   - Retry the build command after a short delay

## Test Reports

After test execution, Allure reports can be generated and viewed using:

```bash
mvn allure:report
```

The reports will be available in the `target/site/allure-maven-plugin` directory.

Thanks

![yasin-hi.png](../../../Downloads/yasin-hi.png)