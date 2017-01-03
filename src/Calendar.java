import java.time.DateTimeException;
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
     */
    public Calendar() {
        this.mDate = LocalDate.now();
    }
    /**
     * Constructs a new Calendar for date in params.
     * @param day - day of month.
     * @param month - month of year.
     * @param year - year.
     */
    public Calendar(int day, int month, int year){
    	try { 
    		this.mDate=LocalDate.of(year, month, day);
    	} catch (DateTimeException e) {
            System.out.print(e.toString());
        }
    }

    /**
     * Print short names of days.
     */
    @Override
    public void printDays() {
        for (DayOfWeek e : DayOfWeek.values()) {
            if (e == DayOfWeek.SATURDAY) {
                System.out.print(String.format("\033[31m%5s",
                        e.toString().substring(0, 3)));
            } else if (e == DayOfWeek.SUNDAY) {
                System.out.println(String.format("\033[31m%5s",
                        e.toString().substring(0, 3)));
            } else {
                System.out.print(String.format("\033[32m%5s",
                        e.toString().substring(0, 3)));
            }
        }
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
        if (day.getDayOfMonth() == mDate.getDayOfMonth()) {
            System.out.print(String.format("\033[35m%5d", day.getDayOfMonth()));
        } else if (day.getDayOfWeek() == DayOfWeek.SATURDAY
                || day.getDayOfWeek() == DayOfWeek.SUNDAY) {
            System.out.print(String.format("\033[31m%5d", day.getDayOfMonth()));
        } else {
            System.out.print(String.format("\033[32m%5d", day.getDayOfMonth()));
        }

        if (day.getDayOfWeek() == DayOfWeek.SUNDAY) {
            System.out.println();
        }
    }

    /**
     * Prints calendar for date, which is in mDate.
     */
    @Override
    public void outputCalendar() {
    	try {
            this.printMonthAndYear();
            this.printDays();
            this.printTable();
        } catch (NullPointerException e) {
            System.out.print(e.toString());
        }
    }
    /**
     * Return blank spaces for days of week, which don't print.
     * @param day - day of week.
     * @return blank spaces
     */
    private String getSpaceBeforeDays(DayOfWeek day) {
        return String.format("%-" + ((day.getValue() - 1) * 5) + "s", "");
    }
}
