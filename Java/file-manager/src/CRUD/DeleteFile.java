package CRUD;

import FileSystem.FileSystem;

public class DeleteFile {
    private static FileSystem documents = new FileSystem();

    public static void deleteFile(String fileName) {
        documents.fileMap.remove(fileName);

    }
}
