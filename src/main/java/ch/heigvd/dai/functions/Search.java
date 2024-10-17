package ch.heigvd.dai.functions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search {

    // Classe interne pour stocker les informations de ligne et de colonne
    public static class Position {
        int lineNumber;
        int columnIndex;

        Position(int lineNumber, int columnIndex) {
            this.lineNumber = lineNumber;
            this.columnIndex = columnIndex;
        }

        @Override
        public String toString() {
            return "Position -> (Ligne " + lineNumber + ", Colonne " + columnIndex + ")";
        }
    }

    /**
     * Search for a string in one file and return a map where each key is an encoding and value is a list of positions.
     * This method will attempt to search the string using multiple encodings.
     *
     * @param fileName The file to search.
     * @param searchString The string to search for.
     * @return A map with encoding as key, and list of arrays (position and encoding) as value.
     *         Also returns a count of total findings for each encoding.
     */
    public Map<String, List<Position>> findInFile(String fileName, String searchString) {
        Map<String, List<Position>> findings = new HashMap<>();
        // Define all the encodings we want to test
        Charset[] charsets  = {
                StandardCharsets.ISO_8859_1,
                StandardCharsets.US_ASCII,
                StandardCharsets.UTF_8,
                StandardCharsets.UTF_16,
                StandardCharsets.UTF_16BE,
                StandardCharsets.UTF_16LE
        };

        for (Charset charset : charsets) {
            List<Position> positions = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName, charset))) {
                String line;
                int lineNumber = 0;

                // Lire le fichier ligne par ligne
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    int index = line.indexOf(searchString);
                    while (index >= 0) {
                        positions.add(new Position(lineNumber, index));
                        index = line.indexOf(searchString, index + 1);
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Fichier non trouvé : " + fileName);
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture du fichier avec encodage " + charset.name());
                e.printStackTrace();
            }

            if (!positions.isEmpty()) {
                findings.put(charset.name(), positions);
            }
        }
        return findings;
    }
}
