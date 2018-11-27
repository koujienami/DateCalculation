package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import product.domain.DateFormula;
import product.service.CalculationService;

/**
 * 日付計算式を更新する画面に紐づくコントローラーです。
 * 
 * @author koujienami
 */
@Controller
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
	@RequestMapping("/update/{dateId}")
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
	@RequestMapping(value = "/update/{dateId}", params = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute DateFormula form) {
		service.update(form);
		return "forward:/";
	}
}
