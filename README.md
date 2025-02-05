Hybrid Web Automation Framework - Selenium

## Description
Web automation framework based on Selenium and TestNg using Page Object Model design.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Configuration](#configuration)
- [Testing](#testing)


## Installation

### Prerequisites
- Java JDK 11 or higher
- Maven 3.6.x
- browsers such as Chrome, Firefox, Edge (for UI tests)

### Usage
#### Clone the repository
git clone <repository-url>

#### Navigate to the project directory
cd <project-directory>

#### Install dependencies
mvn install


### Features
1. Cross-browser testing support
2. Headless mode execution
3. Local and remote execution capabilities
4. Configurable test environments
5. Detailed test reporting

### Configuration
Environment Configuration
config.properties file in the src/test/resources directory:

#### Sample configuration
browser=chrome
url=https://practicesoftwaretesting.com/
headless=false
executionEnv=local

### Run tests using Maven:

#### Run all tests from a suite in headless mode
mvn clean test "-DsuiteXml=testng.xml" "-Dheadless=true"

#### Run all tests from a suite in headed mode
mvn clean test "-DsuiteXml=testng.xml" "-Dheadless=false"

Project Structure
```

SeleniumAutomation/
├── screenshots/
├── src/
│   ├── main/
│   │   ├── java/
│   │       ├── browserFactory/
│   │       │   ├── BrowserManager.java
│   │       │   ├── ChromeDriverManager.java
│   │       │   ├── EdgeDriverManager.java
│   │       │   └── FirefoxDriverManager.java
│   │       ├── utils/
│   │           ├── CommonUtils.java
│   │           ├── Constants.java
│   │           ├── DataMap.java
│   │           ├── DriverFactory.java
│   │           ├── ExcelUtil.java
│   │           ├── Logs.java
│   │           ├── SeleniumActions.java
│   │           └── TestAllureReportListener.java
│   ├── test/
│       ├── java/
│       │   ├── page_action_handler/
│       │   │   └── Register.java
│       │   ├── pages/
│       │   │   ├── HomePage.java
│       │   │   ├── LoginPage.java
│       │   │   ├── MyAccountPage.java
│       │   │   └── RegistrationPage.java
│       │   ├── testCases/
│       │       ├── LoginTest.java
│       │       ├── RegisterUserTest.java
│       │       └── TestBase.java
│       ├── resources/
│           ├── testData/
│           │   └── TestData.xlsx
│           ├── allure.properties
│           ├── config.properties
│           └── log4j2.xml
├── README.md
├── crossbrowserTest.xml
├── pom.xml
└── testng.xml
```


Contact
Your Name - vdinuu@gmail.com
Project Link: https://github.com/vdinuu/WebAutomation_SeleniumTestNg.git
Branch - develop

Status
Project status: Active