package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import product.domain.DateFormula;
import product.service.CalculationService;

/**
 * 日付計算処理を新規登録する画面に紐づくコントローラーです。
 * 
 * @author koujienami
 */
@Controller
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
	@RequestMapping("/register")
	public String index(DateFormula form) {
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
	@RequestMapping(value = "/register", params = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute DateFormula form) {
		service.register(form);
		return "forward:/";
	}
}
