import java.util.Scanner;

public class LockedMe {
    public static void main(String[] args) {

        Menu.printMainMenu();

        Scanner sc = new Scanner(System.in);

        try {

            FIleOperations files = new FIleOperations();

            while (true) {

                String choice = sc.next();

                if (choice.equals("0")) {
                    System.out.println("Closing the application.");
                    System.exit(0);
                }

                switch (choice) {
                    case "1":
                        files.printFileNames();
                        break;

                    case "2":
                        files.printDetails();
                        break;

                    default:
                        System.out.println("Wrong selection.\n");
                        break;
                }

                System.out.print("Enter your choice: ");
            }

        } catch (Exception e) {
            System.out.println("An error occurred during program execution.");
            sc.next();
        } finally {
            sc.close();
        }

    }
}