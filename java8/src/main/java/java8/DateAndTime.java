package java8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateAndTime {
	public static void main(String[] args){
		LocalDate ld = LocalDate.of(1999, 1, 1);
		System.out.println("ld:" + ld);
		Period period = Period.between(ld, LocalDate.now());
		System.out.println("period: " + period.getYears());
		
		LocalDate nextTeuesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("next Tueesday:" + nextTeuesday);
		
		
		LocalTime lt = LocalTime.of(11, 20).plusHours(4);
		System.out.println("lt: " + lt);
		
		ZonedDateTime zdt = ZonedDateTime.of(2014, 1, 30, 12, 30, 40, 0, ZoneId.of("Europe/Warsaw"));
	
		System.out.println("zdt: " + zdt);
		
		
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(zdt) +  "");
		
		
		;
		Date.from(Instant.now());
		new Date().toInstant();
		
		//new Date().toL
		
	}
}
