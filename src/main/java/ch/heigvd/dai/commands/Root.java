package ch.heigvd.dai.commands;

import picocli.CommandLine;

@CommandLine.Command(
        name = "find",
        description = "A CLI to search for a string in multiple files.",
        version = "1.0.0",
        subcommands = {Find.class},  // Add Find command as a subcommand
        scope = CommandLine.ScopeType.INHERIT,
        mixinStandardHelpOptions = true)
public class Root {

    @CommandLine.Option(
            names = {"-s", "--search"},
            description = "The string to search for in the files.",
            required = true)
    protected String searchString;

    @CommandLine.Parameters(index = "0..*", description = "List of files to search in.")
    protected String[] files;

    public String getSearchString() {
        return searchString;
    }

    public String[] getFiles() {
        return files;
    }
}
