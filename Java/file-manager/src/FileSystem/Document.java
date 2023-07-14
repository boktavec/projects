package FileSystem;

import java.time.LocalDate;

public class Document {
    private String fileName;
    private LocalDate dateCreated;
    private String fileData;

    public Document(String fileName, String fileData) {

        this.fileName = fileName;
        this.dateCreated = LocalDate.now();;
        this.fileData = fileData;
    }

    public String getFileName() {
        return fileName;
    }


    public String getFileData() {
        return fileData;
    }

    @Override
    public String toString() {
        return "{" +
                "fileName='" + fileName + '\'' +
                ", dateCreated=" + dateCreated +
                ", fileData='" + fileData + '\'' +
                '}';
    }

    public void updateFile(String newFileName, String updatedFileData) {
        if(newFileName == null) {
            this.dateCreated = LocalDate.now();
            this.fileData = updatedFileData;
            return;
        }
        if (updatedFileData == null) {
            this.fileName = newFileName;
            this.dateCreated = LocalDate.now();
            return;
        }

        this.fileName = newFileName;
        this.dateCreated = LocalDate.now();
        this.fileData = updatedFileData;


    }
}
