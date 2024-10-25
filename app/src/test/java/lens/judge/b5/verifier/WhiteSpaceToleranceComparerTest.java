package lens.judge.b5.verifier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.io.IOException;

class WhiteSpaceToleranceComparerTest {

    @Test
    void verifyShouldReturnTrueIgnoringExtraSpaces() throws IOException {
        Verifier strictVerifier = new StrictComparer();
        WhiteSpaceToleranceComparer comparer = new WhiteSpaceToleranceComparer(strictVerifier);

        File inputFile = new File("C:\\Users\\Bylel\\IdeaProjects\\lens-judge-b5\\app\\src\\test\\java\\lens\\judge\\b5\\verifier\\input.in");
        File expectedFile = new File("C:\\Users\\Bylel\\IdeaProjects\\lens-judge-b5\\app\\src\\test\\java\\lens\\judge\\b5\\verifier\\expected.ans");

        assertTrue(comparer.verify(inputFile, expectedFile));
    }

    @Test
    void verifyShouldReturnTrueForIdenticalStrings() throws IOException {
        Verifier strictVerifier = new StrictComparer();
        WhiteSpaceToleranceComparer comparer = new WhiteSpaceToleranceComparer(strictVerifier);

        File inputFile = new File("lens/judge/b5/verifier/input.in");
        File expectedFile = new File("lens/judge/b5/verifier/expected.ans");

        assertTrue(comparer.verify(inputFile, expectedFile));
    }

    @Test
    void verifyShouldReturnFalseForDifferentCasing() throws IOException {
        Verifier strictVerifier = new StrictComparer();
        WhiteSpaceToleranceComparer comparer = new WhiteSpaceToleranceComparer(strictVerifier);

        File inputFile = new File("lens/judge/b5/verifier/input.in");
        File expectedFile = new File("lens/judge/b5/verifier/expected.ans");

        assertFalse(comparer.verify(inputFile, expectedFile));
    }

    @Test
    void verifyShouldWorkWithFilesIgnoringSpaces() throws IOException {
        Verifier strictVerifier = new StrictComparer();
        WhiteSpaceToleranceComparer comparer = new WhiteSpaceToleranceComparer(strictVerifier);

        File inputFile = new File("lens/judge/b5/verifier/input.in");
        File expectedFile = new File("lens/judge/b5/verifier/expected.ans");

        assertTrue(comparer.verify(inputFile, expectedFile));
    }
}