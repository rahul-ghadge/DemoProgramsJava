package com.demo.program.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class RenameFilesFromDir {

    public static void main(java.lang.String[] args) {

        //working folder
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path :: ");
        String dir = scanner.next();

        System.out.println("Enter replace by :: ");
        String replaceBy = scanner.next();


        //recursively list files before renaming
        listFiles(dir, replaceBy);

        //rename files - replace text in the name with song.text
        //renameFiles(dir, "abc", "xyz");

        //recursively list files after renaming
        listFiles(dir, null);
    }


    public static void listFiles(String dir, String replaceBy) {
        try {
            Stream<Path> files = Files.find(Paths.get(dir), Integer.MAX_VALUE, (filePath, fileAttr) -> fileAttr.isRegularFile());

            files.filter(path -> null != replaceBy && replaceBy.trim().length() > 0)
                    .forEach(name -> renameFiles(dir, name.getFileName().toString(), replaceBy));

            files.filter(path -> null == replaceBy || replaceBy.trim().length() == 0)
                    .forEach(name -> System.out.println(name.getFileName()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renameFiles(String dir, String replace, String replaceBy) {
        try {
            try (Stream<Path> stream = Files.find(Paths.get(dir), 3, // (path, attr) -> String.valueOf(path).endsWith(".txt")))
                    (path, attr) -> attr.isRegularFile())) {
                stream.map(String::valueOf).forEach(item -> {
                            try {
                                Files.move(new File(item).toPath(), new File(item.replace(replace, replaceBy)).toPath());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
