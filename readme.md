#iheartjava

##### demo project by Andrew Westwick

This project is a simple java spring API with tests to help me learn!

## Running the project

To build the jar file, run `gradlew clean build` which will generate the jar file in /build/libs

To run the program: `java -jar {path to jar}`

## Notes

* Actuator is running on port 8090, for example to check the API status: localhost:8090/health
* You can explore the API with Swagger at localhost/swagger-ui.html