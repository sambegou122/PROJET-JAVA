MAKE = make
JAVA = java
DOC = javadoc
JAVAC = javac
CLASSES = \
	src/board/*.java \
	src/main/*.java \
	src/game/*.java \
	src/caracter/*.java


doc :
	$(DOC) -d docs -subpackages board main game caracter -sourcepath src/
cls :
	$(JAVAC) $(CLASSES) -d classes
	
guerre.jar :
	$(MAKE) cls
	$(MAKE) WAR
	 
	 
agricole.jar :
	$(MAKE) cls
	$(MAKE) AGRI
	
	
clean :
	rm -rf classes/*
	rm -rf jar/*.jar
	rm -rf docs/
	
WAR:	
	jar cvfm jar/guerre.jar manifest-guerre classes
	
AGRI:
	jar cvfm jar/agricole.jar manifest-agricole classes
	
.PHONY :
	guerre.jar agricole.jar cls doc clean
