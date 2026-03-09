import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class JavaToMarkdownConverter {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java JavaToMarkdownConverter <parent-folder-path>");
            return;
        }

        Path parentDir = Paths.get(args[0]);

        if (!Files.exists(parentDir)) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Create markdown output folder
        Path outputDir = parentDir.resolve("markdown-output");

        try {
            Files.createDirectories(outputDir);
        } catch (IOException e) {
            System.out.println("Failed to create output directory");
            e.printStackTrace();
            return;
        }

        try (Stream<Path> paths = Files.walk(parentDir)) {

            paths
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(p -> convertToMarkdown(p, parentDir, outputDir));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertToMarkdown(Path javaFilePath, Path parentDir, Path outputDir) {

        try {

            String fileName = javaFilePath.getFileName().toString();
            String mdFileName = fileName.replace(".java", ".md");

            // Preserve folder structure
            Path relativePath = parentDir.relativize(javaFilePath.getParent());
            Path targetDir = outputDir.resolve(relativePath);

            Files.createDirectories(targetDir);

            Path mdFilePath = targetDir.resolve(mdFileName);

            String content = new String(Files.readAllBytes(javaFilePath));

            String markdownContent =
                    "# " + fileName + "\n\n" +
                    "```java\n" +
                    content +
                    "\n```";

            Files.write(mdFilePath, markdownContent.getBytes());

            System.out.println("Converted: " + javaFilePath + " -> " + mdFilePath);

        } catch (IOException e) {
            System.out.println("Failed to convert: " + javaFilePath);
            e.printStackTrace();
        }
    }
}
