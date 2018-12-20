package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.domain.Result;
import product.domain.SimulationForm;
import product.service.CalculationService;

/**
 * 日付計算処理をシミュレートする画面に紐づくコントローラーです。
 * 
 * @author koujienami
 */
@Controller
@RequestMapping
public class SimulationController {

	/** 日付計算サービス */
	@Autowired
	private CalculationService service;

	/**
	 * 初期表示処理を行います。
	 * 
	 * @param form 画面フォーム
	 * @return 表示するテンプレート
	 */
	@GetMapping
	public String index(@ModelAttribute SimulationForm form) {
		return "simulation";
	}

	/**
	 * 日付計算式を元にシミュレーション結果を一覧表示します。
	 * 
	 * @param form 画面フォーム
	 * @param model モデル
	 * @return 表示するテンプレート
	 */
	@PostMapping
	public String simulation(@ModelAttribute SimulationForm form, Model model) {
		SimulationForm resultForm = new SimulationForm(form.getBaseDate(), service.search());
		List<Result> results = resultForm.getResults();

		results.stream().forEach(e -> e.setCalculated(service.calculate(form.getBaseDate(), e.getFormula())));

		model.addAttribute("results", results);
		return "simulation";
	}

	/**
	 * 任意の日付計算式を削除します。
	 * 
	 * @param form 画面フォーム
	 * @param model モデル
	 * @return 表示するテンプレート
	 */
	@PostMapping(value = "/{dateId}")
	public String delete(@PathVariable String dateId, Model model) {
		service.delete(dateId);
		return "simulation";
	}
}
