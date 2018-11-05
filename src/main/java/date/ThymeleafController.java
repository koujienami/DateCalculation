package date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // (1)
public class ThymeleafController {

	@RequestMapping("/thdemo")
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("msg", "コントローラーからテンプレートに値を渡す"); // (2)

		mav.setViewName("thdemo"); // (3)
		return mav;
	}

}
