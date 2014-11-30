package PuzzleSolver;

import FileInputOutput.FileIOMod1;
import PuzzleSolver.Puzzle.Puzzle;
import PuzzleSolver.Puzzle.PuzzleCarattere;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class PuzzleSolver {

    public static void main( String[] args ){
        String inputFile = "/Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/input_files/test1.txt";

        // String inputFile = args[0];
        // String outputFile = args[1];
        // Path dei file di prova: /Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/input_files/test1.txt

        Path inputPath = Paths.get(inputFile);
        ArrayList<String> inputContent = FileIOMod1.readContent(inputPath);
        int dimInputContent = inputContent.size();

        Puzzle puzzle1 = new PuzzleCarattere();

        for (String s : inputContent){
            String[] splitInputContent = s.split(" "); // perchè con gli spazi si e con la tabulazione no? \t
            System.out.println(splitInputContent[0]);
            // PezzoCarattere pezzoCorrente = new PuzzleCarattere.PezzoCarattere();
        }



    }
}
