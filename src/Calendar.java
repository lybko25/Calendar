import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * The Calendar class provides methods to create a month calendar for this date.
 */
public class Calendar implements MonthCalendar {
    /**
     * Class methods work with date, which is saved in mDate.
     */
    private LocalDate mDate;

    /**
     * Constructs a new Calendar for this date.
     * @param date - date on which creates a Calendar.
     */
    public Calendar(LocalDate date) {
        this.mDate = date;
    }

    /**
     * Print short names of days.
     */
    @Override
    public void printDays() {
        for (DayOfWeek e : DayOfWeek.values()) {
            if (e == DayOfWeek.SATURDAY
                    || e == DayOfWeek.SUNDAY) {
                System.out.print(String.format("\033[31m%5s",
                        e.toString().substring(0, 3)));
            } else {
                System.out.print(String.format("\033[32m%5s",
                        e.toString().substring(0, 3)));
            }
        }
        System.out.println();
    }

    /**
     * Prints name of month and year.
     */
    @Override
    public void printMonthAndYear() {
        System.out.println(String.format("\033[33m %24s",
                mDate.getMonth().toString() + " " + mDate.getYear()));
    }

    /**
     * Prints table of days for this month.
     */
    @Override
    public void printTable() {
        //Copies current date with the day of month is equal to 1.
        LocalDate DateCopy = LocalDate.of(mDate.getYear(), mDate.getMonth(), 1);

        System.out.print(getSpaceBeforeDays(DateCopy.getDayOfWeek()));

        for (int i = 1; i <= mDate.lengthOfMonth(); i++) {
            printDayOfWeek(DateCopy);
            //Increases current date on 1.
            DateCopy=DateCopy.plusDays(1);
        }
    }

    /**
     * Prints day of week.
     * If day is day in 'mDate', method uses another colour.
     * If day is 'Saturday' or 'Sunday', method uses another colour.
     * If day is 'Sunday', method adds new line.
     * @param day - day of month
     */
    private void printDayOfWeek(LocalDate day) {
        String outputText;

        if (day.getDayOfMonth() == mDate.getDayOfMonth()) {
            outputText = String.format("\033[35m%5d", day.getDayOfMonth());
        }
        else if (day.getDayOfWeek() == DayOfWeek.SATURDAY
                || day.getDayOfWeek() == DayOfWeek.SUNDAY) {
            outputText = String.format("\033[31m%5d", day.getDayOfMonth());
        }
        else {
            outputText = String.format("\033[32m%5d", day.getDayOfMonth());
        }

        if (day.getDayOfWeek() == DayOfWeek.SUNDAY) {
            System.out.println(outputText);
        }
        else {
            System.out.print(outputText);
        }
    }

    /**
     * Return blank spaces for days of week, which don't print.
     * @param day - day of week.
     * @return blank spaces
     */
    private String getSpaceBeforeDays(DayOfWeek day) {
        switch (day) {
            case MONDAY: {
                return String.format("");
            }
            case TUESDAY: {
                return String.format("%-5s","");
            }
            case WEDNESDAY: {
                return String.format("%-10s","");
            }
            case THURSDAY: {
                return String.format("%-15s","");
            }
            case FRIDAY: {
                return String.format("%-20s","");
            }
            case SATURDAY: {
                return String.format("%-25s","");
            }
            case SUNDAY: {
                return String.format("%-30s","");
            }
            default: {
                return String.format("");
            }
        }
    }
}
