package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.domain.DateFormula;
import product.domain.SimulationForm;
import product.service.CalculationService;

/**
 * 日付計算式を更新する画面に紐づくコントローラーです。
 * 
 * @author koujienami
 */
@Controller
@RequestMapping("/update/{dateId}")
public class UpdateController {

	/** 日付計算サービス */
	@Autowired
	private CalculationService service;

	/**
	 * 初期表示処理を行います。
	 * 
	 * @param form 画面フォーム
	 * @param model モデル
	 * @return 表示するテンプレート
	 */
	@GetMapping
	public String index(@PathVariable String dateId, Model model) {
		model.addAttribute("dateFormula", service.search(dateId));
		return "update";
	}

	/**
	 * 日付計算式を更新します。<br/>
	 * 更新した後は一覧画面へ戻ります。
	 * 
	 * @param form 画面フォーム
	 * @param model モデル
	 * @return 表示するテンプレート
	 */
	@PostMapping
	public String update(@ModelAttribute @Validated DateFormula form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "update";
		}

		service.update(form);
		model.addAttribute("simulationForm", new SimulationForm());
		return "simulation";
	}
}
