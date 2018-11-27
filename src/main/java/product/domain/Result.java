package product.domain;

import java.util.Arrays;
import java.util.StringJoiner;

public class Result {

	private DateFormula result;
	private String calculated;

	public Result(DateFormula result) {
		this.result = result;
	}

	public String getDateId() {
		return result.getDateId();
	}

	public void setDateId(String dateId) {
		result.setDateId(dateId);
	}

	public String getDateName() {
		return result.getDateName();
	}

	public void setDateName(String dateName) {
		result.setDateName(dateName);
	}

	public int getAdjustmentYear() {
		return result.getAdjustmentYear();
	}

	public void setAdjustmentYear(int adjustmentYear) {
		result.setAdjustmentYear(adjustmentYear);
	}

	public int getAdjustmentMonth() {
		return result.getAdjustmentMonth();
	}

	public void setAdjustmentMonth(int adjustmentMonth) {
		result.setAdjustmentMonth(adjustmentMonth);
	}

	public int getAdjustmentDay() {
		return result.getAdjustmentDay();
	}

	public void setAdjustmentDay(int adjustmentDay) {
		result.setAdjustmentDay(adjustmentDay);
	}

	public String getCalculated() {
		return calculated;
	}

	public void setCalculated(String calculated) {
		this.calculated = calculated;
	}

	public String getFormula() {
		int[] formula = {getAdjustmentYear(), getAdjustmentMonth(), getAdjustmentDay()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(formula).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}

	public DateFormula getResult() {
		return result;
	}
}
