@echo off
title %1
rem -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n
rem java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar -Dspring.profiles.active=%1 ./target/reference-0.4.0.jar

java -jar -Dspring.profiles.active=%1 ./target/reference-0.5.0-exec.jar 