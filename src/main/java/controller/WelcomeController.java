package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.CognitiveService;
import model.WelcomeService;

@Controller
public class WelcomeController {

	private final WelcomeService welcomeService;
	private final CognitiveService cognitiveService;

	@Autowired
	public WelcomeController() {
		this.welcomeService = new WelcomeService();
		this.cognitiveService = new CognitiveService();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		String imgURL = "https://jiafengtrystorage.blob.core.windows.net/samples-workitems/patient1";
		
		model.put("msg", welcomeService.getMsg());
		model.put("secret", welcomeService.getSecret());
		model.put("img",imgURL);
		model.put("faceDetectionResult", cognitiveService.faceDetection(imgURL));
		
		return "index";
	}
}