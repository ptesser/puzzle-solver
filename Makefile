# Makefile da inserire nella root dei sorgenti del progetto.
JFLAGS = -g
JC = javac
JA = java
SRC = src
P = puzzle
S = solver
IO = fileinputoutput
E = myexception
L = logger
R = objrem
input = input_files/input1.txt
output = output_files/file_esempio_out.txt
server = "test"

default:
	@cd $(SRC) && make compile

loadserver:
	@cd $(SRC) && rmiregistry&
	@cd $(SRC) && $(JA) PuzzleSolverServer $(server)

loadclient:
	@cd $(SRC) && $(JA) PuzzleSolverClient ../$(input) ../$(output) $(server)

# Pulizia dei file .class
clean:
	$(RM) $(SRC)/*.class
	$(RM) $(SRC)/$(R)/*.class
	$(RM) $(SRC)/$(E)/*.class
	$(RM) $(SRC)/$(P)/*.class
	$(RM) $(SRC)/$(S)/*.class
	$(RM) $(SRC)/$(IO)/*.class
	$(RM) $(SRC)/$(L)/*.class
	@echo "Pulizia completata"
