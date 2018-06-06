package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WelcomeService {
	public String getMsg() {
		return "Welcome";
	}
	public String getSecret() {
		return "https://webchat.botframework.com/embed/BrIAnsaveBotQnA?s=pxLDKy-qai0.cwA.djw.-jxWojWVoMgjuIXc7mkKsHmnfCgEy4eha-olUSqA7IQ";
	}
}