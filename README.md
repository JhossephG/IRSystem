# IRSystem

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


#Figma link w/ workflow and etc
https://www.figma.com/board/f2Y97vUhj2KYLVTs059Fxr/Untitled?node-id=921-517&t=a1ghsiciH1sNn11u-0

### IRSystem Project Summary

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
│   │   │   │   └── src
│   │   │   │       └── main
│   │   │   │           └── java
│   │   │   │               └── com
│   │   │   │                   └── jhogo
│   │   │   │                       └── irsystem
│   │   │   │                           ├── cars
│   │   │   │                           │   ├── Car.class
│   │   │   │                           │   ├── CarDAO.class
│   │   │   │                           │   ├── CarDTO.class
│   │   │   │                           │   └── CarService.class
│   │   │   │                           ├── employees
│   │   │   │                           │   ├── Employees.class
│   │   │   │                           │   ├── EmployeesDAO.class
│   │   │   │                           │   ├── EmployeesDTO.class
│   │   │   │                           │   └── EmployeesService.class
│   │   │   │                           ├── spending
│   │   │   │                           │   └── Spending.class
│   │   │   │                           └── store
│   │   │   │                               └── Store.class
│   │   │   └── test
│   │   │       └── src
│   │   │           └── test
│   │   │               └── java
│   │   │                   └── com
│   │   │                       └── jhogo
│   │   │                           └── irsystem
│   │   │                               ├── CarDAOIntegrationTest.class
│   │   │                               └── CarServiceTest.class
│   │   └── kotlin
│   │       ├── main
│   │       │   ├── com
│   │       │   │   └── jhogo
│   │       │   │       └── irsystem
│   │       │   │           ├── Application.class
│   │       │   │           └── ApplicationKt.class
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
│   │   │   │   │   │       ├── internal-name-to-source.tab
│   │   │   │   │   │       ├── internal-name-to-source.tab_i
│   │   │   │   │   │       ├── internal-name-to-source.tab_i.len
│   │   │   │   │   │       ├── internal-name-to-source.tab.keystream
│   │   │   │   │   │       ├── internal-name-to-source.tab.keystream.len
│   │   │   │   │   │       ├── internal-name-to-source.tab.len
│   │   │   │   │   │       ├── internal-name-to-source.tab.values.at
│   │   │   │   │   │       ├── package-parts.tab
│   │   │   │   │   │       ├── package-parts.tab_i
│   │   │   │   │   │       ├── package-parts.tab_i.len
│   │   │   │   │   │       ├── package-parts.tab.keystream
│   │   │   │   │   │       ├── package-parts.tab.keystream.len
│   │   │   │   │   │       ├── package-parts.tab.len
│   │   │   │   │   │       ├── package-parts.tab.values.at
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
│   │   │   │   │   │       └── source-to-classes.tab.values.at
│   │   │   │   │   └── lookups
│   │   │   │   │       ├── counters.tab
│   │   │   │   │       ├── file-to-id.tab
│   │   │   │   │       ├── file-to-id.tab_i
│   │   │   │   │       ├── file-to-id.tab_i.len
│   │   │   │   │       ├── file-to-id.tab.keystream
│   │   │   │   │       ├── file-to-id.tab.keystream.len
│   │   │   │   │       ├── file-to-id.tab.len
│   │   │   │   │       ├── file-to-id.tab.values.at
│   │   │   │   │       ├── id-to-file.tab
│   │   │   │   │       ├── id-to-file.tab.keystream
│   │   │   │   │       ├── id-to-file.tab.keystream.len
│   │   │   │   │       ├── id-to-file.tab.len
│   │   │   │   │       ├── id-to-file.tab.values.at
│   │   │   │   │       ├── lookups.tab
│   │   │   │   │       ├── lookups.tab_i
│   │   │   │   │       ├── lookups.tab_i.len
│   │   │   │   │       ├── lookups.tab.keystream
│   │   │   │   │       ├── lookups.tab.keystream.len
│   │   │   │   │       ├── lookups.tab.len
│   │   │   │   │       └── lookups.tab.values.at
│   │   │   │   └── last-build.bin
│   │   │   └── localstate
│   │   │       └── build-history.bin
│   │   ├── compileTestKotlin
│   │   │   └── cacheable
│   │   ├── IRSystem001SNAPSHOTplainjar-classes.txt
│   │   └── sessions
│   ├── libs
│   │   ├── IRSystem-0.0.1-SNAPSHOT.jar
│   │   └── IRSystem-0.0.1-SNAPSHOT-plain.jar
│   ├── reports
│   │   └── tests
│   │       └── test
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           └── js
│   │               └── report.js
│   ├── resources
│   │   └── main
│   │       ├── application.yml
│   │       └── db
│   │           └── migration
│   │               ├── V1__Initial_schema.sql
│   │               └── V2__Add_new_employee_fields.sql
│   ├── scripts
│   │   ├── IRSystem
│   │   └── IRSystem.bat
│   ├── test-results
│   │   └── test
│   │       └── binary
│   │           ├── output.bin
│   │           ├── output.bin.idx
│   │           └── results.bin
│   └── tmp
│       ├── bootJar
│       │   └── MANIFEST.MF
│       ├── compileJava
│       │   └── previous-compilation-data.bin
│       ├── compileTestJava
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
├── Menu.java
├── README.md
├── settings.gradle.kts
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── jhogo
    │   │           └── irsystem
    │   │               ├── cars
    │   │               │   ├── CarDAO.java
    │   │               │   ├── CarDTO.java
    │   │               │   ├── Car.java
    │   │               │   ├── CarManager.java
    │   │               │   └── CarService.java
    │   │               ├── employees
    │   │               │   ├── EmployeesDAO.java
    │   │               │   ├── EmployeesDTO.java
    │   │               │   ├── Employees.java
    │   │               │   └── EmployeesService.java
    │   │               ├── spending
    │   │               │   └── Spending.java
    │   │               ├── store
    │   │               │   └── Store.java
    │   │               └── users
    │   │                   ├── UserDAO.java
    │   │                   ├── UserDTO.java
    │   │                   ├── User.java
    │   │                   └── UserService.java
    │   ├── kotlin
    │   │   └── com
    │   │       └── jhogo
    │   │           └── irsystem
    │   │               └── Application.kt
    │   └── resources
    │       ├── application.yml
    │       └── db
    │           └── migration
    │               ├── V1__Initial_schema.sql
    │               └── V2__Add_new_employee_fields.sql
    └── test
        └── java
            └── com
                └── jhogo
                    └── irsystem
                        ├── CarDAOIntegrationTest.java
                        └── CarServiceTest.java

97 directories, 144 files
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
4. **Common Parent Class**: Use an abstract class `Person` for shared fields and methods between `Employee` and `User`.