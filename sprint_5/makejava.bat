rem echo off
set SPRINTDIR=%~dp0
set SRCDIR=./src/
set BINDIR=./bin/

set RUNTEST=1

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION de la librairie
@echo ///////////////////////////////////////////////////////
javac -cp .;%BINDIR%;./tools/junit.jar -d %BINDIR% %SRCDIR%lib/*.java

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION MODEL
@echo ///////////////////////////////////////////////////////
javac -cp .;%BINDIR%;./tools/junit.jar -d %BINDIR% %SRCDIR%model/*.java

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION  CONTROLLER
@echo ///////////////////////////////////////////////////////
javac -cp .;%BINDIR%;./tools/junit.jar -d %BINDIR% %SRCDIR%controller/*.java

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION de la librairie
@echo ///////////////////////////////////////////////////////
javac -cp .;%BINDIR%;./tools/junit.jar -d %BINDIR% %SRCDIR%opti/*.java

@echo.
@echo.Do you want to execute tests ? (1=Yes 0=No)
@set /p RUNTEST= 
@if "%RUNTEST%"=="99" (

call runtest.bat
 
)

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION  JAR EXECUTABLE
@echo ///////////////////////////////////////////////////////

cd bin
jar cfm ../OPTIweb.jar Manifest.txt model controller lib opti
cd ..