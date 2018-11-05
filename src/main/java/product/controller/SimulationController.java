package product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimulationController {

	@RequestMapping("/simulation")
	public String simulation(Model model) {
		model.addAttribute("message", "Hello Thymeleaf!!");
		return "simulation";
	}
}
