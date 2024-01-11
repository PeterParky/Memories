package app.main.memories.activities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MemoryDateCalc implements Serializable {

	int year, month, day;
	long totalday, DatedDay;
	private String inputDate;
	private LocalDate anniversaryDate, today;
	private Period timeUntilAnniversary;


	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public Period getTimeUntilAnniversary() {
		return timeUntilAnniversary;
	}

	public void setTimeUntilAnniversary(Period timeUntilAnniversary) {
		this.timeUntilAnniversary = timeUntilAnniversary;
	}

	// Input the anniversary date from the user
	public MemoryDateCalc (int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.inputDate = year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
	}

	public long DatedDay_Calc() {
		// Convert the string to a LocalDate
		anniversaryDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);

		// Get today's date
		today = LocalDate.now();

		// Calculate the dated day
		DatedDay = ChronoUnit.DAYS.between(anniversaryDate, today.plusDays(1));

		return DatedDay;
	}
	
	public long Day_Calc() {
		// Convert the string to a LocalDate
		LocalDate new_anniversaryDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
		
		// Get today's date
		today = LocalDate.now();

		// Calculate the period from today to the anniversary
		timeUntilAnniversary = Period.between(today, new_anniversaryDate);

		// Display the days left until the anniversary
		while (timeUntilAnniversary.isNegative()) {
			new_anniversaryDate = new_anniversaryDate.plusYears(1);
			timeUntilAnniversary = Period.between(today, new_anniversaryDate);
		}
		totalday = ChronoUnit.DAYS.between(today, new_anniversaryDate);
		
		return totalday;
	}
}
