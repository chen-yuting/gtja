@echo off
call mvn clean install -DskipTests
cd app
call mvn jetty:run