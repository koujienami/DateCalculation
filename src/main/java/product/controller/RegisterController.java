package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.domain.DateFormula;
import product.domain.SimulationForm;
import product.service.CalculationService;

/**
 * 日付計算式を新規登録する画面に紐づくコントローラーです。
 * 
 * @author koujienami
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

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
	public String index(@ModelAttribute DateFormula form) {
		return "register";
	}

	/**
	 * 日付計算式を新規登録します。<br/>
	 * 登録した後は一覧画面へ戻ります。
	 * 
	 * @param form 画面フォーム
	 * @param model モデル
	 * @return 表示するテンプレート
	 */
	@PostMapping
	public String register(@ModelAttribute @Validated DateFormula form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "register";
		}

		service.register(form);
		model.addAttribute("simulationForm", new SimulationForm());
		return "simulation";
	}
}
