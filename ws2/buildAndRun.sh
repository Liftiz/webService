#!/bin/sh
mvn clean package && docker build -t fr.emobdev.tracktri/ws2 .
docker rm -f ws2 || true && docker run -d -p 9080:9080 -p 9443:9443 --name ws2 fr.emobdev.tracktri/ws2