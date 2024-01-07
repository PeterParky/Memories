import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemoryDateCalc {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Input the anniversary date from the user
		System.out.print("Enter the anniversary date (in format yyyy-MM-dd): ");
		String inputDate = scanner.nextLine();

		// Convert the string to a LocalDate
		LocalDate anniversaryDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);

		// Get today's date
		LocalDate today = LocalDate.now();

		// Calculate the period from today to the anniversary
		Period timeUntilAnniversary = Period.between(today, anniversaryDate);
		Period DatedDay = Period.between(anniversaryDate, today);

		// Display the days left until the anniversary

		while (timeUntilAnniversary.isNegative()) {
			anniversaryDate = anniversaryDate.plusYears(1);
			timeUntilAnniversary = Period.between(today, anniversaryDate);
		}

		if (timeUntilAnniversary.isZero()) {
			System.out.println("Congratulations! Today is the anniversary date!");
		} else {
			int days = DatedDay.getDays();
			int months = DatedDay.getMonths();
			int years = DatedDay.getYears();

			System.out.println("Congratulations! You have been dated for " + years +
					" years, " + months
					+ " months, and " + days + " days.");

			days = timeUntilAnniversary.getDays();
			months = timeUntilAnniversary.getMonths();
			years = timeUntilAnniversary.getYears();

			System.out.println("There is " + years + " years, " + months
					+ " months, and " + days + " days left until your anniversary.");
		}

		scanner.close();
	}
}
