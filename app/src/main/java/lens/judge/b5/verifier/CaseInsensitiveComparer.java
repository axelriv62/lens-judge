package lens.judge.b5.verifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CaseInsensitiveComparer extends VerifierDecorator {

    public CaseInsensitiveComparer(Verifier wrappedVerifier) {
        super(wrappedVerifier);
    }

    @Override
    public boolean verify(String output, String expected) {
        String normalizedOutput = output.toLowerCase();
        String normalizedExpected = expected.toLowerCase();
        return super.verify(normalizedOutput, normalizedExpected);
    }

    @Override
    public boolean verify(File outputFile, File expectedFile) {
        try {
            String output = new String(Files.readAllBytes(outputFile.toPath())).toLowerCase();
            String expected = new String(Files.readAllBytes(expectedFile.toPath())).toLowerCase();
            return verify(output, expected);
        } catch (IOException e) {
            throw new RuntimeException("Error reading files", e);
        }
    }
}