FROM maven:3.6.0-jdk-11
RUN mkdir app
RUN cd app
RUN git init
RUN git pull https://github.com/ESGI-microservice/microservice-java-app.git