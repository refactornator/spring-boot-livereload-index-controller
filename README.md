## Spring Boot LiveReload Index Controller ![Maven Central](https://img.shields.io/maven-central/v/cool.william.frontend/spring-boot-livereload-index-controller)
##### A simple controller that serves `resources/templates/index.html` and injects [LiveReload](http://livereload.com/) when [Spring Boot Devtools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools) is included.

Intended to be used in conjunction with this gradle frontend plugin.

### Setup
Available in Maven Central.
```
<dependency>
  <groupId>cool.william.frontend</groupId>
  <artifactId>spring-boot-livereload-index-controller</artifactId>
  <version>0.0.3</version>
</dependency>
```

Add an annotation to your main method, along with `@SpringBootApplication`
```
@Import(IndexController.class)
```
See [FrontendApplication.java](application/src/main/java/cool/william/frontend/FrontendApplication.java) for an example.

This library provides a [Spring Boot Controller](https://www.baeldung.com/spring-controllers), so it depends on [Spring Boot](https://spring.io/projects/spring-boot), specifically [Spring Boot Web](https://spring.io/guides/gs/spring-boot/#_create_a_simple_web_application).
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Include Spring Boot Devtools as a dependency to enable LiveReload. LiveReload if a useful development feature that refreshes the browser window your webapp runs in whenever `index.html` is modified.
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```
