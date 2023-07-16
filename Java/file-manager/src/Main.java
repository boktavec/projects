import CRUD.CreateFile;
import FileSystem.FileSystem;

import static CRUD.ReadFile.*;
import static CRUD.UpdateFile.*;
import static CRUD.DeleteFile.*;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CreateFile file = new CreateFile();
        file.createFile("tiger.pdf", "they're great");
        file.createFile("james.pdf", "lets go out");
        file.createFile("ex.pdf", "catch me outside");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do?\n\n1. Read a file\n2. Create a file\n3. Update a file\n4. Delete a file?\n5. Display file system\n6. Exit file system\n");
            int response = scanner.nextInt();
            scanner.nextLine();

            if(response == 1) {
                String fileNames = displayFiles();
                System.out.println(fileNames);
                System.out.println("What file do you want to read?");
                String fileSelection = scanner.nextLine();
                String fileToRead = readFile(fileSelection);
                System.out.println("\n" + fileToRead + "\n");
            }

            if(response == 2) {
                System.out.println("What is the name of the new document - include extension");
                String fileName = scanner.nextLine();
                System.out.println("What does the document say?");
                String fileData = scanner.nextLine();
                CreateFile newFile = new CreateFile();
                newFile.createFile(fileName, fileData);
                System.out.println(fileName + " has been created\n");
            }

            if(response == 3) {
                String filesToUpdate = displayFiles();
                System.out.println(filesToUpdate);
                System.out.println("Which file do you want to update?");
                String fileToUpdate = scanner.nextLine();
                System.out.println("Do you want to change the name? If so, enter the new name with the file extension - else enter no");
                String newFileName = scanner.nextLine();
                System.out.println("Do you want to change the file content? If so, enter the new content for the file - else enter no");
                String newFileContent = scanner.nextLine();
                updateFile(fileToUpdate, newFileName, newFileContent);
                System.out.println(fileToUpdate + " has been updated\n");
            }

            if(response == 4) {
                String filesToDelete = displayFiles();
                System.out.println(filesToDelete);
                System.out.println("Which file do you want to delete?");
                String fileToDelete = scanner.nextLine();
                deleteFile(fileToDelete);
                System.out.println(fileToDelete + " has been deleted\n");
            }

            if(response == 5) {
                FileSystem documents = new FileSystem();
                System.out.println("\n" + documents.fileMap + "\n");

            }

            if(response == 6) {
                System.out.println("Exiting the application");
                break;
            }
        }

    }
}
