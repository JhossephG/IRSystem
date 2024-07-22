# IRSystem

## The Project

This project is an Internal Registration System designed initially to register any kind of product for any type of store. The system provides functionalities for the system admin or store owner to view comprehensive details of the store, such as:

- All the details of products currently and previously in the store.
- Managing the store balance.
- Managing all interested clients.
- Managing employee data and information.
- Setting and tracking expenses.
- And many other functions.

Technologies Used:

- `Backend`: Java 
- `API`: Spring Boot, JPA Repository and RESTful services
- `Database`: MySQL
- `Frontend`: React
- `Cloud Application/deploy`: AWS
- `Version Control`: Git and GitHub
- `Build and Configuration Management`: Gradle

## License

This project are licensed under the [GNU GPL v3.0](LICENSE.txt).

## Copyright

© Jhosseph Pathryck de Souza Gonzalez. All rights reserved.

## Figma link w/ workflow and etc
https://www.figma.com/board/f2Y97vUhj2KYLVTs059Fxr/Untitled?node-id=921-517&t=a1ghsiciH1sNn11u-0

## Environment Variables

The following environment variables need to be set for the application to run properly:

- `DATABASE_URL`: The JDBC URL of the database.
- `DATABASE_USERNAME`: The database username.
- `DATABASE_PASSWORD`: The database password.

Example:

```sh
export DATABASE_URL="jdbc:mysql://localhost:3306/car_store"
export DATABASE_USERNAME="root"
export DATABASE_PASSWORD="your_secure_password"

```

#### Project Structure
```
IRSystem$
├── build
│   ├── bootJarMainClassName
│   ├── bootRunMainClassName
│   ├── bootScripts
│   │   ├── IRSystem
│   │   └── IRSystem.bat
│   ├── classes
│   │   ├── java
│   │   │   ├── main
│   │   │   │   └── com
│   │   │   │       └── jhogo
│   │   │   │           └── irsystem
│   │   │   │               ├── Application.class
│   │   │   │               ├── common
│   │   │   │               │   └── Person.class
│   │   │   │               ├── config
│   │   │   │               │   └── DataSourceConfig.class
│   │   │   │               ├── controller
│   │   │   │               │   ├── EmployeeController.class
│   │   │   │               │   ├── FinanceController.class
│   │   │   │               │   ├── StoreController.class
│   │   │   │               │   ├── UserController.class
│   │   │   │               │   └── VehicleController.class
│   │   │   │               ├── dto
│   │   │   │               │   ├── EmployeeDTO.class
│   │   │   │               │   ├── FinanceDTO.class
│   │   │   │               │   ├── StoreDTO.class
│   │   │   │               │   ├── UserDTO.class
│   │   │   │               │   └── VehicleDTO.class
│   │   │   │               ├── model
│   │   │   │               │   ├── Employee.class
│   │   │   │               │   ├── Finance.class
│   │   │   │               │   ├── Store.class
│   │   │   │               │   ├── User.class
│   │   │   │               │   └── Vehicle.class
│   │   │   │               ├── repository
│   │   │   │               │   ├── EmployeeDAO.class
│   │   │   │               │   ├── FinanceDAO.class
│   │   │   │               │   ├── StoreDAO.class
│   │   │   │               │   ├── UserDAO.class
│   │   │   │               │   └── VehicleDAO.class
│   │   │   │               └── service
│   │   │   │                   ├── EmployeeService.class
│   │   │   │                   ├── FinanceService.class
│   │   │   │                   ├── StoreService.class
│   │   │   │                   ├── UserService.class
│   │   │   │                   └── VehicleService.class
│   │   │   └── test
│   │   │       └── com
│   │   │           └── jhogo
│   │   │               └── irsystem
│   │   │                   ├── store
│   │   │                   │   └── StoreServiceTest.class
│   │   │                   └── vehicle
│   │   │                       ├── VehicleDAOIntegrationTest.class
│   │   │                       └── VehicleServiceTest.class
│   │   └── kotlin
│   │       ├── main
│   │       │   └── META-INF
│   │       │       └── IRSystem.kotlin_module
│   │       └── test
│   ├── distributions
│   │   ├── IRSystem-0.0.1-SNAPSHOT.tar
│   │   ├── IRSystem-0.0.1-SNAPSHOT.zip
│   │   ├── IRSystem-boot-0.0.1-SNAPSHOT.tar
│   │   └── IRSystem-boot-0.0.1-SNAPSHOT.zip
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       ├── main
│   │       │       └── test
│   │       └── headers
│   │           └── java
│   │               ├── main
│   │               └── test
│   ├── kotlin
│   │   ├── compileKotlin
│   │   │   ├── cacheable
│   │   │   │   ├── caches-jvm
│   │   │   │   │   ├── inputs
│   │   │   │   │   │   ├── source-to-output.tab
│   │   │   │   │   │   ├── source-to-output.tab_i
│   │   │   │   │   │   ├── source-to-output.tab_i.len
│   │   │   │   │   │   ├── source-to-output.tab.keystream
│   │   │   │   │   │   ├── source-to-output.tab.keystream.len
│   │   │   │   │   │   ├── source-to-output.tab.len
│   │   │   │   │   │   └── source-to-output.tab.values.at
│   │   │   │   │   ├── jvm
│   │   │   │   │   │   └── kotlin
│   │   │   │   │   │       ├── class-attributes.tab
│   │   │   │   │   │       ├── class-attributes.tab_i
│   │   │   │   │   │       ├── class-attributes.tab_i.len
│   │   │   │   │   │       ├── class-attributes.tab.keystream
│   │   │   │   │   │       ├── class-attributes.tab.keystream.len
│   │   │   │   │   │       ├── class-attributes.tab.len
│   │   │   │   │   │       ├── class-attributes.tab.values.at
│   │   │   │   │   │       ├── class-fq-name-to-source.tab
│   │   │   │   │   │       ├── class-fq-name-to-source.tab_i
│   │   │   │   │   │       ├── class-fq-name-to-source.tab_i.len
│   │   │   │   │   │       ├── class-fq-name-to-source.tab.keystream
│   │   │   │   │   │       ├── class-fq-name-to-source.tab.keystream.len
│   │   │   │   │   │       ├── class-fq-name-to-source.tab.len
│   │   │   │   │   │       ├── class-fq-name-to-source.tab.values.at
│   │   │   │   │   │       ├── java-sources-proto-map.tab
│   │   │   │   │   │       ├── java-sources-proto-map.tab_i
│   │   │   │   │   │       ├── java-sources-proto-map.tab_i.len
│   │   │   │   │   │       ├── java-sources-proto-map.tab.keystream
│   │   │   │   │   │       ├── java-sources-proto-map.tab.keystream.len
│   │   │   │   │   │       ├── java-sources-proto-map.tab.len
│   │   │   │   │   │       ├── java-sources-proto-map.tab.values.at
│   │   │   │   │   │       ├── proto.tab
│   │   │   │   │   │       ├── proto.tab_i
│   │   │   │   │   │       ├── proto.tab_i.len
│   │   │   │   │   │       ├── proto.tab.keystream
│   │   │   │   │   │       ├── proto.tab.keystream.len
│   │   │   │   │   │       ├── proto.tab.len
│   │   │   │   │   │       ├── proto.tab.values.at
│   │   │   │   │   │       ├── source-to-classes.tab
│   │   │   │   │   │       ├── source-to-classes.tab_i
│   │   │   │   │   │       ├── source-to-classes.tab_i.len
│   │   │   │   │   │       ├── source-to-classes.tab.keystream
│   │   │   │   │   │       ├── source-to-classes.tab.keystream.len
│   │   │   │   │   │       ├── source-to-classes.tab.len
│   │   │   │   │   │       ├── source-to-classes.tab.values.at
│   │   │   │   │   │       ├── subtypes.tab
│   │   │   │   │   │       ├── subtypes.tab_i
│   │   │   │   │   │       ├── subtypes.tab_i.len
│   │   │   │   │   │       ├── subtypes.tab.keystream
│   │   │   │   │   │       ├── subtypes.tab.keystream.len
│   │   │   │   │   │       ├── subtypes.tab.len
│   │   │   │   │   │       ├── subtypes.tab.values.at
│   │   │   │   │   │       ├── supertypes.tab
│   │   │   │   │   │       ├── supertypes.tab_i
│   │   │   │   │   │       ├── supertypes.tab_i.len
│   │   │   │   │   │       ├── supertypes.tab.keystream
│   │   │   │   │   │       ├── supertypes.tab.keystream.len
│   │   │   │   │   │       ├── supertypes.tab.len
│   │   │   │   │   │       └── supertypes.tab.values.at
│   │   │   │   │   └── lookups
│   │   │   │   └── last-build.bin
│   │   │   └── localstate
│   │   │       └── build-history.bin
│   │   ├── compileTestKotlin
│   │   │   ├── cacheable
│   │   │   │   ├── caches-jvm
│   │   │   │   │   ├── inputs
│   │   │   │   │   ├── jvm
│   │   │   │   │   └── lookups
│   │   │   │   └── last-build.bin
│   │   │   └── localstate
│   │   │       └── build-history.bin
│   │   ├── IRSystem001SNAPSHOTplainjar-classes.txt
│   │   └── sessions
│   ├── libs
│   │   ├── IRSystem-0.0.1-SNAPSHOT.jar
│   │   └── IRSystem-0.0.1-SNAPSHOT-plain.jar
│   ├── reports
│   │   └── tests
│   │       └── test
│   │           ├── classes
│   │           │   └── com.jhogo.irsystem.store.StoreServiceTest.html
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           ├── js
│   │           │   └── report.js
│   │           └── packages
│   │               └── com.jhogo.irsystem.store.html
│   ├── resources
│   │   ├── main
│   │   │   ├── application.yml
│   │   │   └── db
│   │   │       └── migration
│   │   │           ├── V1__Initial_schema.sql
│   │   │           ├── V2__Add_new_employee_fields.sql
│   │   │           ├── V3__Update_schema_with_relationship_fields.sql
│   │   │           ├── V4__Update_schema_with_user_table.sql
│   │   │           ├── V5__Update_schema_with_wage_to_employee.sql
│   │   │           └── V6__Create_finance_table.sql
│   │   └── test
│   │       └── application-test.properties
│   ├── scripts
│   │   ├── IRSystem
│   │   └── IRSystem.bat
│   ├── snapshot
│   │   └── kotlin
│   ├── test-results
│   │   └── test
│   │       ├── binary
│   │       │   ├── output.bin
│   │       │   ├── output.bin.idx
│   │       │   └── results.bin
│   │       └── TEST-com.jhogo.irsystem.store.StoreServiceTest.xml
│   └── tmp
│       ├── bootJar
│       │   └── MANIFEST.MF
│       ├── compileJava
│       │   ├── compileTransaction
│       │   │   ├── backup-dir
│       │   │   └── stash-dir
│       │   │       ├── DataSourceConfig.class.uniqueId12
│       │   │       ├── EmployeeController.class.uniqueId11
│       │   │       ├── EmployeeDAO.class.uniqueId10
│       │   │       ├── EmployeeService.class.uniqueId4
│       │   │       ├── FinanceController.class.uniqueId7
│       │   │       ├── FinanceDTO.class.uniqueId3
│       │   │       ├── StoreController.class.uniqueId6
│       │   │       ├── StoreService.class.uniqueId2
│       │   │       ├── UserController.class.uniqueId5
│       │   │       ├── UserDAO.class.uniqueId0
│       │   │       ├── UserService.class.uniqueId9
│       │   │       ├── VehicleController.class.uniqueId1
│       │   │       ├── VehicleDAO.class.uniqueId13
│       │   │       └── VehicleService.class.uniqueId8
│       │   └── previous-compilation-data.bin
│       ├── compileTestJava
│       │   ├── compileTransaction
│       │   │   ├── backup-dir
│       │   │   └── stash-dir
│       │   └── previous-compilation-data.bin
│       ├── jar
│       │   └── MANIFEST.MF
│       └── test
├── build.gradle.kts
├── car_store_schema.sql
├── gradle
│   ├── libs.versions.toml
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── LICENSE.txt
├── Menu.java
├── README.md
├── settings.gradle.kts
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── jhogo
    │   │           └── irsystem
    │   │               ├── Application.java
    │   │               ├── common
    │   │               │   ├── Person.java
    │   │               │   └── vehicle
    │   │               │       ├── bike
    │   │               │       ├── car
    │   │               │       └── CarManager.java
    │   │               ├── config
    │   │               │   └── DataSourceConfig.java
    │   │               ├── controller
    │   │               │   ├── EmployeeController.java
    │   │               │   ├── FinanceController.java
    │   │               │   ├── StoreController.java
    │   │               │   ├── UserController.java
    │   │               │   └── VehicleController.java
    │   │               ├── dto
    │   │               │   ├── EmployeeDTO.java
    │   │               │   ├── FinanceDTO.java
    │   │               │   ├── StoreDTO.java
    │   │               │   ├── UserDTO.java
    │   │               │   └── VehicleDTO.java
    │   │               ├── model
    │   │               │   ├── Employee.java
    │   │               │   ├── Finance.java
    │   │               │   ├── Store.java
    │   │               │   ├── User.java
    │   │               │   └── Vehicle.java
    │   │               ├── repository
    │   │               │   ├── EmployeeDAO.java
    │   │               │   ├── FinanceDAO.java
    │   │               │   ├── StoreDAO.java
    │   │               │   ├── UserDAO.java
    │   │               │   └── VehicleDAO.java
    │   │               ├── service
    │   │               │   ├── EmployeeService.java
    │   │               │   ├── FinanceService.java
    │   │               │   ├── StoreService.java
    │   │               │   ├── UserService.java
    │   │               │   └── VehicleService.java
    │   │               └── util
    │   ├── kotlin
    │   │   └── com
    │   │       └── jhogo
    │   │           └── irsystem
    │   │               └── Application2.kt
    │   └── resources
    │       ├── application.yml
    │       └── db
    │           └── migration
    │               ├── V1__Initial_schema.sql
    │               ├── V2__Add_new_employee_fields.sql
    │               ├── V3__Update_schema_with_relationship_fields.sql
    │               ├── V4__Update_schema_with_user_table.sql
    │               ├── V5__Update_schema_with_wage_to_employee.sql
    │               └── V6__Create_finance_table.sql
    └── test
        ├── java
        │   └── com
        │       └── jhogo
        │           └── irsystem
        │               ├── CarDAOIntegrationTest.java
        │               ├── CarServiceTest.java
        │               ├── employee
        │               ├── finance
        │               ├── store
        │               │   └── StoreServiceTest.java
        │               ├── user
        │               └── vehicle
        │                   ├── VehicleDAOIntegrationTest.java
        │                   └── VehicleServiceTest.java
        └── resources
            └── application-test.properties

121 directories, 195 files
```

#### Build Script (`build.gradle.kts`)
```kotlin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("org.springframework.boot") version "2.6.6" 
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21" 
    kotlin("plugin.spring") version "1.6.21" 
    id("org.flywaydb.flyway") version "8.5.11" 
}

group = "com.jhogo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-core")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

application {
    mainClass.set("com.jhogo.irsystem.ApplicationKt")
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src/main/java"))
        }
    }
    test {
        java {
            setSrcDirs(listOf("src/test/java"))
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

flyway {
    url = System.getenv("DATABASE_URL") ?: "jdbc:mysql://localhost:3306/car_store"
    user = System.getenv("DATABASE_USERNAME") ?: "root"
    password = System.getenv("DATABASE_PASSWORD") ?: "password"
}
```

#### Settings Script (`settings.gradle.kts`)
```kotlin
/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.7/userguide/multi_project_builds.html in the Gradle documentation.
 */

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "IRSystem"
include("app")
```

#### Database Schema Migration Scripts
**V1__Initial_schema.sql**
```sql
CREATE TABLE Store (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    address VARCHAR(255)
);

CREATE TABLE Car (
    id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(100),
    brand VARCHAR(100),
    chassis VARCHAR(100),
    manufactureYear INT,
    saleValue DECIMAL(10, 2),
    purchaseValue DECIMAL(10, 2),
    inStore BOOLEAN,
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(id)
);

CREATE TABLE Client (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    contact VARCHAR(100),
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(id)
);

CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    role VARCHAR(50),
    address VARCHAR(200),
    username VARCHAR(100),
    password VARCHAR(100),
    birthday DATE,
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(id)
);
```

### Summary of Important Points

1. **Project Structure**: Ensure the directory structure is correct and follows conventions.
2. **Build Script**: Properly configure `build.gradle.kts` and `settings.gradle.kts` for Gradle with Kotlin DSL.
3. **Flyway Configuration**: Use environment variables to manage sensitive data such as database URLs and credentials.