package ch.heigvd.dai.commands;

import ch.heigvd.dai.functions.Search;
import java.util.concurrent.Callable;
import java.util.List;
import java.io.IOException;
import picocli.CommandLine;

@CommandLine.Command(name = "find", description = "Find a string in files.")
public class Find implements Callable<Integer> {

    @CommandLine.ParentCommand
    protected Root parent;

    @Override
    public Integer call() {
        Search search = new Search();
        String searchString = parent.getSearchString();
        String[] files = parent.getFiles();

        for (String file : files) {
            System.out.println("Searching in file: " + file);
            try {
                // Call findInFile for each file and get the results
                List<String[]> results = search.findInFile(file, searchString);

                // Output the results for this file
                if (results.isEmpty()) {
                    System.out.println("No occurrences of the string were found in: " + file);
                } else {
                    System.out.println("Occurrences in file: " + file);
                    for (String[] result : results) {
                        System.out.println("Position: " + result[0] + ", Encoding: " + result[1]);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + file);
            }
        }

        return 0;
    }
}
