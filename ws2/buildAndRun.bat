@echo off
call mvn clean package
call docker build -t fr.emobdev.tracktri/ws2 .
call docker rm -f ws2
call docker run -d -p 9080:9080 -p 9443:9443 --name ws2 fr.emobdev.tracktri/ws2