FROM ubuntu:14.04

RUN apt-get update && apt-get install -y vim apache2
RUN service apache2 start

EXPOSE 80 8080
