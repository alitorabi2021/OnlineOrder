FROM openjdk:17
COPY ./target/OnlineOrders-0.0.1-SNAPSHOT.jar OnlineOrders-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","OnlineOrders-0.0.1-SNAPSHOT.jar"]
COPY src/main/resources/application-dev.yml /app/src/main/resources/application-dev.yml
ENV SPRING_PROFILES_ACTIVE=dev
ENV SPRING_CONFIG_LOCATION=/app/src/main/resources/application-dev.yml
CMD ["java", "-jar", "OnlineOrders-0.0.1-SNAPSHOT.war", "--spring.config.location=${SPRING_CONFIG_LOCATION}"]
    #FROM openjdk:17
#
## کپی فایل JAR اپلیکیشن به داخل تصویر
#COPY target/OnlineOrders-0.0.1-SNAPSHOT.jar OnlineOrders-0.0.1-SNAPSHOT.jar
#
## مسیر کاری فعلی را تنظیم کنید
#WORKDIR /app

# تنظیمات مربوط به محیط اجرایی (environment)، می‌توانید در اینجا از متغیرهای محیطی استفاده کنید
#ENV SPRING_PROFILES_ACTIVE=dev
#ENV SPRING_CONFIG_LOCATION=./src/main/resources/application-dev.yml


#
