package carloanservicealiyunoss.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"com.carloan.oss"

})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableCircuitBreaker
@EnableEurekaClient
@EnableHystrixDashboard
public class CarloanServiceAliyunossApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarloanServiceAliyunossApplication.class, args);
	}
}
