package CRUD;

import FileSystem.FileSystem;
import FileSystem.Document;


public class CreateFile {
    private FileSystem documents = new FileSystem();
    public void createFile(String fileName, String fileData) {

        Document file = new Document(fileName, fileData);
        documents.fileMap.put(file.getFileName(), file);

    }



}
