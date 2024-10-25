package lens.judge.b5.verifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WhiteSpaceToleranceComparer extends VerifierDecorator {

    public WhiteSpaceToleranceComparer(Verifier wrappedVerifier) {
        super(wrappedVerifier);
    }

    @Override
    public boolean verify(String output, String expected) {
        String normalizedOutput = normalizeSpaces(output);
        String normalizedExpected = normalizeSpaces(expected);
        return super.verify(normalizedOutput, normalizedExpected);
    }

    @Override
    public boolean verify(File outputFile, File expectedFile) {
        try {
            String output = normalizeSpaces(new String(Files.readAllBytes(outputFile.toPath())));
            String expected = normalizeSpaces(new String(Files.readAllBytes(expectedFile.toPath())));
            return verify(output, expected);
        } catch (IOException e) {
            throw new RuntimeException("Error reading files", e);
        }
    }

    private String normalizeSpaces(String input) {
        return input.replaceAll("\\s+", " ");
    }
}