LEGO (Legal Ethics Governance Office)

To run the app from Gradle

// This will start up a Tomcat instance
gradle bootRun

In the LegoApplication.class file
This uses the default values:
SpringApplication.run(Application.class, args);

If you want to customise the instance do this:
SpringApplication app = new SpringApplication(Application.class);
app.setShowBanner(false);
app.setAddCommandLineProperties(true);
app.run(args);

See https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

Properties files
You can put properties files on the classpath, or in /config under classpath,
or you can add it as an arguement
java -jar myproject.jar --spring.config.location=classpath:/default.properties,classpath

Default name is application.properties
or
Use the Application.yml file as a properties file.

When the @EnableConfigurationProperties annotation is applied to your @Configuration,
any beans annotated with @ConfigurationProperties will be automatically configured from
the Environment properties.
eg, in Application.class file
@EnableConfigurationProperties(Config.class)

| Annotation | Meaning                                             |
+------------+-----------------------------------------------------+
| @Component | generic stereotype for any Spring-managed component |
| @Repository| stereotype for persistence layer                    |
| @Service   | stereotype for service layer                        |
| @Controller| stereotype for presentation layer (spring-mvc)      |
+------------+-----------------------------------------------------+

Test Restful WS
curl http://localhost:8080/cosi?pmid=1339101

curl http://localhost:8081/info

curl http://localhost:8081/health

Testing
See HelloControllerTestIT.java
The embedded server is started up on a random port by virtue of the @IntegrationTest("${server.port=0}") and 
the actual port is discovered at runtime with the @Value("${local.server.port}").

------------------------------------------------------------------------------------------------------------

I'm converting the Lego client to use HTML5 components rather than Bootstrap

Starting with HTML5Boilerplate.
https://html5boilerplate.com/


