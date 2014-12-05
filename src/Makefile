# Makefile da inserire nella root dei sorgenti progetto.
JFLAGS = -g
JC = javac
P = Puzzle
S = Solver
IO = FileInputOutput
# ======================================================

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) Puzzle/*.java
	$(JC) $(JFLAGS) Solver/*.java
	$(JC) $(JFLAGS) FileInputOutput/*.java
	$(JC) $(JFLAGS) *.java

CLASSES = \
	Puzzle/Tile.java \
	Puzzle/Puzzle.java \
	Puzzle/PuzzleCharacter.java \
	Solver/SolverStrategy.java \
	Solver/SolverAlgStrategy \
	FileInputOutput/FileIOMod1.java \
	PuzzleSolver.java

default:
	classes

classes:
	$(CLASSES:.java=.class)

# Generazione personale dei file .class
compile:
	$(JC) $(JFLAGS) $(P)/*.java
	$(JC) $(JFLAGS) $(S)/*.java
	$(JC) $(JFLAGS) $(IO)/*.java
	$(JC) $(JFLAGS) *.java
	@echo "Compilazione completata"

# Pulizia dei file .class
clean:
	@$(RM) *.class \
	$(RM) $(P)/*.class \
	$(RM) $(S)/*.class \
	$(RM) $(IO)/*.class \
	echo "Pulizia completata"
