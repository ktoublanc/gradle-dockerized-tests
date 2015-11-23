# gradle-dockerized-tests
Run gradle tests phase in a docker container

## Left to be done
This project implements a way to run dockerized tests inside a gradle container.
No implementation is made to fail the main build if the dockerized test build fail.
There are several ways to do that, I let you chose the one you want

## What is used here ?
You will find in this project a simple gradle project with:
* Cucumber based test cases
* Gradle build using [bmuschko/gradle-docker-plugin](https://github.com/bmuschko/gradle-docker-plugin) to run and build docker containers

## What is done in this project ?
The idea here is to provide a sample code to test a docker container inside another docker container.
To make it simple, the tests only make a HTTP GET on a [TomEE docker container](https://github.com/tomitribe/docker-tomee).

##How does it works ?
Here are the task ran in the build:

* Create and start a TomEE container
* Create a gradle docker image from [niaquinto/gradle](https://github.com/niaquinto/docker-gradle) with our test cases inside and mount to the container the test sources
    * Also allowing us to process the output (build/dockerized-tests/build/...)
* Launch docker containers
* Wait for them to finish

*Note:* The .m2 directory is not currently mounted to the docker gradle container. (This can avoid useless dependency download)

## Logs from gradle container
Here is an extract of the gradle container logs:

```java
TomEE is down, waiting for 10 sesonds
TomEE is up and running, launching tests
:clean UP-TO-DATE
:compileJava
Download https://repo1.maven.org/maven2/info/cukes/cucumber-java8/1.2.4/cucumber-java8-1.2.4.pom
Download https://repo1.maven.org/maven2/info/cukes/cucumber-jvm/1.2.4/cucumber-jvm-1.2.4.pom
Download https://repo1.maven.org/maven2/org/sonatype/oss/oss-parent/7/oss-parent-7.pom
Download https://repo1.maven.org/maven2/org/easytesting/fest-assert-core/2.0M10/fest-assert-core-2.0M10.pom
Download https://repo1.maven.org/maven2/org/easytesting/fest/1.0.15/fest-1.0.15.pom
Download https://repo1.maven.org/maven2/info/cukes/cucumber-java/1.2.4/cucumber-java-1.2.4.pom
Download https://repo1.maven.org/maven2/org/easytesting/fest-util/1.2.5/fest-util-1.2.5.pom
Download https://repo1.maven.org/maven2/info/cukes/cucumber-core/1.2.4/cucumber-core-1.2.4.pom
Download https://repo1.maven.org/maven2/info/cukes/cucumber-html/0.2.3/cucumber-html-0.2.3.pom
Download https://repo1.maven.org/maven2/org/sonatype/oss/oss-parent/6/oss-parent-6.pom
Download https://repo1.maven.org/maven2/info/cukes/cucumber-jvm-deps/1.0.5/cucumber-jvm-deps-1.0.5.pom
Download https://repo1.maven.org/maven2/info/cukes/gherkin/2.12.2/gherkin-2.12.2.pom
Download https://repo1.maven.org/maven2/info/cukes/cucumber-java8/1.2.4/cucumber-java8-1.2.4.jar
Download https://repo1.maven.org/maven2/org/easytesting/fest-assert-core/2.0M10/fest-assert-core-2.0M10.jar
Download https://repo1.maven.org/maven2/info/cukes/cucumber-java/1.2.4/cucumber-java-1.2.4.jar
Download https://repo1.maven.org/maven2/org/easytesting/fest-util/1.2.5/fest-util-1.2.5.jar
Download https://repo1.maven.org/maven2/info/cukes/cucumber-core/1.2.4/cucumber-core-1.2.4.jar
Download https://repo1.maven.org/maven2/info/cukes/cucumber-html/0.2.3/cucumber-html-0.2.3.jar
Download https://repo1.maven.org/maven2/info/cukes/cucumber-jvm-deps/1.0.5/cucumber-jvm-deps-1.0.5.jar
Download https://repo1.maven.org/maven2/info/cukes/gherkin/2.12.2/gherkin-2.12.2.jar
:processResources UP-TO-DATE
:classes
:jar
:assemble
:compileTestJava
Download https://repo1.maven.org/maven2/junit/junit/4.11/junit-4.11.pom
Download https://repo1.maven.org/maven2/info/cukes/cucumber-junit/1.2.4/cucumber-junit-1.2.4.pom
Download https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.pom
Download https://repo1.maven.org/maven2/org/hamcrest/hamcrest-parent/1.3/hamcrest-parent-1.3.pom
Download https://repo1.maven.org/maven2/junit/junit/4.11/junit-4.11.jar
Download https://repo1.maven.org/maven2/info/cukes/cucumber-junit/1.2.4/cucumber-junit-1.2.4.jar
Download https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
:processTestResources
:testClasses
:test
:check
:build

BUILD SUCCESSFUL

Total time: 19.955 secs

This build could be faster, please consider using the Gradle Daemon: https://docs.gradle.org/2.7/userguide/gradle_daemon.html
```