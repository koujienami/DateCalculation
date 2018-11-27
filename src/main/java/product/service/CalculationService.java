package product.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import product.domain.DateFormula;
import product.mapper.DateFormulaMapper;

@Service
public class CalculationService {

	@Autowired
	private DateFormulaMapper dateMaster;

	public List<DateFormula> search() {
		return dateMaster.select();
	}

	@Transactional
	public void register(DateFormula bean) {
		dateMaster.insert(bean);
	}

	public String calculate(String baseDate, DateFormula bean) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate calculatedDate = date.plusYears(bean.getAdjustmentYear()).plusMonths(bean.getAdjustmentMonth()).plusDays(bean.getAdjustmentDay());
		return calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}
}
