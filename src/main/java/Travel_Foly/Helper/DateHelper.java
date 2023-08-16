package Travel_Foly.Helper;

import java.time.LocalDate;
import java.sql.Date;

public class DateHelper {
	public static Date addDaysToDate(Date date, int days) {
        LocalDate localDate = date.toLocalDate();
        LocalDate newLocalDate = localDate.plusDays(days);
        return Date.valueOf(newLocalDate);
    }
	public static java.util.Date converDateSql(Date date){
		
		return (java.util.Date) date;
	}
}
