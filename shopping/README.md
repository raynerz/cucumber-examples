## BDD: Shopping Cart Example

An electronic shopping cart demonstrating extremely basic functionality.  Products can be added to 
the cart and the cart is able to compute the total value of the items in the cart.  

In this release of the example the shopping cart can only be accessed/manipulated from within the same JVM.  It 
cannot yet be exercised via REST API or HTML technologies.

### Inside-out Business Entity Discovery

The commit sequence in GIT demonstrates a process of discovering the business entities via what is called a 
BDD (Behavior Driven Development) inside-out process. 

The desired business scenarios are formulated using Cucumber syntax.  The scenarios function as both 
documentation and automated tests.  As the automated tests are made to pass the business entities are discovered. 

### Test Automation Interface Discovery

A set of test automation interfaces have been factored out of the implementation. The interfaces enable the Cucumber 
steps to interface with the business entities to test the given Cucumber specified business scenarios.  The interfaces
also enable the test step implementations to remain decoupled from the particular business entity implementations.

The current implementation of the test automation interfaces enables testing of the specified 
business scenarios within the same JVM as the testing framework. However, via polymorphic means, alternative
implementations of the same test automation interfaces can enable automated testing of functionally equivalent 
implementations via: 
- REST APIs 
- HTML pages

### References

[The Cucumber for Java Book: Behaviour-Driven Development for Testers and Developers](https://www.amazon.com/Cucumber-Java-Book-Behaviour-Driven-Development-ebook/dp/B00V20IEXM) 
Chapters 1 to 7









