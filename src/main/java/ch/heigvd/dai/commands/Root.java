package ch.heigvd.dai.commands;

import picocli.CommandLine;

@CommandLine.Command(
        name = "root",
        description = "A CLI to search for a string in multiple files.",
        version = "1.0.0",
        subcommands = {
                Find.class
        },
        mixinStandardHelpOptions = true
)
public class Root {
    // No specific options or parameters for the root command
}
