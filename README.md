# Memory

An application for keeping notes and todo lists synchronized between different devices. The goal is to remember 
important stuff.

A demo project where an example of a testable architecture is implemented.

The goal is to have a fast way of testig that verifies logic and a slow way of testing that verifies that the web 
application is properly wired up.

The fast, in process, tests will give fast feedback on mistakes regarding the application logic. 
The slower tests, through a browser, will give confidence that the application can be started and used.

Both are valuable and serve different purposes.

# Architecture

The application can be tested using an in memory seam, that is connecting to the application in the same process for testing.
The same verification cn be done using a browser by connecting through a web application.

[A diagram showing the model with the web application]



# Techie stuff

## Build 

Fast build without a browser:

    ./gradlew clean stage

Complete build with a browser:

    ./gradlew clean stage -Dbrowser=true
