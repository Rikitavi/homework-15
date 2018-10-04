package ru.mukhmetzyanov.task2;
/**
 * @author Ruslan Mukhametzyanov
 */

import java.io.File;

public class Task2 {
    /**
     * Папки указанные в File созданы заранее.ы
     * @param args
     */
    public static void main(String[] args) {

        File toDelete = new File("/Users/ruslanmuhametzanov/For 15 homework");
        deleteRecursive(toDelete);
        if (toDelete.exists()){
            System.out.println("Delete not successful");
        }
    }
    
    /**
     *
     * @param toDelete вызывает метод deleteRecursive, пока не удалятся все директории.
     */
    private static void deleteRecursive(File toDelete){
        if (toDelete.isDirectory()){
            File[] files = toDelete.listFiles();
            System.out.println(files);
            for (File file : files) {
                deleteRecursive(file);
            }
        }
        toDelete.delete();
    }
}

//        File file = new File("/First/Second/test");
//        System.out.println(file.getAbsolutePath());
//        File[] files = file.listFiles();
//        System.out.println(files);

//        if (new File("/For 15 homework").delete() &&
//            new File("/First").delete() &&
//            new File("/Second").delete() &&
//            new File("/test").delete()){
//
//            System.out.println("Удалены успешно");
//        }



//        deleteRecursive(toDelete);
//    }
//
//    private static void deleteRecursive(File toDelete) {
//        if (toDelete.isDirectory()) {
//            File[] files = toDelete.listFiles();
//            for (File file : files) {
//                deleteRecursive(file);
//            }
//        }
//        toDelete.delete();
