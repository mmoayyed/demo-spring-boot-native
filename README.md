# Spring Boot 3 GraalVM Gradle Demo
             
You need the following:

```bash
java version "17.0.5" 2022-10-18 LTS
Java(TM) SE Runtime Environment GraalVM EE 22.3.0 (build 17.0.5+9-LTS-jvmci-22.3-b07)
Java HotSpot(TM) 64-Bit Server VM GraalVM EE 22.3.0 (build 17.0.5+9-LTS-jvmci-22.3-b07, mixed mode, sharing)
```

Then run:

```bash
./gradlew clean nativeCompile
```
   
You should then be able to run the native app.
                                                   
```bash
./build/native/nativeCompile/cas
```
