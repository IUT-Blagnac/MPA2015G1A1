rem echo off
@set SPRINTDIR=%~dp0
@set SRCDIR=./src/
@set BINDIR=./bin/

@echo ///////////////////////////////////////////////////////
@echo // EXECUTION des tests
@echo ///////////////////////////////////////////////////////


@echo /////////////////////////////////////////////////
@echo // Test Controller
@echo /////////////////////////////////////////////////

java -cp bin;tools/junit.jar controller.SubjectControllerTest

@echo /////////////////////////////////////////////////
@echo // Test Lib
@echo /////////////////////////////////////////////////

java -cp bin;tools/junit.jar lib.CSVTest
