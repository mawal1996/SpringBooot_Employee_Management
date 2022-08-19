package net.cruddemo.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication/*(exclude={DataSourceAutoConfiguration.class})*/
@ComponentScan(basePackages = {"net.cruddemo.springboot"})
public class SpringbootBackendApplication  {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

}


