import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FIleOperations {

    private File[] getFilesInRepository() throws NullPointerException {
        File dir = new File("lockedme_files");

        File[] fileArray = null;

        if (dir.exists() && dir.isDirectory()) {
            fileArray = dir.listFiles();
        }

        return fileArray;
    }

    private List<String> listFIlesInDirectory() {
        List<String> files = new ArrayList<>();

        File[] fileArray = this.getFilesInRepository();

        if (fileArray != null) {

            for (File file : fileArray) {
                if (file.isFile()) {
                    files.add(file.getName());
                }
            }
        }

        return files;

    }

    public void printFileNames() {
        List<String> fileNames = this.listFIlesInDirectory();

        String response = "";

        if (fileNames.isEmpty()) {
            System.out.println(response + "Current file repository is empty. No file added.");
        }

        Collections.sort(fileNames);

        for (String fileName : fileNames) {
            response += fileName + "\n";
        }

        System.out.println(response);
    }

    private void createFile() {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("File name: ");

            String fileName = sc.next();

            String filePath = "lockedme_files/" + fileName + ".txt";

            File file = new File(filePath);

            if (file.exists()) {
                System.out.println("File already exists in repository.\n");
            } else {
                // ff.createNewFile();
                FileWriter fileWriter = new FileWriter(filePath);

                System.out.println("Enter file content. Press enter when done:");

                String fileContent = sc.next();

                fileWriter.write(fileContent);

                fileWriter.flush();

                fileWriter.close();

                System.out.println("File created...");
            }
        } catch (Exception e) {
            System.out.println("An error occured. Please try again.");
            sc.next();
        }
    }

    private void deleteFile() {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("File name to delete: ");

            String fileName = sc.next();

            String filePath = "lockedme_files/" + fileName + ".txt";

            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("File does not exist in repository.\n");
            } else {
                file.delete();
                System.out.println("File deleted...");
            }

        } catch (Exception e) {
            System.out.println("An error occured. Please try again.");
            sc.next();
        }
    }

    private void searchFile() {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("File name to search: ");

            String fileName = sc.next();

            String filePath = "lockedme_files/" + fileName + ".txt";
            File file = new File(filePath);

            if (file.exists()) {
                try {

                    Scanner filScanner = new Scanner(file);

                    while (filScanner.hasNextLine()) {
                        String data = filScanner.nextLine();
                        System.out.println(data);
                    }
                    filScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                }
            } else {
                System.out.println("File does not exist in repository.\n");
            }
        } catch (Exception e) {
            System.out.println("An error occured. Please try again." + e.getMessage());
            e.printStackTrace();
            sc.next();
        }
    }

    public void printDetails() {

        Menu.printActionMenu();

        Scanner sc = new Scanner(System.in);

        try {

            while (true) {
                String choice = sc.next();

                if (choice.equals("99")) {
                    System.out.println("Back to main menu.");
                    break;
                }

                switch (choice) {
                    case "3":
                        this.createFile();
                        break;

                    case "4":
                        this.deleteFile();
                        break;

                    case "5":
                        this.searchFile();
                        break;

                    default:
                        System.out.println("Invalid choice.\n");
                        break;
                }

                System.out.print("Enter your choice: ");
            }

        } catch (Exception e) {
            System.out.println("An error occurred during program execution.");
        }
    }
}
