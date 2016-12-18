OBJDIR ?= bld
DOCDIR = docs

PACKAGEDIR ?= pex
APPDIR ?= $(PACKAGEDIR).app.App
ZIPFILE = $(OBJDIR)/proj.jar

EXEC = `find $(PACKAGEDIR) -name "*.java"`

# General rules
all:
	javac $(EXEC) -d $(OBJDIR)

docs: all
	javadoc $(EXEC) -d $(DOCDIR)

zip: #$(DOCDIR)
	jar cvf $(ZIPFILE) $(EXEC) #$(DOCDIR)/*.html

run:
	cd bld; java $(IMPORT) $(APPDIR); cd ..

swing:
	cd bld; java -Dui=swing $(APPDIR); cd ..

clean:
	rm -rf $(OBJDIR)/* $(DOCDIR)/* `find $(PACKAGEDIR) -name "*.class"`

.PHONY: all clean docs zip
