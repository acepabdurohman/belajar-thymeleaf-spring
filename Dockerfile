FROM java:8
VOLUME /tmp
EXPOSE 8077
ADD /target/belajar-thymeleaf-spring-0.0.1-SNAPSHOT.jar belajar-thymeleaf-spring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","belajar-thymeleaf-spring-0.0.1-SNAPSHOT.jar"]