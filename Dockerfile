FROM openjdk:17
ADD target/OrderOnline.jar OrderOnline.jar
ENTRYPOINT ["java","-jar","OrderOnline.jar"]
