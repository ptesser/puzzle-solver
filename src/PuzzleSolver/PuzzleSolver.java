package PuzzleSolver;

import FileInputOutput.*;
import Puzzle.*;
import Solver.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class PuzzleSolver {

    public static void main( String[] args ){
        String inputFile = "/Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/input_files/test2.txt";
        String outputFile = "/Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/output_files/empty.txt";
        // String inputFile = args[0];
        // String outputFile = args[1];
        // Path dei file di prova: /Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/input_files/test1.txt

        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        ArrayList<String> inputContent = FileIOMod1.readContent(inputPath);

        Puzzle puzzle1 = new PuzzleCharacter(inputContent);
        System.out.println("num rows: " + puzzle1.getNumRow());
        System.out.println("num columns: " + puzzle1.getNumCol());
        System.out.println("Dim HashMap: " + puzzle1.getPuzzleElementToSolve().size());
        System.out.println("Dim matrix [][]: " + puzzle1.getPuzzleElementSolved().length * puzzle1.getPuzzleElementSolved()[0].length);

        System.out.println("=====================");

        puzzle1.setStrategy(new SolverAlgStrategy());
        puzzle1.solvePuzzle();
        puzzle1.showPuzzleTerminal();

        System.out.println("=====================");

        ArrayList<String> outputContent = puzzle1.convertToArrayList();
        System.out.println("Dim ArrayList output: " + outputContent.size());

        System.out.println("=====================");
        FileIOMod1.writeContent(outputPath, outputContent, puzzle1.getNumRow(), puzzle1.getNumCol());

    }
}
