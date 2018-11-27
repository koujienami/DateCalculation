package product.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import product.domain.DateFormula;
import product.mapper.DateFormulaRepository;

/**
 * 日付計算に関わる処理を行うサービスです。
 * 
 * @author koujienami
 */
@Service
public class CalculationService {

	/** 日付計算式リポジトリ */
	@Autowired
	private DateFormulaRepository repository;

	/**
	 * 日付計算式の一覧を全件検索して取得します。
	 * 
	 * @return 日付計算式の全件
	 */
	public List<DateFormula> search() {
		return repository.select();
	}

	/**
	 * 日付計算式を登録します。
	 * 
	 * @param formula 登録する日付計算式
	 */
	@Transactional
	public void register(DateFormula formula) {
		repository.insert(formula);
	}

	/**
	 * 日付計算を行います。<br/>
	 * 計算基準日をベースに、日付計算式の加減値に基づいて計算を行います。<br/>
	 * 計算後の書式は「yyyyMMdd」の文字列となります。
	 * 
	 * @param baseDate 計算基準日
	 * @param formula 日付計算式
	 * @return 計算結果
	 */
	public String calculate(String baseDate, DateFormula formula) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate calculatedDate =
			date.plusYears(formula.getAdjustmentYear()).plusMonths(formula.getAdjustmentMonth()).plusDays(formula.getAdjustmentDay());
		return calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}
}
