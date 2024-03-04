FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=haremdb
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=adminpass

COPY ./db-scripts/ /docker-entrypoint-initdb.d/
