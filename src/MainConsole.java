/**
 * The Calendar program implements an application that
 * displays a month calendar.
 *
 * @author  Lubko Oleskiv
 * @version 1.0
 * @since   2016-12-28
 */

public class MainConsole {
    /**
     * Creates a new controller and prints calendar for this month.
     * @param args - don't use.
     */
    public static void main (String[] args) {
        // Date format in this constructor (day:int, month:int, year:int)
        // or without parameters - returns current date.
        MonthCalendar controller = new Calendar(21,04,2017);
        controller.outputCalendar();
    }
}
