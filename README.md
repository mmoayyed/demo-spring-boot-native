# Spring Boot 3 GraalVM Gradle Demo
             
You need the following:

```bash
java version "17.0.5" 2022-10-18 LTS
Java(TM) SE Runtime Environment GraalVM EE 22.3.0 (build 17.0.5+9-LTS-jvmci-22.3-b07)
Java HotSpot(TM) 64-Bit Server VM GraalVM EE 22.3.0 (build 17.0.5+9-LTS-jvmci-22.3-b07, mixed mode, sharing)
```

Then run:

```bash
./gradlew nativeCompile
```
   
You should then be able to run the native app.

Then modify the list of dependencies:

```groovy

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    runtimeOnly 'org.springframework.boot:spring-boot-starter-tomcat'

    implementation "org.apereo.cas:cas-server-core-authentication-api:7.0.0-SNAPSHOT"
}
```
    
The new dependency contains no auto-configuration classes. Run the build again,
and while it completes successfully, AOT sources are NOT fully generated and the native app
fails to launch, complaining about a missing servlet factory.
                                                   
```bash
./build/native/nativeCompile/cas


     _    ____  _____ ____  _____ ___     ____    _    ____
    / \  |  _ \| ____|  _ \| ____/ _ \   / ___|  / \  / ___|
   / _ \ | |_) |  _| | |_) |  _|| | | | | |     / _ \ \___ \
  / ___ \|  __/| |___|  _ <| |__| |_| | | |___ / ___ \ ___) |
 /_/   \_\_|   |_____|_| \_\_____\___/   \____/_/   \_\____/


2022-12-21T18:33:48.386+04:00  INFO 19975 --- [           main] org.apereo.cas.CasNativeApplication      : Starting AOT-processed CasNativeApplication v7.0.0-SNAPSHOT using Java 17.0.5 with PID 19975 (/Users/misagh/Downloads/demo/build/native/nativeCompile/cas started by misagh in /Users/misagh/Downloads/demo)
2022-12-21T18:33:48.386+04:00  INFO 19975 --- [           main] org.apereo.cas.CasNativeApplication      : No active profile set, falling back to 1 default profile: "default"
2022-12-21T18:33:48.645+04:00  WARN 19975 --- [           main] w.s.c.ServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.context.ApplicationContextException: Unable to start web server
2022-12-21T18:33:48.645+04:00 ERROR 19975 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   :

***************************
APPLICATION FAILED TO START
***************************

Description:

Web application could not be started as there was no org.springframework.boot.web.servlet.server.ServletWebServerFactory bean defined in the context.

Action:

Check your application's dependencies for a supported servlet web server.
Check the configured web application type.

```
