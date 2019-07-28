package magiccards.config;

import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.HystrixCommandProperties;

@Configuration
public class ApplicationConfig {
	
	ApplicationConfig() {
		HystrixCommandProperties.Setter().withExecutionTimeoutEnabled(false);
	}

}
