OBJDIR ?= bld
DOCDIR = docs

PACKAGEDIR ?= pex
APPDIR ?= $(PACKAGEDIR).app.App
ZIPFILE = $(OBJDIR)/ep.jar

EXEC = `find $(PACKAGEDIR) -name "*.java"`

# General rules
all:
	javac $(EXEC) -d $(OBJDIR)

docs: all
	javadoc $(EXEC) -d $(DOCDIR)

zip: #$(DOCDIR)
	jar cvf $(ZIPFILE) $(EXEC) #$(DOCDIR)/*.html

run:
	cd bld; java $(APPDIR); cd ..

swing:
	cd bld; java -Dui=swing $(APPDIR); cd ..

clean:
	rm -rf *.class $(OBJDIR)/* $(DOCDIR)/*

.PHONY: all clean docs zip
