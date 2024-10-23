package lens.judge.b5.verifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * The WhiteSpaceToleranceComparer class is a decorator for the Verifier interface.
 * It ensures that the comparison ignores extra spaces by normalizing the strings
 * before verification.
 */
public class WhiteSpaceToleranceComparer extends VerifierDecorator {

    /**
     * Constructs a WhiteSpaceToleranceComparer with the specified wrapped Verifier.
     *
     * @param wrappedVerifier the Verifier to be wrapped
     */
    public WhiteSpaceToleranceComparer(Verifier wrappedVerifier) {
        super(wrappedVerifier);
    }

    /**
     * Verifies the output against the expected value after normalizing spaces.
     *
     * @param output the output string to be verified
     * @param expected the expected string to compare against
     * @return true if the normalized output matches the normalized expected string, false otherwise
     */
    @Override
    public boolean verify(String output, String expected) {
        String normalizedOutput = normalizeSpaces(output);
        String normalizedExpected = normalizeSpaces(expected);
        return super.verify(normalizedOutput, normalizedExpected);
    }

    /**
     * Verifies the output file against the expected file after normalizing spaces.
     *
     * @param outputFile the output file to be verified
     * @param expectedFile the expected file to compare against
     * @return true if the normalized output matches the normalized expected file, false otherwise
     */
    @Override
    public boolean verify(File outputFile, File expectedFile) {
        try {
            String output = new String(Files.readAllBytes(outputFile.toPath()));
            String expected = new String(Files.readAllBytes(expectedFile.toPath()));
            return verify(output, expected);
        } catch (IOException e) {
            throw new RuntimeException("Error reading files", e);
        }
    }

    /**
     * Normalizes the spaces in the given string by replacing multiple spaces with a single space
     * and trimming leading and trailing spaces.
     *
     * @param string the string to be normalized
     * @return the normalized string, or null if the input string is null
     */
    private String normalizeSpaces(String string) {
        if (string == null) {
            return null;
        }
        // Replace multiple spaces with a single space and trim leading/trailing spaces
        return string.replaceAll("\\s+", " ").trim();
    }
}