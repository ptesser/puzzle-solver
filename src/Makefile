# Makefile da inserire nella root dei sorgenti del progetto.
JFLAGS = -g
JC = javac
P = puzzle
S = solver
IO = fileinputoutput
E = myexception

compile:
	$(JC) $(E)/*.java
	$(JC) $(P)/*.java
	$(JC) $(S)/*.java
	$(JC) $(IO)/*.java
	$(JC) *.java
	@echo "Compilazione completata"

# Pulizia dei file .class
clean:
	$(RM) *.class
	$(RM) $(E)/*.class
	$(RM) $(P)/*.class
	$(RM) $(S)/*.class
	$(RM) $(IO)/*.class
	@echo "Pulizia completata"
