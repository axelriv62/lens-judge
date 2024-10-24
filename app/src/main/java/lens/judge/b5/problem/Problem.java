package lens.judge.b5.problem;

import lens.judge.b5.verifier.Verifier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Problem implements Iterable<TestCase> {
    private List<TestCase> testCases;
    private int timeLimit;
    private int memoryLimit;
    private Verifier verifier;

    public Problem(List<TestCase> testCases, int timeLimit, int memoryLimit, Verifier verifier) {
        this.testCases = testCases;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.verifier = verifier;
    }

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    @Override
    public Iterator<TestCase> iterator() {
        return testCases.iterator();
    }

    public boolean verifyTestCase(TestCase testCase) {
        return verifier.verify(testCase.getOutput(), testCase.getExpected());
    }
}