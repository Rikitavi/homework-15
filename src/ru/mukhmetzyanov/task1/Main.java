package ru.mukhmetzyanov.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Ruslan Mukhametzyanov
 * В классе реализованы методы по работе с File и Path
 */
public class Main {
    public static void main(String[] args) {
        //Create new dir
        File file = new File("New directory");
        try {
            file.createNewFile();
            System.out.println("Create successful: " + file);
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Rename dir
        file.renameTo(new File("Work directory"));
        System.out.println("Rename successful: " + new File("Work directory"));
        System.out.println(new File("Work directory").getAbsolutePath());

        //Copy dir
        Path path = new File("Work directory").toPath(), destinationPath = Paths.get("src/Work directory");
        try {
            Files.copy(path, destinationPath);
            System.out.println("Copy successful: " + destinationPath);
            System.out.println(destinationPath.toAbsolutePath());
        } catch (FileAlreadyExistsException ex){
            ex.printStackTrace();
            System.out.println("File exists");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Move File
        Path destinationPath2 = Paths.get("out/Work directory");
        try {
            Files.move(path, destinationPath2);
            System.out.println("Move successful: " + destinationPath2);
            System.out.println(destinationPath2.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Delete dirs
        path.toFile().delete();
        destinationPath.toFile().delete();
        destinationPath2.toFile().delete();
        System.out.println("Delete successful");

    }
}

