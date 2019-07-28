package magiccards.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.netflix.hystrix.HystrixCommandProperties;

@SpringBootApplication
@EnableFeignClients
public class MagicCardsUiApplication {
    public static void main(String[] args) {
    	HystrixCommandProperties.Setter().withExecutionTimeoutEnabled(false);
        SpringApplication.run(MagicCardsUiApplication.class, args);
    }
}