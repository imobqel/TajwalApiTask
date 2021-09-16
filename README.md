# TajwalApiTask

**Framework components:**

1. Programming language: JAVA
2. API automation framework: RestAssured
3. Build/Project management tool: Maven
4. Execution control: TestNG
5. Reporting unit: ExtentReporterNG

**Run Pre-requisites:**
1. Java is installed and configured.
2. Apache Maven is installed and configured.

**How to run:**
1. Clone/Pull the code into your local.
2. Open Terminal (On MacOS) or CMD (on WindowsOS).
3. cd to the projects path.
4. Hit any of the below commands:

- mvn clean test -PflightsApiTests --> To run Get Flights API tests.
- mvn clean test -PhotelsApiTests --> To run POST Hotels Async API tests.
- mvn clean test -PallTests --> To run ALL tests.

**Report location:**

To view the generated ExtentReport after run, go to ProjectsPath/test-output/ExtentReports/TajwalAPIRunReport.html
