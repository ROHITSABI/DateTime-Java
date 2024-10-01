package dateTime;

public class DateWithTime {
    private Date date;
    private Time time;

    // Constructor for random date and time
    public DateWithTime() {
        this.date = new Date(); // Default value (1 January 2023)
        this.time = new Time(); // Default value (12:00 PM)
    }

    // Constructor for specific date and time strings
    public DateWithTime(String dateWithTimeString) {
        // Split the input into date and time parts
        String[] parts = dateWithTimeString.trim().split(" ", 2); // Split into two parts only
        if (parts.length == 2) {
            this.date = new Date(parts[0].trim()); // Handle date formats
            this.time = new Time(parts[1].trim()); // Handle time formats
        } else {
            throw new IllegalArgumentException("Input must contain both date and time.");
        }
    }

    // Constructor for random date and time
    public DateWithTime(boolean random) {
        if (random) {
            this.date = new Date(true); // Random date
            this.time = new Time(true); // Random time
        } else {
            this.date = new Date(); // Default value
            this.time = new Time(); // Default value
        }
    }

    // toString method
    @Override
    public String toString() {
        return date.toString() + " " + time.toString();
    }
}
