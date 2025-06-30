# mod8Assignment

How can I ensure that my code, program, or software is functional and secure?

I ensure functionality through comprehensive unit testing with JUnit 5, as shown in ContactTest.java and ContactServiceTest.java, covering happy paths and edge cases, achieving near 100% code coverage. For security, I implement strict input validation in the Contact class, rejecting null values and invalid formats (e.g., non-10-digit phone numbers) to prevent vulnerabilities like null pointer exceptions. In the future, I’ll use static analysis tools and sanitize inputs to enhance security further.

How do I interpret user needs and incorporate them into a program?

I interpret user needs by analyzing requirements, such as the Contact Service’s constraints, and translate them into validation logic in the Contact class constructor and setters. JUnit tests like testLongFirstName ensure compliance with these rules. I adopt a user-centric mindset, anticipating misuse and providing clear error messages. Going forward, I’ll engage stakeholders directly and use prototyping to validate requirements early.

How do I approach designing software?

My design approach prioritizes modularity and maintainability, as seen in the Contact class and ContactService. I write tests alongside or before code to guide implementation, ensuring requirements are met. I use @BeforeEach to reduce test duplication. In the future, I’ll adopt test-driven development fully, apply design patterns like Singleton, and use linters for consistent, scalable designs.
