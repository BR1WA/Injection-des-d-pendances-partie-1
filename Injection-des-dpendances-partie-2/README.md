# Zouitni's Mini Dependency Injection Framework

**Author:** zouitni

## Overview

This project presents a lightweight dependency injection (DI) framework developed in Java. Inspired by the core principles of frameworks like Spring, this mini-framework aims to demonstrate and simplify the management of object dependencies within an application. It provides mechanisms for decoupling components, making the codebase more modular, testable, and maintainable.

The framework supports dependency injection through:

*   Configuration via XML files (parsed using JAX-B).
*   Configuration via Java Annotations.
*   Dynamic instantiation and injection using Java Reflection.

Key features include automatic wiring of dependencies based on configuration or annotations, reducing boilerplate code and promoting loose coupling between different layers of an application (e.g., DAO and Service layers).

## Core Components

### Data Access Object (DAO) Layer

Defines the contract for data access operations and provides a concrete implementation.

**Interface (`IZouitniDao.java`):**

```java
package net.zouitni.dao;

public interface IZouitniDao {
    String retrieveData(); // Renamed method for clarity
}
```

**Implementation (`ZouitniDaoImpl.java`):**

```java
package net.zouitni.dao;

// Assuming @Component or similar annotation might be used for annotation config
public class ZouitniDaoImpl implements IZouitniDao {

    @Override
    public String retrieveData() {
        // Simulate fetching data
        System.out.println("DAO Layer: Fetching data...");
        return "Data from source";
    }
}
```

### Service (Business Logic) Layer

Defines the contract for business logic operations and uses the DAO layer to perform its tasks.

**Interface (`IZouitniService.java`):**

```java
package net.zouitni.metier; // Changed metier to service for common terminology

public interface IZouitniService {
    void performBusinessLogic(); // Renamed method for clarity
}
```

**Implementation (`ZouitniServiceImpl.java`):**

```java
package net.zouitni.metier;

import net.zouitni.dao.IZouitniDao;
import net.zouitni.annotation.ZouitniInject; // Assuming custom Inject annotation

// Assuming @Service or similar annotation might be used
public class ZouitniServiceImpl implements IZouitniService {

    // Dependency injected via framework (constructor, setter, or field)
    @ZouitniInject // Example: Field injection annotation
    private IZouitniDao zouitniDao;

    // Constructor for potential constructor injection
    public ZouitniServiceImpl(IZouitniDao dao) {
        System.out.println("Service Layer: Constructor injection.");
        this.zouitniDao = dao;
    }

    // Default constructor needed if using field/setter injection primarily
    public ZouitniServiceImpl() {
        System.out.println("Service Layer: Initialized via default constructor.");
    }

    @Override
    public void performBusinessLogic() {
        System.out.println("Service Layer: Executing business logic...");
        String data = zouitniDao.retrieveData();
        System.out.println("Service Layer: Processing -> " + data);
    }

    // Setter for potential setter injection
    public void setZouitniDao(IZouitniDao zouitniDao) {
        System.out.println("Service Layer: Setter injection.");
        this.zouitniDao = zouitniDao;
    }
}
```

## Framework Mechanics

### Dependency Injection Techniques

The framework utilizes Java Reflection to dynamically manage object creation and dependency injection. It supports:

1.  **Constructor Injection:** Dependencies are provided through the class constructor.
2.  **Setter Injection:** Dependencies are provided through setter methods.
3.  **Field Injection:** Dependencies are injected directly into fields (often using annotations).

### Configuration

Dependencies and bean definitions can be configured in two ways:

1.  **XML Configuration (`applicationContext.xml`):** Define beans and their dependencies in an XML file. The `ZouitniXMLParser` and `ZouitniBeansConfig` classes handle parsing this file.

    ```xml
    <!-- Example applicationContext.xml -->
    <beans>
        <bean id="dao" class="net.zouitni.dao.ZouitniDaoImpl"/>
        <bean id="service" class="net.zouitni.metier.ZouitniServiceImpl">
            <!-- Example: Setter injection configuration -->
            <property name="zouitniDao" ref="dao"/>
        </bean>
    </beans>
    ```

2.  **Annotation Configuration:** Use custom annotations like `@ZouitniComponent`, `@ZouitniAutowired`, or `@ZouitniInject` (defined in `net.zouitni.annotation`) to mark classes and injection points. The `ZouitniAppConfig` class likely handles scanning and processing these annotations.

### Core Framework Classes

*   `ZouitniBeanFactory`: Responsible for creating and managing bean instances based on the configuration.
*   `ZouitniXMLParser`: Parses the `applicationContext.xml` file.
*   `ZouitniBeansConfig`: Holds the bean definitions loaded from XML.
*   `ZouitniAppConfig`: Manages configuration derived from annotations.
*   `ZouitniInject`: Custom annotation for marking injection points (example).

## Usage Example

### Using XML Configuration

```java
package net.zouitni;

import net.zouitni.config.ZouitniBeanFactory;
import net.zouitni.metier.IZouitniService;

public class ZouitniMain {
    public static void main(String[] args) {
        try {
            // Initialize context from XML
            ZouitniBeanFactory factory = new ZouitniBeanFactory("applicationContext.xml"); 
            // Get the service bean
            IZouitniService service = (IZouitniService) factory.getBean("service"); 
            // Use the service
            service.performBusinessLogic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Using Annotation Configuration

```java
package net.zouitni.annotation;

import net.zouitni.config.ZouitniAppConfig; // Assuming this class initializes context from annotations
import net.zouitni.metier.IZouitniService;

public class AnnotationMain { // Renamed from Main.java in annotation package
    public static void main(String[] args) {
        try {
            // Initialize context from Annotations (specify package to scan)
            ZouitniAppConfig appConfig = new ZouitniAppConfig("net.zouitni"); 
            // Get the service bean (assuming it's annotated correctly)
            IZouitniService service = appConfig.getBean(IZouitniService.class); 
            // Use the service
            service.performBusinessLogic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Build and Run

This project uses Maven for dependency management and building.

1.  **Prerequisites:** Ensure you have Java (JDK) and Maven installed.
2.  **Build:** Navigate to the project root directory (`zouitni_mini_project`) in your terminal and run:
    ```bash
    mvn clean package
    ```
3.  **Run:** Execute the compiled application. You might need to specify the main class depending on the packaging.
    *   To run the XML example: `java -cp target/classes net.zouitni.ZouitniMain` (adjust classpath if packaged as JAR)
    *   To run the Annotation example: `java -cp target/classes net.zouitni.annotation.AnnotationMain`

## Conclusion

This mini-framework provides a practical implementation of the Dependency Injection pattern in Java. By leveraging reflection, XML configuration, and annotations, it demonstrates how to build a flexible and decoupled application architecture. While simpler than enterprise-grade frameworks like Spring, it effectively illustrates the core concepts and benefits of DI, serving as a valuable learning tool and a foundation for understanding more complex systems.

