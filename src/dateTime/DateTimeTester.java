package dateTime;

import java.util.Scanner;

public class DateTimeTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Create a Date");
            System.out.println("2. Create a Time");
            System.out.println("3. Create a Date with Time");
            System.out.println("4. Generate Random Date and Time");
            System.out.println("5. Generate Default Random Date and Time");
            System.out.println("6. Create Random Date");
            System.out.println("7. Create Random Time");
            System.out.println("8. Create Random Date with Time");
            System.out.println("9. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDate(scanner);
                    break;
                case 2:
                    createTime(scanner);
                    break;
                case 3:
                    createDateWithTime(scanner);
                    break;
                case 4:
                    generateRandomDateTime();
                    break;
                case 5:
                    generateDefaultRandomDateTime();
                    break;
                case 6:
                    createRandomDate();
                    break;
                case 7:
                    createRandomTime();
                    break;
                case 8:
                    createRandomDateWithTime();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createDate(Scanner scanner) {
        System.out.println("Enter date (e.g. 03/09/2024 or 3 September 2024):");
        scanner.nextLine(); // Consume newline
        String dateString = scanner.nextLine();
        try {
            Date date = new Date(dateString);
            System.out.println("Created Date: " + date);
        } catch (Exception e) {
            System.out.println("Error creating Date: " + e.getMessage());
        }
    }

    private static void createTime(Scanner scanner) {
        System.out.println("Enter time (e.g. 0429, 04:29, or 4:29AM):");
        scanner.nextLine(); // Consume newline
        String timeString = scanner.nextLine();
        try {
            Time time = new Time(timeString);
            System.out.println("Created Time: " + time);
        } catch (Exception e) {
            System.out.println("Error creating Time: " + e.getMessage());
        }
    }

    private static void createDateWithTime(Scanner scanner) {
        System.out.println("Enter date and time (e.g. 03/09/2024 0429 or 3 September 2024 4:29AM):");
        scanner.nextLine(); // Consume newline
        String dateWithTimeString = scanner.nextLine();
        try {
            DateWithTime dateWithTime = new DateWithTime(dateWithTimeString);
            System.out.println("Created DateWithTime: " + dateWithTime);
        } catch (Exception e) {
            System.out.println("Error creating DateWithTime: " + e.getMessage());
        }
    }

    private static void generateRandomDateTime() {
        DateWithTime randomDateWithTime = new DateWithTime(true); // Random Date and Time
        System.out.println("Random Date with Time: " + randomDateWithTime);
    }

    private static void generateDefaultRandomDateTime() {
        DateWithTime defaultRandomDateWithTime = new DateWithTime(); // Default random Date and Time
        System.out.println("Default Random Date with Time: " + defaultRandomDateWithTime);
    }

    // Function to create a random Date
    private static void createRandomDate() {
        Date randomDate = new Date(true); // Random Date
        System.out.println("Random Date: " + randomDate);
    }

    // Function to create a random Time
    private static void createRandomTime() {
        Time randomTime = new Time(true); // Random Time
        System.out.println("Random Time: " + randomTime);
    }

    // Function to create a random DateWithTime
    private static void createRandomDateWithTime() {
        DateWithTime randomDateWithTime = new DateWithTime(true); // Random DateWithTime
        System.out.println("Random Date with Time: " + randomDateWithTime);
    }
}
