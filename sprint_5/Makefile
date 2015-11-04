##########################################
##### Java standard project Makefile #####
##########################################

# >>> TODO <<<
# > real file targets (use javac on each file)
# > option to add junit.jar in classpath

# Directories
SRCDIR:=src
BINDIR:=bin
SRCDOCDIR:=srcdoc
DOCDIR:=doc
LIBDIR:=lib

# Source files
SRC:=$(shell find $(SRCDIR) -name "*.java")
EXESRC:=$(filter-out %Test.java, $(SRC))
TESTSRC:=$(filter %Test.java, $(SRC))
DOCSRC:=$(shell find $(SRCDOCDIR) -name "*.txt")

# Output files
EXE:=$(shell find $(BINDIR) -name "*.class")
TEST:=$(TESTSRC:$(SRCDIR)/%.java=$(BINDIR)/%.class)
DOC:=$(DOCSRC:$(SRCDOCDIR)/%.txt=$(DOCDIR)/%.html)

# Classpath for javac
CLASSPATH=$(SRCDIR):$(BINDIR):tools/junit.jar

# Name of the jar archive
JARNAME="MakeOPTIweb"


all: test javadoc doc opti


##### User command targets #####

exe: $(EXESRC)
	javac -cp $(CLASSPATH) -d $(BINDIR) $^

test: $(SRC)
	javac -cp $(CLASSPATH) -d $(BINDIR) $^

javadoc: $(EXESRC)
	javadoc -classpath $(CLASSPATH) -d $(DOCDIR)/javadoc $^

doc: $(DOC)

exec_test: $(TEST)
	for test in $^; do \
		classname=$${test#$(BINDIR)/}; \
		java -cp $(CLASSPATH) $${classname%.class}; \
	done

opti:
	java -cp $(CLASSPATH) opti.MakeOPTIweb -nogui
	firefox test/OPTIweb.html

jar: $(EXE)
	cd $(BINDIR)
	exe=($(EXE:$(BINDIR)/%='%'))
	jar cvfm ../$(JARNAME).jar Manifest.txt $${exe[@]}


##### File targets #####

$(DOC): $(DOCDIR)/%.html: $(SRCDOCDIR)/%.txt
	asciidoc -a source-highlighter=pygments -a iconsdir=tools/asciidoc-8.6.9/images/icons -o $@ $<


.ONESHELL:
.PHONY: exe test javadoc doc exec_test opti jar
