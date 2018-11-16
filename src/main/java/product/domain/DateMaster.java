package product.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.StringJoiner;

public class DateMaster {

	private String dateId;
	private String dateName;
	private int adjustmentYear;
	private int adjustmentMonth;
	private int adjustmentDay;
	private String calculated;

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public int getAdjustmentYear() {
		return adjustmentYear;
	}

	public void setAdjustmentYear(int adjustmentYear) {
		this.adjustmentYear = adjustmentYear;
	}

	public int getAdjustmentMonth() {
		return adjustmentMonth;
	}

	public void setAdjustmentMonth(int adjustmentMonth) {
		this.adjustmentMonth = adjustmentMonth;
	}

	public int getAdjustmentDay() {
		return adjustmentDay;
	}

	public void setAdjustmentDay(int adjustmentDay) {
		this.adjustmentDay = adjustmentDay;
	}

	public String getCalculated() {
		return calculated;
	}

	public void calculate(String baseDate) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate calculatedDate = date.plusYears(adjustmentYear).plusMonths(adjustmentMonth).plusDays(adjustmentDay);
		calculated = calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	public String getFormula() {
		int[] formula = {getAdjustmentYear(), getAdjustmentMonth(), getAdjustmentDay()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(formula).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}
}
