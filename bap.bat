@echo off

color 0a

echo Building...
call gradlew build

echo Publishing...
call gradlew publish

color 07