# Makefile da inserire nella root dei sorgenti progetto.
JFLAGS = -g
JC = javac
P = Puzzle
S = Solver
IO = FileInputOutput
E = MyException
# export JAVA_HOME=$(/usr/libexec/java_home)

progetto :
	FileInputOutput/FileIOMod1.java \
	Puzzle/Tile.java \
	Puzzle/Puzzle.java \
	Solver/SolverStrategy.java \
	Puzzle/PuzzleCharacter.java \
	Solver/SolverAlgStrategy.java \
	PuzzleSolver.java \	

#	progetto : \
		PuzzleSolver.java \
		Puzzle/PuzzleCharacter.java \
		Puzzle/Puzzle.java \
		Puzzle/Tile.java \
		Solver/SolverAlgStrategy.java \
		Solver/SolverStrategy.java \
		FileInputOutput/FileIOMod1.java \
# ======================================================


PuzzleSolver.java: PuzzleSolver.java
	$(JC) PuzzleSolver.java

PuzzleCharacter.java : PuzzleCharacter.java
	$(JC) $(P)/PuzzleCharacter.java

Puzzle.java : Puzzle.java
	$(JC) $(P)/Puzzle.java

Tile.java : Tile.java
	$(JC) $(P)/Tile.java

SolverAlgStrategy.java : SolverAlgStrategy.java
	$(JC) $(S)/SolverAlgStrategy.java

SolverStrategy.java : SolverStrategy.java
	$(JC) $(S)/SolverStrategy.java

FileIOMod1.java : FileIOMod1.java
	$(JC) $(IO)/FileIOMod1.java


# .SUFFIXES: .java .class
# .java.class:
#	$(JC) $(JFLAGS) Puzzle/*.java
#	$(JC) $(JFLAGS) Solver/*.java
#	$(JC) $(JFLAGS) FileInputOutput/*.java
#	$(JC) $(JFLAGS) *.java


# default:
#	classes

#classes:
#	$(CLASSES:.java=.class)

# ======================================================
# Generazione personale dei file .class
compile:
	$(JC) $(P)/*.java
	$(JC) $(S)/*.java
	$(JC) $(IO)/*.java
	$(JC) *.java
	@echo "Compilazione completata"

# Pulizia dei file .class
clean:
	@$(RM) *.class \
	$(RM) $(P)/*.class \
	$(RM) $(S)/*.class \
	$(RM) $(IO)/*.class \
	echo "Pulizia completata"
