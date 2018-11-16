package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import product.domain.DateMaster;
import product.domain.SimulationForm;
import product.mapper.DateMasterMapper;

@Controller
public class SimulationController {

	@Autowired
	private DateMasterMapper dateMaster;

	@RequestMapping("/")
	public String index(SimulationForm form) {
		return "simulation";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String simulation(@ModelAttribute SimulationForm form, Model model) {
		List<DateMaster> results = dateMaster.select();
		results.stream().forEach(e -> e.calculate(form.getBaseDate()));
		model.addAttribute("results", results);
		return "simulation";
	}
}
