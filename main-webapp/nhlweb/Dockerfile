FROM maven:3.6-jdk-11

WORKDIR /usr/src/myapp

# cache the dependencies
COPY pom.xml pom.xml
RUN mvn dependency:go-offline

# copy the source tree
COPY .mvn .mvn
COPY src src
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
COPY pom.xml pom.xml

# build
RUN mvn package

# run
WORKDIR /usr/src/myapp/target
CMD ["java", "-jar", "nhlweb-1.0.2.RELEASE.jar"]