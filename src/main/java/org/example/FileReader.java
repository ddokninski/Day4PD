package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    protected List<String> readFile(Path pathToUse) {

        try {
            return Files.readAllLines(pathToUse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
