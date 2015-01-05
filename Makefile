# Makefile da inserire nella root dei sorgenti del progetto.
JFLAGS = -g
JC = javac
JA = java
SRC = src
P = Puzzle
S = Solver
IO = FileInputOutput
E = MyException
input = input_files/input1.txt
output = output_files/file_esempio_out.txt

default:
	@cd $(SRC) && make compile

compile:
	$(JC) $(SRC)/$(E)/*.java
	$(JC) $(SRC)/$(P)/Tile.java
	$(JC) $(SRC)/$(P)/Puzzle.java
	$(JC) $(SRC)/$(S)/*.java
	$(JC) $(SRC)/$(P)/*.java
	$(JC) $(SRC)/$(IO)/*.java
	$(JC) $(SRC)/*.java
	@echo "Compilazione completata"

load:
	@cd $(SRC) && $(JA) PuzzleSolver ../$(input) ../$(output)


# Pulizia dei file .class
clean:
	$(RM) $(SRC)/*.class
	$(RM) $(SRC)/$(E)/*.class
	$(RM) $(SRC)/$(P)/*.class
	$(RM) $(SRC)/$(S)/*.class
	$(RM) $(SRC)/$(IO)/*.class
	@echo "Pulizia completata"
