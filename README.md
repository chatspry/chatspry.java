Chatspry Java Client
=======================

This project contains the Chatspry Java client, as well as all supporting code.

Developing
----------

This project relies on Gradle to function, and provides a gradle wrapper in the repo. It's expected that you will have
a Java install >= 7. To build the library artifact, it should be as simple as

    $ ./gradlew compile

The code will compile against Java 6, and supports Apache Harmony and Android clients without any workarounds.

### Testing

While the code does currently contain JUnit tests, the coverage is incomplete and will be revisited at a later time.
Code coverage is not a top priority for this library, as there is very little custom code and libraries provided by
Square and ReactiveX are already thoroughly tested.