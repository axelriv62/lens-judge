package lens.judge.b5.verifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class WhiteSpaceToleranceComparer {
    //Cette classe lis le fichier d'entrée et celui de sortie et retourne true si le contenu est similaire, même s'il y a des espaces à des endroits
    //où il n'est pas censé en avoir
    //Elle retourne false si le contenu n'est pas similaire

    private Verifier strictVerifier;

    public WhiteSpaceToleranceComparer(Verifier strictVerifier) {
        this.strictVerifier = strictVerifier;
    }


    public boolean verify(File inputFile, File expectedFile) throws IOException {
        if (!inputFile.exists() || !expectedFile.exists()) {
            throw new IOException("Files do not exist.");
        }
        else {
            String input = Files.lines(inputFile.toPath()).collect(Collectors.joining());
            String expected = Files.lines(expectedFile.toPath()).collect(Collectors.joining());
            return strictVerifier.verify(input, expected);
        }
    }
}