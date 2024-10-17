package ch.heigvd.dai.commands;

import ch.heigvd.dai.functions.Search;
import java.util.concurrent.Callable;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import picocli.CommandLine;

@CommandLine.Command(
        name = "find",
        description = "Find a string in files."
)
public class Find implements Callable<Integer> {

    @CommandLine.Option(
            names = {"-s", "--search"},
            description = "The string to search for in the files.",
            required = true
    )
    private String searchString;

    @CommandLine.Parameters(
            index = "0..*",
            description = "List of files to search in."
    )
    private List<String> files;

    @Override
    public Integer call() throws IOException {
        System.out.println("Search String: " + searchString);
        System.out.println("Files: " + String.join(", ", files));

        Search search = new Search();

        // Parcours des fichiers
        for (String file : files) {
            Map<String, List<Search.Position>> findings = search.findInFile(file, searchString);

            // Afficher les résultats par encodage
            findings.forEach((encoding, positions) -> {
                System.out.println("Encodage: " + encoding);
                positions.forEach(pos -> System.out.println(pos.toString()));
            });

        }
        return 0;
    }
}
