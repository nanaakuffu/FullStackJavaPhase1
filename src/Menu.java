public class Menu {
    public static void printMainMenu() {
        System.out.println("Welcome to LockMe App:\n" +
                "Please select any of the options below to continue.\n" +
                "1. List files.\n" +
                "2. File actions.\n" +
                "0. Close the app.\n");

        System.out.print("Enter your choice: ");
    }

    public static void printActionMenu() {
        System.out.println("Please select any of the options below to continue.\n" +
                "3. Add a file.\n" +
                "4. Delete a file.\n" +
                "5. Search for a file.\n" +
                "99. Return to main manu.\n");

        System.out.print("Select Action: ");
    }
}
