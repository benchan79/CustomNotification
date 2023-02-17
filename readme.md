# Java Lesson

## How to run the project

On your Terminal,

Step 1: `cd` to the `notification_app` folder

Step 2: Run `mvn clean package` 

If you do not have mvn yet, run `sdk install maven`

Step 3: Open the `App.java` file loated in `notification_app/src/main/java/sg/edu/ntu/App.java` 

Step 4: Right-click anywhere on the code and select "Run Java"

> If you do not want to see those ugly read lines falsely highlighting errors on you VS Code, you are to launch a new instance of VS Code opening the folder `notification_app`. This is a good practice for coding java application. Your IDE should always open the root directory of your project. 

## Lesson Coverage (17 Feb 23, Fri)

- Spawn a new thread with `CompletableFuture`
- Use a `Queue` to store `CustomNotification` objects in a `NotificationQueue` class
- Implement `ExecutorService` on `App.js` to clear the objects stored in `Queue`

If learners are continuing from their old repository, go to [pom.xml](./notification_app/pom.xml) to change the following:

```xml
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source> <!-- Change the value from 1.7 to 17 -->
    <maven.compiler.target>1.7</maven.compiler.target> <!-- Change the value from 1.7 to 17 -->
  </properties>
```

This tells maven to compile the class to Java 17 runtime, so that we can use `lambda expression` which a new feature from Java 8

## Lesson Coverage (13 Feb 23, Mon)

- try-catch-finally
- Custom Exception
- Good practice to log exceptions

Optional: CompletableFuture (1st part of next lesson)

## Lesson Coverage (10 Feb 23, Fri)

- Abstraction 
- Polymorphism

### Overview

Polymorphism - The ability to take on more than one form. (using `interface`)
Abstraction - Hide unnecessary details so that the consumer only interface with the necessities. (using `abstract class`)

Interface is used to pre-determine the shape of multiple unrelated classes.
Abstract class is used to enforce the shape of closely related classes.

When you use interface, you think about `universal capability` and `type`.
    
- Universal Capability Examples
    - Drivable? Connectable? Payable?
- Type example
    - The types of `Drivable` car: `SportsCar`, `FamilyCar`, etcs.

When you use abstract class, you think about `inheritance`.
- All children class must have __________

In this lesson, we will:
- Convert CustomNotification.java to an abstract class
- Create a Connectable.java as an interface

---

## Lesson Coverage (6 Feb 23, Mon)

- Inheritance
- Encapsulation

### Overview

OOP is Object-oriented Programming and is a set of principles. The actual practices of OOP takes on different form in different programming languages but they are 80% similar. Therefore, remember the concepts, and google/reference for the implementation.

In this lesson, we will:
- Create `SMSNotification` and `EmailNotification` child classes instead of using `Channel type` enum.
- Override the `send()` behaviour
- Provide additional properties `cc` and `bcc` to the `EmailNotification` class.
- We will also observe `encapsulation` in the same piece of code.

---

## Lesson Coverage (4 Feb 23, Sat)

- method with arguments/parameters
- method with return values
- method overloading
- class and new keyword
- private properties and accessor methods
- constructor with default values
- static and non-static

### Quotes

> A static method is a class method and belongs to the class itself. This means you do not need an instance in order to use a static method. A non-static method is an instance method and belongs to each object that is generated from the class. - Excerpt from [LinkedIn](https://www.linkedin.com/learning/nail-your-java-interview-2)

> Instantiation: The new keyword is a Java operator that creates the object. Initialization: The new operator is followed by a call to a constructor, which initializes the new object. - Excerpt from Oracle.com