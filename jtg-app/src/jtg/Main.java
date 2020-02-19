package jtg;

import java.io.File;
import java.nio.file.Files;

public class Main {

    private static final Generator GENERATOR = new Generator();

    public static void main(String[] args) throws Throwable {
        if (args.length != 3) {
            System.err.println("Usage:");
            System.err.println("  jtg <package-name> <input-file-or-directory> <output-directory>");
            System.exit(1);
        }
        String packageName = args[0];
        File input = new File(args[1]);
        File outputDirectory = new File(args[2]);
        if (!input.isFile() && !input.isDirectory()) {
            System.err.println("Input is neither a file or directory.");
            System.exit(1);
        }
        if (!outputDirectory.isDirectory()) {
            System.err.println("Output is not a directory.");
            System.exit(1);
        }
        File packageDirectory = new File(outputDirectory, packageName.isEmpty() ? "" : packageName.replace(".", "/"));
        if (!packageDirectory.isDirectory()) {
            packageDirectory.mkdirs();
        }
        if (input.isDirectory()) {
            for (File file : input.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".jtg")) {
                    generate(packageName, file, packageDirectory);
                }
            }
            System.exit(0);
        }
        generate(packageName, input, packageDirectory);
        System.exit(0);
    }

    private static void generate(String packageName, File inputFile, File outputDirectory) throws Exception {
        String className = inputFile.getName().replaceFirst("\\.jtg$", "");
        File outputFile = new File(outputDirectory, className + ".java");
        Files.write(outputFile.toPath(), GENERATOR.generate(packageName, className, new String(Files.readAllBytes(inputFile.toPath()))).getBytes());
        System.out.printf("Generated %s from %s.\n", outputFile, inputFile);
    }
}
