Chatspry Java Project
=======================

This project is meant to contain all Chatspry-specific Java code, as well as an Android application. Because of the
Gradle-based structure, it should be possible to pull the project and utilise your favourite IDE to generate project
files as well as build the artifacts.

Developing
----------

This project relies on Gradle to function, and provides a gradle wrapper in the repo. It's expected that you will have
a Java install >= 7. To build the library artifact, it should be as simple as

    $ ./gradlew :lib:compile

and the Android app can be compiled with

    $ ./gradlew :app:assembleDebug

The code will compile against Java 7, and all Java 7 features may be used apart from `try-with-resources` due to lack of
support on some versions of Android.

### Project Structure

All general library code should be placed within the `lib` directory

Application-specific code should be placed within the `app` directory