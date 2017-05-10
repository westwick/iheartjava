package com.iheart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iheart.repository")
public class IheartApplication {

	public static void main(String[] args) {
		SpringApplication.run(IheartApplication.class, args);
	}

}
