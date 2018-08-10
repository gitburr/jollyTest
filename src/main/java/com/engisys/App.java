package com.engisys;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import de.jollyday.Holiday;
import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;

public class App 
{
    public static void main( String[] args )
    {
    		
    }
    
	public static Set<LocalDate> setHolidays() {
		
		LocalDate test = LocalDate.now();
		
		@SuppressWarnings("deprecation")
		HolidayManager m = HolidayManager.getInstance(HolidayCalendar.NYSE);
		Set<Holiday> holidays = m.getHolidays(test.getYear());
		holidays.addAll(m.getHolidays(test.getYear() - 1));
		holidays.addAll(m.getHolidays(test.getYear()+1));
		TreeSet<LocalDate> holidayDates = new TreeSet<LocalDate>();
		for (Holiday h : holidays) {
			holidayDates.add(h.getDate());
		}
		
		return holidayDates;
	}
}
