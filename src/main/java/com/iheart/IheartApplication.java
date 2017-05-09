package com.iheart;

import com.iheart.model.Customer;
import com.iheart.service.CustomerService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iheart.repository")
public class IheartApplication {

	public static void main(String[] args) {
		SpringApplication.run(IheartApplication.class, args);
	}

}
