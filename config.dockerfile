FROM java:15


RUN apt-get -y update
RUN apt-get install -y apache2
RUN sudo service apache2 start

EXPOSE 8080


CMD "docker build --build-arg JAR_FILE=my_react_app-0.0.1-SNAPSHOT.jar"
ENTRYPOINT ["java","-jar","/botmaster.jar"]


