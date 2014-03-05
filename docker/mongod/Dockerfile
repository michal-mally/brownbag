FROM stackbrew/ubuntu:13.10

RUN apt-get update
RUN apt-get install mongodb-server --force-yes -y
RUN mkdir -p /data/db

EXPOSE 27017
EXPOSE 28017

ENTRYPOINT ["/usr/bin/mongod"]
