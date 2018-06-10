package model;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	public String getMsg() {
		return "Welcome";
	}
	public String getSecret() {
		return "https://webchat.botframework.com/embed/BrIAnsaveBotQnA?s=pxLDKy-qai0.cwA.djw.-jxWojWVoMgjuIXc7mkKsHmnfCgEy4eha-olUSqA7IQ";
	}
}