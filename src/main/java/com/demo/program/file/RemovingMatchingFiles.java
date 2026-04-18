package com.demo.program.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemovingMatchingFiles {

    public static void main(String[] args) {

        String filePath = "D:\\temp-files";

        // Keeping mp4 and English subtitle files from directory
        Predicate<Path> exclusions = path -> (path.toString().endsWith("_en.vtt") || path.toString().endsWith(".mp4"));
        // Removing only subtitles files from directory
        Predicate<Path> inclusions = path -> path.toString().endsWith(".vtt");

        List<Path> getFiles = getMatchingFiles(filePath, exclusions.negate(), inclusions);
        // getFiles.forEach(System.out::println);

        // Deleting the filtered files
        deleteFiles(getFiles);
    }


    public static List<Path> getMatchingFiles(String dir, Predicate<Path> exclusions, Predicate<Path> inclusions) {

        try (Stream<Path> walk = Files.walk(Paths.get(dir))) {
            return walk.filter(Files::isRegularFile)
                    .filter(exclusions)
                    .filter(inclusions)
//                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public static void deleteFiles(List<Path> filesToBeDeleted) {
        filesToBeDeleted.forEach(file -> {
            System.out.println(file.getFileName().toString());
            try {
                Files.delete(file);
            } catch (IOException e) {
                System.err.println("Failed to delete file: " + file.getFileName().toString());
                throw new RuntimeException(e);
            }
        });
    }
}
