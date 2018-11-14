package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import product.domain.DateMaster;
import product.mapper.DateMasterMapper;

@Controller
public class SimulationController {

	@Autowired
	private DateMasterMapper dateMaster;

	@RequestMapping("/simulation")
	public String simulation(Model model) {
		List<DateMaster> results = dateMaster.select();
		model.addAttribute("results", results);
		return "simulation";
	}
}
