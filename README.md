# qa-auto

## Useful links

GitHub repo - https://github.com/sohaiby2s/qa-auto


## Description
This framework is used to automate rest api for task by using Cucumber and Rest Assured.

## Prerequisites
This framework requires following
* Java 14
* Maven
* [Docker](https://www.docker.com) >= 17.06 CE
* [Docker Compose](https://docs.docker.com/compose/install/)
* Makefile support
## Setup
### Docker configuration

#### Initial run
```bash
make install
```
This will take some time because it'll seed database with a lot of test data.
After install you can check application health: http://localhost:8000/health-check

#### Stopping application
```bash
make stop
```

Restart with fresh db seeds:
```
make restart
```

### Run Locally
The project is hosted on Github. It can be either downloaded as a zip file or cloned.

#### Get project as a zip file
To get the project as zip file, please follow these steps:
> * go to the link https://github.com/sohaiby2s/qa-auto
> * Download the master branch as a zip
#### Get the project by clonning repository
> * Execute below command on cmd or mac terminal to check the version
> ```git --version```

If the version is not displayed than do the following steps:
> * Download and install git
> * Run ```git clone https://github.com/sohaiby2s/qa-auto```
#### Configuration
The framework can be run against multiple environments. The environments are defined in:
> * src/test/resources/configurations/configurations.json
#### To run the tests locally run
> *   Go to the project root folder through cmd
>     ```cd {Project-Path}```
> *   Execute below command on cmd
>     ```mvn clean test -Denvironment={ENVIRONMENT NAME}```

**{ENVIRONMENT NAME}**
This framework is supporting following environments
* dev1
* dev2
* uat
* prod

#### EXAMPLE COMMAND
> ```mvn clean test -Denvironment=uat```

By default this framework will execute for **dev1** environment
To execute it on default parameters just execute the following command
> ```mvn clean test```

### REPORTING
A detailed Cucumber JVM report is being generated after every execution on following path
> * target/cucumber-JVM-reports/cucumber-html-reports/report-feature_{uniqueId}.html

## TEST SCENARIOS

Following are the test scenarios

| TestCase # | Description | Status |
|------------|-------------|--------|
| TC1        | Validate that all task for the user is retrieving successfully  | PASS   |
| TC2        | Validate that the task should not be updated for the device id not found   | PASS   | 
| TC3        | Validate that the task is successfully updating   | FAIL   |
| TC4        | Verify that the valid token is successfully generating if valid credentials are provided   | PASS   |
| TC5        | Verify that the valid token is not generating if invalid credentials are provided  | PASS   |
| TC6        | Verify authentication failure message if the an invalid token is provided to the fetch the tasks   | PASS   |
| TC7        | Verify that the previous token should be invalid if new token is generated   | FAIL   |
| TC8        | Verify token should be invalidated if any modification is done in the generated token   | FAIL   |
| TC9        | Validate that the token should be expired after 30 min   | FAIL   |

## Issues found
Following issues are found:
* Api is not updating the values so the test case to update Api is failing.
* Api is not making previously generated token as an invalid and allowing to use previously generating token
* Api is wrongly accepting the modified token requests
* Token is not expiring after 30 min

## Test Execution Report
A detailed test execution report has been added **Test-Execution-Report-JET.pdf**
## Framework structure
### Configuration file
configuration.json file iks placed under resources/configurations folder containing environments and user credentials 
### Runner class(Testrunner)
The Test Runner helps running the feature files and it connects feature files with the Step Definition classes
### Model
It contains the classes which are used in parsing JSON response in the form of objects.
### Context
It contains the core functionalities of rest api endpoints. Every single class contains the seperate rest api endpoints functonality. It is being used by step definition. 
### Step definition files
This is the actual test case layer which calls specific context classes to perform the test executions.
### Features files
Contain BDD test scenarios. This layer is in human readable form which is easily understandable by the end users.
### Config Reader
Class that is responsible for parsing data from the configuration file
## Future Improvements
* Add detailed logging to the file.
* Test coverage needs to be improved.
* Use builder pattern to create input instead of using JSON.
* Configuration files should be placed in more secure environment like S3 bucket.