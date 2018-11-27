package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import product.domain.Result;
import product.domain.SimulationForm;
import product.service.CalculationService;

/**
 * 日付計算処理をシミュレートする画面に紐づくコントローラーです。
 * 
 * @author koujienami
 */
@Controller
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
	@RequestMapping("/")
	public String index(SimulationForm form) {
		return "simulation";
	}

	/**
	 * 日付計算式を元にシミュレーション結果を一覧表示します。
	 * 
	 * @param form 画面フォーム
	 * @param model モデル
	 * @return 表示するテンプレート
	 */
	@RequestMapping(value = "/", params = "simulation", method = RequestMethod.POST)
	public String simulation(@ModelAttribute SimulationForm form, Model model) {
		SimulationForm resultForm = new SimulationForm(form.getBaseDate(), service.search());
		List<Result> results = resultForm.getResults();

		results.stream().forEach(e -> e.setCalculated(service.calculate(form.getBaseDate(), e.getFormula())));

		model.addAttribute("results", results);
		return "simulation";
	}

	/**
	 * 日付計算式を元にシミュレーション結果を一覧表示します。
	 * 
	 * @param form 画面フォーム
	 * @param model モデル
	 * @return 表示するテンプレート
	 */
	@RequestMapping(value = "/{dateId}", params = "delete", method = RequestMethod.POST)
	public String delete(@PathVariable String dateId, Model model) {
		service.delete(dateId);
		return "forward:/";
	}
}
