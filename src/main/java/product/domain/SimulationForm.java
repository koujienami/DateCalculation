package product.domain;

import java.util.ArrayList;
import java.util.List;

public class SimulationForm {

	private String baseDate;
	private List<Result> results;

	public SimulationForm() {
	}

	public SimulationForm(String baseDate, List<DateFormula> results) {
		this.baseDate = baseDate;
		this.results = new ArrayList<>();
		results.stream().forEach(r -> this.results.add(convertToResult(r)));
	}

	public String getBaseDate() {
		return baseDate;
	}

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result convertToResult(DateFormula dateMaster) {
		return new Result(dateMaster);
	}

}
