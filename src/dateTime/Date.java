package dateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.ThreadLocalRandom;

public class Date {
    private LocalDate date;

    // Constructor for date as a string (supports various formats)
    public Date(String dateString) throws DateTimeParseException {
        // Support for multiple date formats
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("[dd/MM/yyyy][d/MM/yyyy][dd MMM yyyy][d MMM yyyy][dd MMMM yyyy][d MMMM yyyy]");
        this.date = LocalDate.parse(dateString, formatter);
    }

    // Default constructor with reasonable value
    public Date() {
        this.date = LocalDate.of(2023, 1, 1); // Reasonable default value
    }

    // Constructor for random date
    public Date(boolean random) {
        if (random) {
            this.date = generateRandomDate();
        } else {
            this.date = LocalDate.of(2023, 1, 1); // Reasonable default value
        }
    }

    // Generate a random date between 2000 and 2024
    private LocalDate generateRandomDate() {
        long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2024, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    // Accessors
    public int getDay() {
        return date.getDayOfMonth();
    }

    public int getMonth() {
        return date.getMonthValue();
    }

    public int getYear() {
        return date.getYear();
    }

    // toString method
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return date.format(formatter);
    }
}