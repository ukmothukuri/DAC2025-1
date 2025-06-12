package in.dac.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping()
	public String showHome() {
		return "index";
	}
	
	@GetMapping(path = "register")
	public ModelAndView showRegistration() 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
				
		mv.addObject("msg", "Welcome to registraion");
		return mv;
	}	
}
