OBJDIR ?= bld
DOCDIR = docs

PACKAGEDIR ?= pex
APPDIR ?= $(PACKAGEDIR).app.App
ZIPFILE = $(OBJDIR)/proj.jar

CLASSPATH = .:support/*

EXEC = `find $(PACKAGEDIR) -name "*.java"`

# General rules
all:
	javac $(EXEC) -d $(OBJDIR) -cp $(CLASSPATH)

docs: all
	javadoc $(EXEC) -d $(DOCDIR) -cp $(CLASSPATH)

zip: #$(DOCDIR)
	jar cvf $(ZIPFILE) $(EXEC) #$(DOCDIR)/*.html

run:
	cd bld; java $(APPDIR) -cp $(CLASSPATH); cd ..

swing:
	cd bld; java -Dui=swing $(APPDIR); cd ..

clean:
	rm -rf *.class $(OBJDIR)/* $(DOCDIR)/*

.PHONY: all clean docs zip
