/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lens.judge.b5;

import lens.judge.b5.Process.IProcess;
import lens.judge.b5.Process.ProcessAdapter;
import lens.judge.b5.compiler.JavaCompilationStrategy;
import lens.judge.b5.execution.IExecutionStrategy;
import lens.judge.b5.execution.JavaExecutionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {

    private static final String JAVA_FILE = "app/src/test/resources/Test.java";
    private static final String C_FILE = "src/test/resources/test.c";
    private static final String CPP_FILE = "src/test/resources/test.cpp";
    private static final String PYTHON_FILE = "src/test/resources/test.py";
    private static final String BIN_DIR = "app/bin/";

    public static void main(String[] args) throws InterruptedException, IOException {

        Files.createDirectories(Paths.get(BIN_DIR));

        System.out.println("Welcome to the Lens Judge!");

        JavaCompilationStrategy strategy = new JavaCompilationStrategy();
        String command = strategy.getCompileCommand(JAVA_FILE, BIN_DIR + "Test.class");

        // Debug: Afficher la commande exécutée
        System.out.println("Executing Java compile command: " + command);

        Process process = Runtime.getRuntime().exec(command);
        logProcessOutput(process);

        // Debug: Vérifier si le fichier .class a été créé
        System.out.println("Checking if compiled Java class exists: " + BIN_DIR + "Test.class");

        boolean classFileExists = Files.exists(Paths.get(BIN_DIR + "Test.class"));
        System.out.println("Class file exists: " + classFileExists);

        IExecutionStrategy executionStrategy = new JavaExecutionStrategy("Test");
        executionStrategy.execute();

        System.out.println(executionStrategy.getProcess().getOutput());

    }

    private static void logProcessOutput(Process process) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }
        }
    }
}
