package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import product.domain.Result;
import product.domain.SimulationForm;
import product.service.CalculationService;

@Controller
public class SimulationController {

	@Autowired
	private CalculationService service;

	@RequestMapping("/")
	public String index(SimulationForm form) {
		return "simulation";
	}

	@RequestMapping(value = "/", params = "simulation", method = RequestMethod.POST)
	public String simulation(@ModelAttribute SimulationForm form, Model model) {
		SimulationForm resultForm = new SimulationForm(form.getBaseDate(), service.search());
		List<Result> results = resultForm.getResults();

		results.stream().forEach(e -> e.setCalculated(service.calculate(form.getBaseDate(), e.getResult())));

		model.addAttribute("results", results);
		return "simulation";
	}
}
