package CRUD;

import FileSystem.FileSystem;
import FileSystem.Document;

import java.util.Set;

public class ReadFile {
    private static FileSystem documents = new FileSystem();

    public static String displayFiles() {

        Set<String> fileNames = documents.fileMap.keySet();

        return fileNames.toString();

    }
    public static String readFile(String fileName) {
        Document data = documents.fileMap.get(fileName);
        return data.getFileData();
    }
}
