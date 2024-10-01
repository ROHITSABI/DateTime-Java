package dateTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.ThreadLocalRandom;

public class Time {
    private LocalTime time;

    // Constructor for time as a string (supports both 12-hour and 24-hour formats)
    public Time(String timeString) throws DateTimeParseException {
        // Support for multiple time formats including 12-hour, 24-hour, and variants of
        // am/pm
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("[h:mma][h:mm a][hh:mma][hh:mm a][HHmm][HH:mm:ss][HH:mm]");
        this.time = LocalTime.parse(timeString.toLowerCase().replaceAll(" ", ""), formatter);
    }

    // Default constructor with reasonable value
    public Time() {
        this.time = LocalTime.of(12, 0); // Reasonable default value (12:00 PM)
    }

    // Constructor for random time
    public Time(boolean random) {
        if (random) {
            this.time = generateRandomTime();
        } else {
            this.time = LocalTime.of(12, 0); // Reasonable default value (12:00 PM)
        }
    }

    // Generate a random time
    private LocalTime generateRandomTime() {
        int randomHour = ThreadLocalRandom.current().nextInt(0, 24);
        int randomMinute = ThreadLocalRandom.current().nextInt(0, 60);
        int randomSecond = ThreadLocalRandom.current().nextInt(0, 60);
        return LocalTime.of(randomHour, randomMinute, randomSecond);
    }

    // Getters for hours, minutes, and seconds
    public int getHour() {
        return time.getHour();
    }

    public int getMinute() {
        return time.getMinute();
    }

    public int getSecond() {
        return time.getSecond();
    }

    // toString method
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return time.format(formatter);
    }
}