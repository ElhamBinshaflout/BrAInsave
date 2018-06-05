package controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.WelcomeService;

@Controller
public class WelcomeController {

	private final WelcomeService welcomeService;

	@Autowired
	public WelcomeController(WelcomeService welcomeService) {
		this.welcomeService = welcomeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		model.put("msg", welcomeService.getMsg());
		
		return "index";
	}
}