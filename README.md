# Spring Boot 3 GraalVM Gradle Demo
             
You need the following:

```bash
java version "17.0.6" 2023-01-17 LTS
Java(TM) SE Runtime Environment GraalVM EE 22.3.1 (build 17.0.6+9-LTS-jvmci-22.3-b11)
Java HotSpot(TM) 64-Bit Server VM GraalVM EE 22.3.1 (build 17.0.6+9-LTS-jvmci-22.3-b11, mixed mode, sharing)
```

Then run:

```bash
./gradlew clean nativeCompile
```
   
You should then be able to run the native app.
                                                   
```bash
./build/native/nativeCompile/cas --server.ssl.enabled=false --server.port=8080
```

Navigate to: `http://localhost:8080/cas/login` to see:

```
jakarta.servlet.ServletException: Handler processing failed: com.oracle.svm.core.jdk.UnsupportedFeatureError: No classes have been predefined during the image build to load from bytecodes at runtime.
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1103) ~[cas:6.0.4]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:973) ~[cas:6.0.4]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1011) ~[cas:6.0.4]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903) ~[cas:6.0.4]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:527) ~[cas:6.0.0]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885) ~[cas:6.0.4]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614) ~[cas:6.0.0]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:223) ~[na:na]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
	at org.springframework.web.servlet.resource.ResourceUrlEncodingFilter.doFilter(ResourceUrlEncodingFilter.java:66) ~[cas:6.0.4]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:399) ~[na:na]
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapUnsecured$1(ObservationFilterChainDecorator.java:87) ~[na:na]
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:219) ~[na:na]
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191) ~[na:na]
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:351) ~[cas:6.0.4]
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:267) ~[cas:6.0.4]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[cas:6.0.4]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[cas:6.0.4]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[cas:6.0.4]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[cas:6.0.4]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
	at org.apache.catalina.core.ApplicationDispatcher.invoke(ApplicationDispatcher.java:691) ~[na:na]
```
