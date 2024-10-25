package lens.judge.b5;

import lens.judge.b5.problem.Problem;
import lens.judge.b5.problem.TestCase;
import lens.judge.b5.runner.Runner;
import lens.judge.b5.runner.RunnerBuilder;
import lens.judge.b5.verifier.StrictComparer;
import lens.judge.b5.verifier.WhiteSpaceToleranceComparer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LensJudge {
    public static void main(String[] args) {
        // Utilisation du chemin absolu du fichier source Java
        // String sourceFile = "app/src/test/resources/Test.java";
        // String sourceFile = "app/src/test/resources/test.c";
        // String sourceFile = "app/src/test/resources/test.cpp";
        // String sourceFile = "app/src/test/resources/test.py";

        if (args.length < 3) {
            System.out.println("Usage: lensjudge <sourceFile> <inputFile> <expectedOutputFile>");
            return;
        }

        String sourceFile = args[0];
        File inputFile = new File(args[1]);
        File expectedOutputFile = new File(args[2]);

        // Créer un problème avec un TestCase
        StrictComparer comparer = new StrictComparer();
        ArrayList<TestCase> testCases = new ArrayList<>();
        TestCase testCase = new TestCase(inputFile, expectedOutputFile);
        testCases.add(testCase);
        Problem problem = new Problem(testCases, 1000, 256, comparer);  // Limite de temps: 1000 ms, Limite de mémoire: 256 Mo

        // Itérer sur les TestCases du problème
        for (TestCase tc : problem) {
            // Construire et exécuter le Runner
            Runner runner = new RunnerBuilder()
                    .withTestCase(tc)
                    .withSourceFile(sourceFile)  // Chemin complet du fichier source
                    .build();  // Le builder choisit les stratégies en fonction du fichier

            boolean verdict = runner.run(inputFile, expectedOutputFile);  // Exécuter le programme sans vérification pour le moment
            System.out.println("TestCase verdict: " + verdict);
        }

        // Créer un WhiteSpaceToleranceComparer
        WhiteSpaceToleranceComparer verifier = new WhiteSpaceToleranceComparer(comparer);
        // l'utiliser pour vérifier le TestCase
        try {
            boolean verdict = verifier.verify(expectedOutputFile, expectedOutputFile);
            System.out.println("TestCase verdict: " + verdict);
        } catch (IOException e) {
            System.err.println("Error during verification: " + e.getMessage());
            e.printStackTrace();
        }
    }
}