package CRUD;

import FileSystem.FileSystem;

public class UpdateFile {
    private static FileSystem documents = new FileSystem();

    public static void updateFile(String fileName, String newFileName, String newData) {

        if(newFileName.toLowerCase().equals("no")) {
            documents.fileMap.get(fileName).updateFile(null, newData);
            return;
        }

        if(newData.toLowerCase().equals("no")) {
            documents.fileMap.get(fileName).updateFile(newFileName, null);
            return;
        }

        documents.fileMap.get(fileName).updateFile(newFileName, newData);

    }
}