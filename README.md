# Project: File String Searcher <!-- omit from toc -->

This Java Maven project is designed to search for a specific string within one or more files of different formats (e.g., .txt, .csv, .json, etc.). The user inputs the target string and the files to be searched. The application will then output a list of the files in which the string is found, along with the format of each file.

## Students <!-- omit from toc -->

- Rodrigo Lopes dos Santos
- Urs Behrmann

# Table of contents

- [Table of contents](#table-of-contents)
- [Features](#features)
- [Usage](#usage)
- [How to run](#how-to-run)
  - [With IDE](#with-ide)
  - [With Maven](#with-maven)
  - [Output](#output)

# Features

- Accepts multiple file types as input.
- Efficiently searches for the given string across the selected files.
- Outputs the file names and their formats where the string is found.

# Usage

- Provide the string to search for.
- Select one or more files as input.
- View the list of files where the string is found along with the file format.

# How to run

## With IDE

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Run the `Main` class with the following arguments:
   - find
     - the command to run the application.
   - -s "string" or --string "string"
     - The string to search for.
   - file paths
     - The file paths to search in.

example:

```bash

find -s "string" file1 file2 file3 ...

```

## With Maven

1. Clone the repository to your local machine.
2. Open a terminal and navigate to the project directory.
3. Run the following command:

```bash

mvn clean package

```

4. Run the following command:

```bash

java -jar target/FindInFiles-1.0.jar find -s "string" file1 file2 file3 ...

```

the arguments are the same as in the IDE:

- find
  - the command to run the application.
- -s "string" or --string "string"
  - The string to search for.
- file paths
  - The file paths to search in.

## Output

The output will be a list of files where the string was found, along with the file format.

example:

```bash

Encodage: US-ASCII
Position -> (Ligne 12179, Colonne 11)
...

Résumé des résultats par encodage :
Encodage: ISO-8859-1, Total de résultats: 123
Encodage: UTF-8, Total de résultats: 123
Encodage: US-ASCII, Total de résultats: 123

```