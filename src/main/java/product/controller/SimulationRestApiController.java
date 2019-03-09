package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import product.domain.DateFormula;
import product.domain.Result;
import product.domain.SimulationForm;
import product.service.CalculationService;

/**
 * 日付計算処理をシミュレートする画面に紐づくコントローラーです。
 * 
 * @author koujienami
 */
@RestController
@RequestMapping("/api")
public class SimulationRestApiController {

	/** 日付計算サービス */
	@Autowired
	private CalculationService service;

	/**
	 * 日付計算式の情報取得する。
	 * 
	 * @param 日付ID
	 * @return 表示するテンプレート
	 */
	@GetMapping(value = "{dateId}")
	public DateFormula getDateFormula(@PathVariable("dateId") String dateId) {
		return service.search(dateId);
	}

	/**
	 * 日付計算式を元にシミュレーション結果を一覧表示します。
	 * 
	 * @param baseDate 計算基準日
	 */
	@PostMapping(value = "{baseDate}")
	public List<Result> simulation(@PathVariable("baseDate") String baseDate) {
		SimulationForm resultForm = new SimulationForm(baseDate, service.search());
		List<Result> results = resultForm.getResults();

		results.stream().forEach(e -> e.setCalculated(service.calculate(baseDate, e.getFormula())));

		return results;
	}
}
