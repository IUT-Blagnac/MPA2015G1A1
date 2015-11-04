rem echo off
set SPRINTDIR=%~dp0
set ASCIIDOCDIR=.\tools\asciidoc-8.6.9\
set PLANTUMLDIR=.\tools\
set SRCDOCDIR=./srcdoc/
set BINDOCDIR= ./doc/

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des documentations
@echo ///////////////////////////////////////////////////////

python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %BINDOCDIR%docUtilisateur.html %SRCDOCDIR%docUtilisateur.txt

python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %BINDOCDIR%docTechnique.html %SRCDOCDIR%docTechnique.txt

@echo "///////////////////////////////////////////////////////"
@echo "// COMPILATION de la javadoc"
@echo "///////////////////////////////////////////////////////"
javadoc -classpath tools/junit.jar -d %BINDOCDIR%javadoc src/lib/CSV.java src/model/*.java src/Controller/*.java
