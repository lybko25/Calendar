import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * The CalendarController class provides method to print a month calendar.
 */
public class CalendarController {
    /**
     * A Calendar instance. Its methods print a month calendar.
     */
    private Calendar mCalendar;

    /**
     * Constructs a new CalendarController for current date.
     */
    public CalendarController() {
        mCalendar = new Calendar(LocalDate.now());
    }

    /**
     * Constructs a new CalendarController for date, which is in parameters.
     * @param day - day of month
     * @param month - month of year
     * @param year - year
     */
    public CalendarController (int day,int month,int year){
        try {
            mCalendar = new Calendar(LocalDate.of(year, month, day));
        } catch (DateTimeException e) {
            System.out.print(e.toString());
        }
    }

    /**
     * Prints calendar for date, which is in mCalendar.
     */
    public void outputCalendar() {
        try {
            mCalendar.printMonthAndYear();
            mCalendar.printDays();
            mCalendar.printTable();
        } catch (NullPointerException e) {
            System.out.print(e.toString());
        }
    }
}
