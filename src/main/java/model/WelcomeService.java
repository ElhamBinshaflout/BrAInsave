package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WelcomeService {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeService.class);

	public String getMsg() {
		logger.debug("getMsg() is executed!");
		return "Welcome";

	}
}