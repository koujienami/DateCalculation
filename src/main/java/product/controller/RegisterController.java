package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import product.domain.DateFormula;
import product.service.CalculationService;

@Controller
public class RegisterController {

	@Autowired
	private CalculationService service;

	@RequestMapping("/register")
	public String index(DateFormula form) {
		return "register";
	}

	@RequestMapping(value = "/register", params = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute DateFormula form, Model model) {
		service.register(form);
		return "forward:/";
	}
}
