package betterbanking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class OnlineBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingApplication.class, args);
	}
	@Bean
	public WebClient webClient() {
		return WebClient.builder()
			.baseUrl(baseUrl)
			.build();
	}
	//todo:double check the url
	@Value("${io.betterbanking.integration.url-base}")
	private String baseUrl;

}
