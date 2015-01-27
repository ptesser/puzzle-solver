# Makefile da inserire nella root dei sorgenti del progetto.
JFLAGS = -g
JC = javac
P = puzzle
S = solver
IO = fileinputoutput
E = myexception
L = logger
R = objrem

compile:
	$(JC) $(R)/*.java
	$(JC) $(E)/*.java
	$(JC) $(P)/*.java
	$(JC) $(S)/*.java
	$(JC) $(IO)/*.java
	$(JC) $(L)/*.java
	$(JC) *.java
	@echo -e "\x1B[01;32m Compilazione completata \x1B[0m"