List of command used:

after adding 	
<packaging>jar</packaging> to pom.xml

mvn clean install

once build is completed a jar file is generated in target called fat jar
since it contains all the depedencies for the package and the tomcat server 
as well, we run this command

mvn spring-boot:run

due to this plugin
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
	<configuration>
		<excludes>
			<exclude>
				<groupId>org.projectlombok</groupId>
				<artifactId>lombok</artifactId>
			</exclude>
		</excludes>
	</configuration>
</plugin>

maven will look for a jar in the target folder and run it.

we can directly run the account ms
java -jar target/accounts-0.0.1-SNAPSHOT.jar

Disadvantages of Dockerfile approach to build image
- Big projects require complex dockerfiles 
- Writing dockerfile has learning curve to and
	as a programmer we don't know to bother about it
- We need to follow good approach and standard to write docker files
- The dockerfiles should be optimized to generate optimal image
- To counter this we have build packs

command to build docker file
docker build -t ashutiwarydock/accounts:v1 .

- we can provide configs in command line arguments as program variables
--spring.profiles.active=prod --build.version=1.1

- we can provide vm variable through vm arguments like :
-Dspring.profiles.active=prod -Dbuild.version=1.1

in the envoriment variable we can provide:
BUILD_VERSION=1.3;SPRING_PROFILES_ACTIVE=prod


